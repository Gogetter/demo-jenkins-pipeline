package dev.etimbuk.repos;

import dev.etimbuk.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, String> {
    @Query("SELECT u from User u where u.email = ?1")
    User findByEmail(String email);
}
