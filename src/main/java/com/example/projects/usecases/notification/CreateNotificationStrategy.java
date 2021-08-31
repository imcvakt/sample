package com.example.projects.usecases.notification;

import com.example.projects.entities.enums.ChannelEnum;

public interface CreateNotificationStrategy {
    void create();
    ChannelEnum getStrategyName();
}