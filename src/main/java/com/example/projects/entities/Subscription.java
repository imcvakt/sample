package com.example.projects.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Subscription {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private String userId;

    @Column
    private String event;

    @ManyToOne
    @JoinColumn(name = "channelId")
    private Channel channel;

}
