package com.example.projects.entities;

import com.example.projects.entities.enums.ChannelEnum;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Channel {

    @Id
    @GeneratedValue
    @Column(name = "CHN_ID")
    private Long id;

    @Column(name = "CHN_NAME")
    @Enumerated(EnumType.STRING)
    private ChannelEnum name;

    @OneToMany(mappedBy = "channel", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Teams> teams;

    @OneToMany(mappedBy = "channel", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<WebPush> wehPushs;
}
