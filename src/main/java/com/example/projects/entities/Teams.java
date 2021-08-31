package com.example.projects.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "teams")
public class Teams {
    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private String webhook;

    @ManyToOne
    @JoinColumn(name = "channelId")
    private Channel channel;

}
