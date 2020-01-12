package com.quizapp.springREST.configs;

import com.quizapp.springREST.controllers.WebSocketHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocketMessageBroker
@EnableScheduling
// Add this annotation to an @Configuration class to configure processing WebSocket requests
    public class WebSocketConfig implements WebSocketConfigurer {
        @Override
        public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
            registry.addHandler(new WebSocketHandler(), "/websocket");
        }
}

