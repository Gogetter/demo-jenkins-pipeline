package dev.etimbuk.components;

import dev.etimbuk.models.response.RandomUserResponse;
import dev.etimbuk.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

import static java.net.URI.create;

@Slf4j
@Component
@Transactional
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class DataInitializer {
    @Value("${random-user.api}")
    private String randomUserApiUrl;

    private final RestTemplate restTemplate;
    private final UserRepository userRepository;

    @PostConstruct
    public void initializeData() {
        RandomUserResponse randomUserResponse =
                restTemplate.getForObject(create(randomUserApiUrl), RandomUserResponse.class);

        if (!randomUserResponse.getResults().isEmpty()) {
            userRepository.saveAll(randomUserResponse.getResults());
        }
    }
}
