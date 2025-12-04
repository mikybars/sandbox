import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final GreeterService greeterService;

    public HelloController(GreeterService greeterService) {
        this.greeterService = greeterService;
    }

    @GetMapping("/hello/{user}")
    public String hello(@PathVariable String user) {
        return greeterService.greet(user);
    }
}
