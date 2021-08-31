package com.example.projects.usecases.notification;

import com.example.projects.entities.enums.ChannelEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SendTeamsNotification implements CreateNotificationStrategy {
    @Override
    public void create(List<?> channelDetails) {
        log.info("Envia pro teams {}", channelDetails);
    }

    @Override
    public ChannelEnum getStrategyName() {
        return ChannelEnum.TEAMS;
    }
}
