package com.example.projects.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "channelId")
    private Channel channel;
}
