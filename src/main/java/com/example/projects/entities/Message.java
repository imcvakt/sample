package com.example.projects.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    @Column(name = "NTF_MESSAGE")
    private String content;

    @Column(name = "NTF_LINK")
    private String link;

    @Column(name = "NTF_TITLE")
    private String title;
}
