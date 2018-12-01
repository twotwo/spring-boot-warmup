package sb.warmup.springmvc.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class APIController {

    @RequestMapping("/")
    String home() {
        return "Let's Rock!";
    }

    @RequestMapping(value = "q/{keyword}", method = RequestMethod.GET)
    String query(@PathVariable("keyword") String keyword) {
        return "keyword="+keyword;
    }
}