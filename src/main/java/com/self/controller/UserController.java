package com.self.controller;

import com.self.model.User;
import com.self.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<User> addUser(@RequestBody User user){
        return this.userService.save(user);
    }

    @DeleteMapping("/{id}")
    private Mono<ResponseEntity<String>> deleteUser(@PathVariable("id") String id){
        return this.userService.delete(id)
                .flatMap(user -> Mono.just(ResponseEntity.ok("Deleted Successfully")))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @PutMapping("/{id}")
    private Mono<ResponseEntity<User>> updateUser(@PathVariable("id") String id, @RequestBody User user) {
        return this.userService.update(id, user)
                .flatMap(u -> Mono.just(ResponseEntity.ok(u)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @GetMapping(value = "/")
    private Flux<User> findAll() {
        return this.userService.findAll();
    }

}
