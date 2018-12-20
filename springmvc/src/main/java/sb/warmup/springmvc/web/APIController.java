package sb.warmup.springmvc.web;

import java.io.IOException;
import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

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
        return "keyword=" + keyword;
    }

    @RequestMapping(value = "/perf/{keyword}")
    public StreamingResponseBody perf(@PathVariable(value = "keyword") String keyword) {
        return new StreamingResponseBody() {
            @Override
            public void writeTo (OutputStream out) throws IOException {
                for (int i = 0; i < 1000; i++) {
                    out.write((Integer.toString(i) + " - ")
                                        .getBytes());
                    out.flush();
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }
}