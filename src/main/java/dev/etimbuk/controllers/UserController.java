package dev.etimbuk.controllers;

import dev.etimbuk.models.User;
import dev.etimbuk.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.util.StringUtils.isEmpty;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAllUsers() {
        return ok(new ArrayList<>(userService.findAllUsers()));
    }

    @GetMapping(value = "/email/{emailAddress}")
    public ResponseEntity<User> findUserByEmail(@PathVariable final String emailAddress) {
        if (!isEmpty(emailAddress)) {
            return ok(Objects.requireNonNull(userService.findUserByEmail(emailAddress).orElse(null)));
        }

        return badRequest().build();
    }
}
