package com.example.projects.usecases.notification;

import com.example.projects.entities.enums.ChannelEnum;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Set;

@Component
public class CreateNotificationStrategyFactory {
    private final EnumMap<ChannelEnum, CreateNotificationStrategy> strategies = new EnumMap<>(ChannelEnum.class);

    public CreateNotificationStrategyFactory(Set<CreateNotificationStrategy> createNotificationStrategies) {
        createNotificationStrategies.forEach(strategy -> strategies.put(strategy.getStrategyName(), strategy));
    }

    public CreateNotificationStrategy findStrategy(ChannelEnum strategyName) {
        return strategies.get(strategyName);
    }
}



