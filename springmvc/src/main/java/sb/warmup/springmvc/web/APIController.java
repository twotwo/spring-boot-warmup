package sb.warmup.springmvc.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sb.warmup.springmvc.service.GeneralService;

@RestController
@RequestMapping("api")
public class APIController {
    private static Logger LOGGER = LoggerFactory.getLogger(APIController.class);

    @Autowired
    private GeneralService service;

    @RequestMapping("/")
    String home() {
        return "Let's Rock!";
    }

    @RequestMapping(value = "q/{keyword}", method = RequestMethod.GET)
    String query(@PathVariable("keyword") String keyword) {
        LOGGER.debug("keyword={}", keyword);
        return "keyword="+keyword;
    }
}