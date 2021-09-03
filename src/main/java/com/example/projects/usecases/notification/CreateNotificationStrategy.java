package com.example.projects.usecases.notification;

import com.example.projects.entities.Channel;
import com.example.projects.entities.enums.ChannelEnum;

public interface CreateNotificationStrategy {
    void create(Channel channel);
    ChannelEnum getStrategyName();
}