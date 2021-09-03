package com.example.projects.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionItem {

    @Id
    @GeneratedValue
    @Column(name = "SUI_ID")
    private Long id;

    @Column(name = "SUI_DESK_ID")
    private String deskId;

    @Column(name = "SUI_PRODUCT_GROUP_ID")
    private String productGroupId;

    @Column(name = "SUI_PRODUCT_ID")
    private String productId;

    @Column(name = "SUI_PRODUCT_GRADE_ID")
    private String productGradeId;

}
