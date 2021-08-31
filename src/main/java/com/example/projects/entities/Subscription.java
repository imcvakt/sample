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

    // nowadays with channel generic, we have only channels mapped into subscriptions

    /*

    A simplest approach would be just by accepting nullable fields.
    Ifs are necessary to identify the channel

     */

    @ManyToOne
    @JoinColumn(name = "teamsId")
    private Teams teams;

    @ManyToOne
    @JoinColumn(name = "webPushId")
    private WebPush webPush;

    // To avoid nullable fields
    // we could add a TYPE column to define which channel is that id

    //@Column
    //private Long channelId;

    @Column
    @Enumerated(EnumType.STRING)
    private ChannelEnum channel;

    @Column
    private String userId;

}
