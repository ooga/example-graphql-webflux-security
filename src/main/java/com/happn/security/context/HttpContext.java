package com.happn.security.context;

import graphql.kickstart.spring.GraphQLSpringContext;
import lombok.Getter;
import org.dataloader.DataLoaderRegistry;
import org.springframework.security.core.Authentication;
import org.springframework.web.server.ServerWebExchange;

import javax.security.auth.Subject;
import java.util.Optional;

public class HttpContext implements GraphQLSpringContext, ContextWithAuthentication {

    private final GraphQLSpringContext graphQLSpringServerWebExchangeContext;

    @Getter
    private final Authentication authentication;

    public HttpContext(GraphQLSpringContext graphQLSpringServerWebExchangeContext, Authentication authentication) {
        this.graphQLSpringServerWebExchangeContext = graphQLSpringServerWebExchangeContext;
        this.authentication = authentication;
    }

    @Override
    public ServerWebExchange getServerWebExchange() {
        return graphQLSpringServerWebExchangeContext.getServerWebExchange();
    }

    @Override
    public Optional<Subject> getSubject() {
        return graphQLSpringServerWebExchangeContext.getSubject();
    }

    @Override
    public Optional<DataLoaderRegistry> getDataLoaderRegistry() {
        return graphQLSpringServerWebExchangeContext.getDataLoaderRegistry();
    }
}
