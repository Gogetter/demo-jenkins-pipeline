package dev.etimbuk.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.etimbuk.models.User;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RandomUserResponse {
    private List<User> results;
}
