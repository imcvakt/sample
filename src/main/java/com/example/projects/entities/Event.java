package com.example.projects.entities;

import com.example.projects.entities.enums.PermissionActionEnum;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    @Id
    @GeneratedValue
    @Column(name = "EVT_ID")
    private Long id;

    @Column(name = "EVT_NAME")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "EVT_PERMISSION_ACTION")
    private PermissionActionEnum permissionAction;
}
