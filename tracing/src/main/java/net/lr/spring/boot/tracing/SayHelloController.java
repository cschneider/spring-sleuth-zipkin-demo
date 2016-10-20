package net.lr.spring.boot.tracing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.SpanAccessor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Demonstrate how to add a a parameter into the span as a tag
 */
@RestController
public class SayHelloController {
    private static final Logger LOG = LoggerFactory.getLogger(SayHelloController.class);
    
    @Autowired
    SpanAccessor spanAccessor;
    
    @RequestMapping("/hello/{name}")
    String sayHello(@PathVariable("name") String name) {
        Span span = spanAccessor.getCurrentSpan();
        span.tag("name", name);
        LOG.info("sayHello was called with " + name);
        return "Hello " + name;
    }

}
