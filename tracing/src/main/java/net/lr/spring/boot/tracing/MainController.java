package net.lr.spring.boot.tracing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.SpanAccessor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Demonatrate that top level REST calls are logged and that 
 * calls via RestTemplate are also added to the trace
 */
@RestController
public class MainController {
    private static final Logger LOG = LoggerFactory.getLogger(MainController.class);
    
    @Autowired
    SpanAccessor spanAccessor;
    
    @Autowired
    RestTemplate rest;
    
    @RequestMapping("/")
    String main() {
        LOG.info("main called");
        return rest.getForObject("http://localhost:8080/hello/Christian", String.class);
    }

}
