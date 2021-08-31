package com.example.projects.entities;

import com.example.projects.entities.enums.ChannelEnum;
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

    @ManyToOne
    @JoinColumn(name = "teamsId")
    private Teams teams;

    @ManyToOne
    @JoinColumn(name = "webPushId")
    private WebPush webPush;

    @Column
    @Enumerated(EnumType.STRING)
    private ChannelEnum channel;

    @Column
    private String userId;

}
