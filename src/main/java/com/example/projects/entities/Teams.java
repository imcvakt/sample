package com.example.projects.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "teams")
public class Teams {
    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private String webhook;

    @Embedded
    private ChannelInfo channelInfo;
}
