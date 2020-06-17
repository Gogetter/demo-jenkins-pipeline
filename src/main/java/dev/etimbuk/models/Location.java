package dev.etimbuk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

@Data
@Entity
@Table(name = "locations")
@JsonIgnoreProperties(ignoreUnknown = true, value = {"hibernateLazyInitializer", "handler"})
public class Location {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(fetch = LAZY, orphanRemoval = true, cascade = ALL)
    @JoinColumn(name = "streets_id")
    private Street street;

    private String city;
    private String state;
    private String country;
    private String postcode;
}
