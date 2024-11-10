package de.hamburml;

import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class GreetingService {

    @Inject
    Tracer tracer;

    public String greeting() throws InterruptedException {
        Span span = tracer.spanBuilder("GreetingService.greeting").startSpan();

        try {
            Thread.sleep(50);
            return "hello";
        } finally {
            span.end();
        }
    }
}
