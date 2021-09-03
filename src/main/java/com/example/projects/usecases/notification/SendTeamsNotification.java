package com.example.projects.usecases.notification;

import com.example.projects.entities.Channel;
import com.example.projects.entities.enums.ChannelEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SendTeamsNotification implements CreateNotificationStrategy {
    @Override
    public void create(Channel channel) {
        log.info("Envia pro teams {}", channel);
    }

    @Override
    public ChannelEnum getStrategyName() {
        return ChannelEnum.TEAMS;
    }
}
