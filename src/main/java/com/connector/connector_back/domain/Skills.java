package com.connector.connector_back.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "skills")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @ManyToOne(fetch= FetchType.LAZY, optional = false)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @Column(name = "name")
    private String name;

    @Builder
    public Skills(Long id, Profile profile, String name) {
        this.id = id;
        this.profile = profile;
        this.name = name;
    }
}
