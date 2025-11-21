package com.example.chronicle_sidecar.filter;

import com.example.chronicle_sidecar.model.ChronicleEvent;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.UUID;

@Component
public class LoggingFilter implements GlobalFilter {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        long requestTime = System.currentTimeMillis();
        URI routedUri = exchange.getAttribute(ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR);
        String finalUrl = routedUri.toString();

        String method = exchange.getRequest().getMethod().name();

        return chain.filter(exchange).then(Mono.fromRunnable(() -> {

            int status = exchange.getResponse().getStatusCode().value();
            long responseTime = System.currentTimeMillis();

            ChronicleEvent event = new ChronicleEvent(
                    UUID.randomUUID().toString(),
                    finalUrl,
                    method,
                    status,
                    requestTime,
                    responseTime
            );

            kafkaTemplate.send("chronicle-events", new Gson().toJson(event));
        }));
    }
}
