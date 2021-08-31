package com.example.projects.entities;

import com.example.projects.entities.enums.ChannelEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
public class Channel {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private ChannelEnum name;

    @OneToMany(mappedBy = "channel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Teams> teams;

    @OneToMany(mappedBy = "channel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WebPush> wehPushs;

    public List<?> getDetails() {
        if(name == ChannelEnum.WEB_PUSH) {
            return wehPushs;
        }
        if(name == ChannelEnum.TEAMS) {
            return teams;
        }
        return null;
    }
}
