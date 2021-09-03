package com.example.projects.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Profile {
    @Id
    @GeneratedValue
    @Column(name = "PRF_ID")
    private Long id;

    @Column(name = "PRF_NAME")
    private String name;

    @Column(name = "PRF_READONLY")
    private boolean readOnly;

    @Column(name = "PRF_CURRENT")
    private boolean current;

    @Column(name = "PRF_ACTIVE")
    private boolean active;

    @Column(name = "USR_ID")
    private String userId;

    @OneToMany(
            mappedBy = "profile",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<ProfileSubscription> subscriptions;

    @PrePersist
    @PreUpdate
    public void setSubscriptionsParent(){
        subscriptions.forEach(subscription -> subscription.setProfile(this));
    }
}
