package com.happn.resolvers;

import com.happn.repository.UserDto;
import com.happn.repository.UserRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {

    private final UserRepository userRepository;

    public Mono<List<UserDto>> users() {
        return userRepository.all();
    }
}
