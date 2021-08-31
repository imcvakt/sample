package com.example.projects.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "web_push")
public class WebPush {
    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private String playerId;

    @Column
    private String userId;

    @Embedded
    private ChannelInfo channelInfo;
}
