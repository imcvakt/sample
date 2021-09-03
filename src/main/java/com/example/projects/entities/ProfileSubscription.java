package com.example.projects.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileSubscription {

    @Id
    @GeneratedValue
    @Column(name = "PRS_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PRF_ID")
    private Profile profile;

    @ManyToOne
    @JoinColumn(name = "EVT_ID")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "CHN_ID")
    private Channel channel;
}
