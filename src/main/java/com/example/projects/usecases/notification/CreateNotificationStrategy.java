package com.example.projects.usecases.notification;

import com.example.projects.entities.enums.ChannelEnum;

import java.util.List;

public interface CreateNotificationStrategy {
    void create(List<?> channelDetails);
    ChannelEnum getStrategyName();
}