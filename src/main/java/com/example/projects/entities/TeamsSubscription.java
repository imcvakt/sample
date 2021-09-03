package com.example.projects.entities;

import com.example.projects.entities.enums.SubscriptionTypeEnum;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamsSubscription {
    @Id
    @GeneratedValue
    @Column(name = "TSB_ID")
    private Long id;

    @Column(name = "TSB_TYPE")
    @Enumerated(EnumType.STRING)
    private SubscriptionTypeEnum type;

    @Column(name = "TSB_DESK_ID")
    private String deskId;

    @Column(name = "TSB_PRODUCT_GROUP_ID")
    private String productGroupId;

    @Column(name = "TSB_PRODUCT_ID")
    private String productId;

    @Column(name = "TSB_PRODUCT_GRADE_ID")
    private String productGradeId;

    @ManyToOne
    @JoinColumn(name = "MST_ID")
    private Teams teams;
}
