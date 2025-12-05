Este repo es el punto de partida para el siguiente laboratorio:

<a href="https://app.warp.dev/drive/notebook/-Git-Stacked-BranchesPRs-Lab-6BNYClIEwWHzXGWaK1qyQA">
  <img src="https://github.com/user-attachments/assets/be2cbf2e-84ff-40f7-b048-993af4db532c" alt="Follow tutorial in Warp">
</a>

(también disponible en formato Markdown en este mismo repo)

## 💡TL;DR

* Stacked branches/PRs es una metodología de trabajo en Git que busca segmentar la entrega de funcionalidad
* Aplica cuando las diferentes entregas o pull requests (PRs) dependen unas de otras
* Las PRs se deben integrar siempre en el mismo orden en el que se crearon, sin importar cuál se acabe primero
* La propagación de cambios de una PR al resto se lleva a cabo con rebase + push force
* Para evitar tener que propagar cada cambio manualmente N veces se usa rebase con `--update-refs` 
* `--update-refs` no es una bala de plata: aún queda resolver conflictos y actualizar el remoto
* Usar herramientas modernas con soporte nativo para stacked branches mejora mucho la experiencia

## ⛈️ El problema

1. Tengo una PR esperando revisión y para no quedarme parado empiezo el desarrollo de la siguiente, que **depende de la primera**.
2. Tengo una funcionalidad demasiado grande y la quiero segmentar entregando varias PRs para facilitar la revisión a mis compañeros.

Sea cual sea el caso, inevitablemente llega el momento en el que hay que incorporar cambios en alguna de esas PRs y entonces 
empiezan los problemas y los sudores fríos. ¿Te sientes identificado?

## ☂️ La solución

Stacked branches/PRs es un popular flujo de trabajo con Git que ayuda en la tarea de mantener un histórico alineado cuando se trabaja
con varias ramas o PRs dependientes unas de otras. Se puede usar conjuntamente con Gitflow, con Trunk-Based Development (TBD),
o en general con cualquier otro flujo conocido (es decir, no es un sustituto de aquellos).

La idea es montar una cadena de PRs, unas encima de otras (de ahí el nombre _stack_) donde cada una de ellas tiene como base 
la anterior.

![img.png](https://andrewlock.net/content/images/2022/stacked_branches_02.png)

Las diferentes PRs se deben ir cerrando luego en el mismo orden en el que se crearon (esto puede chocar con la naturalez LIFO que sugiere un stack).
Si usamos una plataforma como GitHub, esto no supone un problema, ya que al integrar una PR, suelen suceder dos cosas automáticamente:
se elimina la rama asociada y se ajusta la base de todas las PRs que apuntaban a esa rama a la rama principal (develop o main).

Como vemos, tanto Git como GitHub parecen favorecer el trabajar de esta manera 🌈🦄✨ ... ¿o no?

## 🌊 El problema... de la solución

Cuando tenemos una serie de PRs apiladas, la gestión de los cambios en cualquiera de ellas puede suponer verdaderos quebraderos de cabeza. Estos
cambios pueden llegar de diversas maneras:

- Cualquiera de las PRs del stack recibe cambios como respuesta al feedback.
- A la rama principal llega una nueva funcionalidad (commit) de otro compañero, y la política de la organización/cliente impide 
integrar cualquier PR que no esté sincronizada con su base.

  ![image.png](https://github.com/user-attachments/assets/a49a74a5-a494-4e90-adb6-618ad92ad9c6)

En ambos casos, actualizar una PR conlleva que las que están por encima se "desincronicen":

![image.png](https://github.com/user-attachments/assets/50e0f9b5-051f-48dd-aea2-690bba6baf8d)

## 🙃 La solución... del problema... de la solución

Volver a alinear el histórico se convierte entonces en una sucesión de operaciones rebase + push force:

```bash
git switch feature-xyz/part-1
git rebase main                 # suponemos que el cambio ha ocurrido en la rama principal
git push --force-with-lease origin feature-xyz/part-1

git switch feature-xyz/part-2
git rebase feature-xyz/part-1   # ojo que el segundo rebase ya no es con main
git push --force-with-lease origin feature-xyz/part-2

git switch feature-xyz/part-3
git rebase feature-xyz/part-2
git push --force-with-lease origin feature-xyz/part-3
```

> `--force-with-lease` es una variante menos agresiva de push force que no sobreescribe cambios que hayan hecho otros en el remoto 

Se intuye que este es un proceso arduo y propenso a errores, sobre todo si hay que repetirlo en más de una ocasión (¡y eso sin 
contar con que surjan los temidos _merge conflicts_!)

## ⭐ LA solución

Hacer rebase ya de por sí es una tarea ardua y llena de riesgos, pero si encima hay que hacerla N veces y con ramas en remoto... 🔫 

Por suerte, Git, a partir de la versión 2.38 introdujo una nueva opción en `rebase`: 

> [`--update-refs`](https://git-scm.com/docs/git-rebase#Documentation/git-rebase.txt---update-refs): Automatically force-update any branches that point to commits that are being rebased. Any branches that are checked out in a worktree are not updated in this way.

```bash
# one rebase to rule them all!
git switch feature-xyz/part-3   # rama superior ⬆︎
git rebase --update-refs main   # rama inferior ⬇︎
Successfully rebased and updated refs/heads/feature-xyz/part-3
Updated the following refs with --update-refs:
    refs/heads/feature-xyz/part-2  # <-- 🤩
    refs/heads/feature-xyz/part-1  # <-- 🤩
    
git push --force-with-lease origin feature-xyz/part-1 feature-xyz/part-2 feature-xyz/part-3
```

De hecho, ¿por qué no hacer que `--update-refs` sea el comportamiento predefinido de rebase?

```bash
git config --global rebase.updateRefs true
```

## 🧰 Tooling

Obviamente, este tutorial se basa en vanilla Git por razones puramente didácticas. En el día a día, somos pocos los
que recurrimos a la terminal para interactuar con Git directamente y en su lugar usamos IDEs u otras herramientas más visuales.

IntelliJ, por ejemplo, admite el flag `--update-refs` en el diálogo de rebase, aunque esto... sabe a poco:

![intellij support for stacked branches](https://github.com/user-attachments/assets/2b81971b-c172-46f8-8a57-e9585022d6a5)

Algunas otras herramientas con mejor soporte para stacked branches son:

* [Stacked Branches With Lazygit - YouTube](https://www.youtube.com/watch?v=M6S-9Y8peDY)
* [Stacked Branches | GitButler Docs](https://docs.gitbutler.com/features/branch-management/stacked-branches)


## 🌍 Enlaces interesantes

* [Working with stacked branches in Git is easier with --update-refs](https://andrewlock.net/working-with-stacked-branches-in-git-is-easier-with-update-refs/)
