package com.happn.security.jwt;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketSession;
import org.springframework.web.server.ServerWebExchange;

@Slf4j
@Component
public class TokenService {

    public Authentication getFrom(ServerWebExchange exchange) {
        val token = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        return getFrom(token);
    }

    public Authentication getFrom(WebSocketSession webSocketSession) {
        val token = (String) webSocketSession.getAttributes().get(HttpHeaders.AUTHORIZATION);
        return getFrom(token);
    }

    public Authentication getFrom(String token) {
        if (!"OK".equalsIgnoreCase(token)) {
            return createAnonymous();
        }

        return getAuthentication();
    }

    private AnonymousAuthenticationToken createAnonymous() {
        val anonymousAuthorities = AuthorityUtils.createAuthorityList("anonymous");
        val anonymousKey = "anonymousKey";

        return new AnonymousAuthenticationToken(anonymousKey, "anonymous", anonymousAuthorities);
    }

    private Authentication getAuthentication() {
        val authorities = AuthorityUtils.createAuthorityList("all_user_read");
        val principal = new User("ok", "", authorities);

        return new UsernamePasswordAuthenticationToken(principal, "token", authorities);
    }
}
