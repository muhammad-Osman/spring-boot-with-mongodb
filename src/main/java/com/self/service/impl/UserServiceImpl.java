package com.self.service.impl;

import com.self.model.User;
import com.self.repository.UserRepository;
import com.self.service.UserService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Mono<User> save(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public Mono<User> delete(String id) {
        return this.userRepository.findById(id)
                .flatMap(p -> this.userRepository.deleteById(p.getId()).thenReturn(p));
    }

    @Override
    public Mono<User> update(String id, User user) {
        return this.userRepository.findById(id).flatMap( u -> {
            user.setId(id);
            return save(user);
        }).switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public Mono<User> findById(String id) {
        return this.userRepository.findById(id);
    }
}
