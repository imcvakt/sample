package com.example.projects.usecases.notification;

import com.example.projects.entities.Channel;
import com.example.projects.entities.enums.ChannelEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SendWebPushNotification implements CreateNotificationStrategy {
    @Override
    public void create(Channel channel) {
        log.info("Envia pro webpush {} {}", channel.getWehPushs().size(), channel.getWehPushs());
    }

    @Override
    public ChannelEnum getStrategyName() {
        return ChannelEnum.WEB_PUSH;
    }
}
