***
**Antes de empezar**
- [ ] Tengo instalado el CLI de GitHub
***
Partimos de la base de un repositorio con una aplicación Spring Boot 🍃 recién creada con Spring Initializr\. El stack concreto es irrelevante para la prueba, está pensado solamente para simular un escenario real\. 
# Preparación
## Importar el proyecto
```warp-runnable-command
gh repo fork --clone mikybars/git-stacked-branches-prs-lab 
cd git-stacked-branches-prs-lab 

GH_USER=$(gh repo view --json owner --jq '.owner.login')
REPO=git-stacked-branches-prs-lab 
```
## Crear las stacked PRs
La primera PR implementa un controlador web que delega la lógica de saludo a un servicio, definido en forma de interfaz
```warp-runnable-command
gh pr create \
    --head 01-hello-controller \
    --base main \
    --title "feat(greeting): [PROJ-XYZ] Hello Controller" \
    --body "Implements HelloController"
```
La segunda PR implementa el servicio, por lo que depende de la primera
```warp-runnable-command
gh pr create \
    --head 02-hello-service \
    --base 01-hello-controller \
    --title "feat(greeting): [PROJ-XYZ] Hello Service" \
    --body "Implements GreeterService with exclamation mark"
```
## 📍Punto de situación
Si echamos un vistazo al histórico nada más crear las dos PRs, veremos que todas las ramas están alineadas
```warp-runnable-command
git log --graph --oneline --branches --decorate-refs="refs/heads"
```
# 🥞 Escenario 1: Feedback sobre la 1ra PR
## 💬 Feedback
Llega feedback a la 1ra PR en forma de comentario:
```warp-runnable-command
git switch 01-hello-controller

COMMIT_ID=$(git rev-parse 01-hello-controller)
PR=$(gh pr view --json number -q .number)

gh api \
  --method POST \
  repos/$GH_USER/$REPO/pulls/$PR/comments \
  -f body="The endpoint path should be \`/greet/{user}\` instead of \`/hello/{user}\`." \
  -f commit_id="$COMMIT_ID" \
  -f path="src/main/java/com/example/demo/HelloController.java" \
  -F line=14 \
  --jq '.html_url'
```
Implementamos el cambio sugerido:
```warp-runnable-command
patch src/main/java/com/example/demo/HelloController.java <<'EOF'
--- a/HelloController.java
+++ b/HelloController.java
@@ -11,7 +11,7 @@
         this.greeterService = greeterService;
     }
 
-    @GetMapping("/hello/{user}")
+    @GetMapping("/greet/{user}")
     public String hello(@PathVariable String user) {
         return greeterService.greet(user);
     }
 }
+EOF
EOF

git commit --all -m "Rename endpoint to /greet"
```
Y actualizamos el remoto:
```warp-runnable-command
git push origin 01-hello-controller
```
## 🤔 ¿Qué ha pasado con mis ramas?
Si ahora echamos un vistazo al histórico, observaremos que la rama de la 2a PR se ha desviado de la línea principal:
```warp-runnable-command
git log --graph --oneline --branches --decorate-refs="refs/heads"
```
## 🤔 ¿Qué ha pasado con mis PRs?
En la 1ra PR ya se han resuelto todos los comentarios y todos los checks están ✅
¡Lista para el merge\!
```warp-runnable-command
gh pr merge 01-hello-controller --squash
```
¿Y la 2a PR?
Al integrar la PR que estaba debajo de esta 2a PR han pasado varias cosas:
* Se eliminó automáticamente del remoto \(por configuración\) la rama que hacía de base de la 2a PR
* GitHub detectó este movimiento y reajustó la base a la rama default del repositorio
* En la 2a PR tenemos ahora un conflicto porque su histórico refleja una versión anterior del controller
## Solución: rebase \+ push force
```warp-runnable-command
git switch 02-hello-service
git rebase 01-hello-controller
git log --graph --oneline --branches --decorate-refs="refs/heads"
```
La 2a rama ya está alineada\.\.\. ¡pero en local\! 
```warp-runnable-command
git log --graph --oneline --all --decorate
```
Aún queda actualizar la rama remota
```warp-runnable-command
git push --force-with-lease origin 02-hello-service
```
☝🏼 **Recuerda**: el push tiene que ser con force porque rebase, a diferencia de merge, reescribe el histórico \(=genera commits con ids diferentes a los originales\)
☝🏼 `--force-with-lease` es una variante menos agresiva de push force que no sobreescribe cambios que hayan hecho otros en el remoto
Y finalmente integrar la última PR del stack 😌 \(☝🏼 recuerda hacer merge siempre en orden\)
```warp-runnable-command
gh pr merge 02-hello-service --squash
```
# 🥞 Escenario 2: Aterrizan otras PRs en main
```warp-runnable-command
git switch main
echo 'Playing around with git is so much fun!' >> README.md
# 💥 descomentar 👇🏼 para generar un cambio con conflictos 💥
# echo 'spring.profiles.active=standalone' >> src/main/resources/application.properties
git add .
git commit -m "doc: [PROJ-XYZ] Add README"
git push origin main
```
## 🤔 ¿Qué ha pasado con mis ramas?
Si ahora echamos un vistazo al histórico, observaremos que la rama principal se ha desmarcado de las otras
```warp-runnable-command
git log --graph --oneline --branches --decorate-refs="refs/heads"
```
## 🤔 ¿Qué ha pasado con mis PRs?
Las dos PRs parecen estar en condiciones de poder ser integradas\.\.\. ¿o no? ¿y si, como política de la compañía, además de los diferentes checks, es obligatorio que nuestra rama feature esté sincronizada con la rama principal?
```warp-runnable-command
gh api repos/$GH_USER/$REPO/rulesets --method POST --input - << 'EOF'
{
  "name": "Require status checks before merging",
  "target": "branch",
  "enforcement": "active",
  "bypass_actors": [],
  "conditions": {
    "ref_name": {
      "include": ["refs/heads/main"],
      "exclude": []
    }
  },
  "rules": [
    {
      "type": "required_status_checks",
      "parameters": {
        "required_status_checks": [
          {"context": "build"}
        ],
        "strict_required_status_checks_policy": true
      }
    }
  ]
}
EOF
```
```warp-runnable-command
gh pr merge 01-hello-controller --squash  # ❌
```
## Solución: rebase \+ push force
```warp-runnable-command
git switch 01-hello-controller
git rebase origin/main
# git push --force-with-lease origin 01-hello-controller
git log --graph --oneline --branches --decorate-refs="refs/heads"
```
```warp-runnable-command
git switch 02-hello-service
git rebase 01-hello-controller
# git push --force-with-lease origin 02-hello-service
git log --graph --oneline --branches --decorate-refs="refs/heads"
```
## Solución ⭐: rebase con `--update-refs`
Hacer N rebases cada vez que aterriza un nuevo cambio en main suena a demasiado trabajo\. ¿Es que no hay ningún atajo? 
Antes de ndad, vamos primero a deshacer los últimos cambios antes de reducir esos N rebases a 1 solo:
```warp-runnable-command
git switch main
git branch -f 01-hello-controller origin/01-hello-controller
git branch -f 02-hello-service origin/02-hello-service
git log --graph --oneline --branches --decorate-refs="refs/heads"
```
La magia 🔮 está en usar rebase con `--update-refs`\. El rebase en este caso se hace de la rama superior del stack \(`02-hello-service`\) → rama inferior del stack \(`main`\) :
```warp-runnable-command
git switch 02-hello-service
git rebase --update-refs origin/main
```
Ahora las ramas vuelven a estar alineadas pero, nuevamente, solo en local:
```warp-runnable-command
git log --graph --oneline --branches --decorate-refs="refs/heads"
```
Las ramas remotas no se han enterado todavía de los últimos cambios:
```warp-runnable-command
git log --graph --oneline --all --decorate
```
Después de ajustar la base y de resolver posibles conflictos, solo queda actualizar el remoto:
```warp-runnable-command
git push --force-with-lease origin 01-hello-controller 02-hello-service
```
Y por último, hacer merge en orden 😌:
```warp-runnable-command
gh pr merge 01-hello-controller --squash 
gh pr merge 02-hello-service --squash 
```
