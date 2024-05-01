package com.connector.connector_back.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@Getter
public class Links {
    private String twitter;
    private String facebook;
    private String youtube;
    private String linkedin;
    private String instagram;

    public Links(String twitter, String facebook, String youtube, String linkedin, String instagram) {
        this.twitter = twitter;
        this.facebook = facebook;
        this.youtube = youtube;
        this.linkedin = linkedin;
        this.instagram = instagram;
    }
}
