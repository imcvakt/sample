package com.example.projects.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@ToString
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Teams {
    @Id
    @GeneratedValue
    @Column(name = "MST_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CHN_ID")
    private Channel channel;

    @Column(name = "TCG_LINK")
    private String link;

    @Column(name = "TCG_LEGAL_ENTITY")
    private String legalEntityId;

    @Column(name = "TCG_CREATED_AT")
    private LocalDateTime createdAt;

    @Column(name = "TCG_CREATED_BY")
    private String createdBy;

    @Column(name = "TCG_UPDATED_AT")
    private LocalDateTime updatedAt;

    @Column(name = "TCG_UPDATED_BY")
    private String updatedBy;

    @OneToMany(mappedBy = "teams", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<TeamsSubscription> teamsSubscriptions;
}
