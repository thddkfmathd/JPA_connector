package com.connector.connector_back.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name= "profile_image")
    private String profile_image;

    @Column(name= "email")
    private String email;

    @Column(name= "name")
    private String name;

    @Column(name= "password")
    private String password;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Builder

    public User(Long id, String profile_image, String email, String name, String password, LocalDate createdAt) {
        this.id = id;
        this.profile_image = profile_image;
        this.email = email;
        this.name = name;
        this.password = password;
        this.createdAt = createdAt;
    }
}
