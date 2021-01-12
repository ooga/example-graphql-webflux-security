package com.happn.security.context;

import com.happn.security.jwt.TokenService;
import graphql.kickstart.spring.GraphQLSpringContext;
import graphql.kickstart.spring.webflux.DefaultGraphQLSpringWebSocketSessionContext;
import graphql.kickstart.spring.webflux.DefaultGraphQLSpringWebfluxContextBuilder;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.reactive.socket.WebSocketSession;
import org.springframework.web.server.ServerWebExchange;

@AllArgsConstructor
public class ContextBuilder extends DefaultGraphQLSpringWebfluxContextBuilder {

    private final TokenService tokenService;

    @Override
    public DefaultGraphQLSpringWebSocketSessionContext build(WebSocketSession webSocketSession) {
        Authentication authentication = tokenService.getFrom(webSocketSession);
        return new WebsocketContext(webSocketSession, authentication);
    }

    @Override
    public GraphQLSpringContext build(ServerWebExchange serverWebExchange) {
        GraphQLSpringContext graphQLSpringContext = super.build(serverWebExchange);
        Authentication authentication = tokenService.getFrom(serverWebExchange);

        return new HttpContext(graphQLSpringContext, authentication);
    }
}
