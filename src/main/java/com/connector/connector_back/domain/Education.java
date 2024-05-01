package com.connector.connector_back.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;

@Entity
@Table(name = "educations")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @ManyToOne(fetch= FetchType.LAZY, optional = false)
    @JoinColumn(name = "profile_id")
    //엔터티 객체간 매핑 - 외래키 설정 어노테이션?
    private Profile profile;

    @Column(name = "school")
    private String school;

    @Column(name = "degree")
    private Integer degree;

    @Column(name = "major")
    private String major;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Builder
    public Education(Long id, Profile profile, String school, Integer degree, String major, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.profile = profile;
        this.school = school;
        this.degree = degree;
        this.major = major;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
