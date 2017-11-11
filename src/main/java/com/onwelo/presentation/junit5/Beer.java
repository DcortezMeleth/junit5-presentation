package com.onwelo.presentation.junit5;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "beer")
public class Beer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Access(AccessType.PROPERTY)
    private Long id;

    @Version
    @JsonIgnore
    private long version;

    private String name;

    private String brand;

    /** volume in ml*/
    private int volume;

    /** alcohol in %*/
    private double alcohol;

    private LocalDateTime expirationDate;

    @NotNull
    private BeerType beerType;

    @Column(name = "aud_created_timestamp")
    @JsonIgnore
    LocalDateTime created;

    @Column(name = "aud_updated_timestamp")
    @JsonIgnore
    LocalDateTime updated;

    public Beer(String name, String brand, BeerType beerType, int volume, double alcohol) {
        this.name = name;
        this.brand = brand;
        this.beerType = beerType;
        this.volume = volume;
        this.alcohol = alcohol;
    }

    @PrePersist
    public void onCreate() {
        updated = created = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        updated = LocalDateTime.now();
    }
}
