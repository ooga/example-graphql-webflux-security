package com.happn.repository;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class UserRepository {
    private final List<UserDto> users;

    public UserRepository() {
        users = Stream.of(
                UserDto.builder()
                        .id("1")
                        .firstName("Jo")
                        .lastName("Ro")
                        .age(32)
                        .build(),
                UserDto.builder()
                        .id("2")
                        .firstName("Ba")
                        .lastName("Ga")
                        .age(38)
                        .build(),
                UserDto.builder()
                        .id("e6856a14-88f0-4c54-9f88-e3714c6ee830")
                        .firstName("Johan")
                        .lastName("Rouve")
                        .age(32)
                        .build(),
                UserDto.builder()
                        .id("b0d28976-1915-4a7e-9146-5055d2e760b3")
                        .firstName("Lotre")
                        .lastName("Mec")
                        .age(33)
                        .build()
        ).collect(Collectors.toList());
    }

    @PreAuthorize("hasRole('all_user_read')")
    public Mono<List<UserDto>> all() {
        return Mono.just(users);
    }
}
