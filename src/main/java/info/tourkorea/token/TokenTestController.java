package info.tourkorea.token;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenTestController {

    @GetMapping("/test")
    public void test(String token) {

    }

}
