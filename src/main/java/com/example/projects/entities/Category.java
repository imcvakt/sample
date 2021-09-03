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
public class Category {

    @Id
    @GeneratedValue
    @Column(name = "CAT_ID")
    private Long id;

    @Column(name = "CAT_NAME")
    private String name;

    @OneToMany
    @JoinColumn(name = "CAT_ID")
    private List<Event> events;
}
