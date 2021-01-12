package com.happn.security.context;

import graphql.kickstart.spring.webflux.DefaultGraphQLSpringWebSocketSessionContext;
import lombok.Getter;
import org.springframework.security.core.Authentication;
import org.springframework.web.reactive.socket.WebSocketSession;

public class WebsocketContext extends DefaultGraphQLSpringWebSocketSessionContext implements ContextWithAuthentication {

    @Getter
    private final Authentication authentication;

    public WebsocketContext(WebSocketSession webSocketSession, Authentication authentication) {
        super(webSocketSession);
        this.authentication = authentication;
    }
}
