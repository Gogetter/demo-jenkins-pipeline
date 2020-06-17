package dev.etimbuk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

@Data
@Entity
@Table(name = "users")
@JsonIgnoreProperties(ignoreUnknown = true, value = {"hibernateLazyInitializer", "handler"})
public class User {
    @Id
    private String email;

    @JoinColumn(name = "names_id")
    @OneToOne(fetch = LAZY, orphanRemoval = true, cascade = ALL)
    private Name name;

    @JoinColumn(name = "locations_id")
    @OneToOne(fetch = LAZY, orphanRemoval = true, cascade = ALL)
    private Location location;

    @JoinColumn(name = "dob_id")
    @OneToOne(fetch = LAZY, orphanRemoval = true, cascade = ALL)
    private DateOfBirth dob;

    @JoinColumn(name = "pictures_id")
    @OneToOne(fetch = LAZY, orphanRemoval = true, cascade = ALL)
    private Picture picture;

    private String nat;
    private String gender;
}
