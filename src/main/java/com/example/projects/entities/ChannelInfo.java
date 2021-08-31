package com.example.projects.entities;

import com.example.projects.entities.enums.ChannelEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@Embeddable
public class ChannelInfo {

    @Column
    @Enumerated(EnumType.STRING)
    private ChannelEnum name;
}
