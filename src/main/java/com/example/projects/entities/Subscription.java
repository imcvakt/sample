package com.example.projects.entities;

import com.example.projects.entities.enums.ChannelEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Subscription {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    // another alternative would be mapping a @Column Long channelId,
    // creating and fill channelType according to the channel when creating a subscription

    @ManyToOne
    @JoinColumn(name = "teamsId")
    private Teams teams;

    @ManyToOne
    @JoinColumn(name = "webPushId")
    private WebPush webPush;

    @Column
    private String userId;

    public ChannelEnum getChannel() {
        if (!Objects.isNull(webPush)) {
            return ChannelEnum.WEB_PUSH;
        }
        if (!Objects.isNull(teams)) {
            return ChannelEnum.TEAMS;
        }
        return null;
    }

}
