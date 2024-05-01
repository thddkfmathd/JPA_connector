package com.connector.connector_back.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "profiles")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @OneToOne(fetch= FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "company")
    private String company;

    @Column(name = "status")
    private String status;

    @Column(name = "location")
    private String location;

    @Column(name = "bio")
    private String bio;

    @Column(name = "website")
    private String website;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, orphanRemoval = true) // 참조를 당하는 쪽에서 읽기만 가능
    private List<Skills> skills = new ArrayList<>();

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL) // 참조를 당하는 쪽에서 읽기만 가능
    private List<Experience> experiences = new ArrayList<>();

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL) // 참조를 당하는 쪽에서 읽기만 가능
    private List<Education> educations = new ArrayList<>();

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "twitter", column = @Column(name = "twitter")),
            @AttributeOverride(name = "facebook", column = @Column(name = "facebook")),
            @AttributeOverride(name = "youtube", column = @Column(name = "youtube")),
            @AttributeOverride(name = "linkedin", column = @Column(name = "linkedin")),
            @AttributeOverride(name = "instagram", column = @Column(name = "instagram")),
    })
    private Links links;

    @Builder
    public Profile(Long id, User user, String company, String status, String location, String bio, String website, List<Skills> skills, List<Experience> experiences, List<Education> educations, Links links) {
        this.id = id;
        this.user = user;
        this.company = company;
        this.status = status;
        this.location = location;
        this.bio = bio;
        this.website = website;
        this.skills = skills;
        this.experiences = experiences;
        this.educations = educations;
        this.links = links;
    }
}
