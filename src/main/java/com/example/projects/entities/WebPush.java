package com.example.projects.entities;

import lombok.*;

import javax.persistence.*;

@ToString
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WebPush {
    @Id
    @GeneratedValue
    @Column(name = "WBP_ID")
    private Long id;

    @Column(name = "WBP_PLAYER_ID")
    private String playerId;

    @Column(name = "USR_ID")
    private String userId;

    @ManyToOne
    @JoinColumn(name = "CHN_ID")
    private Channel channel;
}
