package com.example.projects.entities;

import com.example.projects.entities.enums.SubscriptionTypeEnum;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Subscription {

    @Id
    @GeneratedValue
    @Column(name = "SUB_ID")
    private Long id;

    @Column(name = "SUB_DISPLAY_NAME")
    private String displayName;

    @Column(name = "SUB_TYPE")
    @Enumerated(EnumType.STRING)
    private SubscriptionTypeEnum type;

    @Column(name = "SUB_SUBSCRIBED")
    private boolean subscribed;

    @Column(name = "USR_ID")
    private String userId;

    @Column(name = "SUB_LEGAL_ENTITY_ID")
    private String legalEntityId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "SUB_ID", nullable = false)
    private List<SubscriptionItem> items;

}
