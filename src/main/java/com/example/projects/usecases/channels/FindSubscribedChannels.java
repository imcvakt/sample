package com.example.projects.usecases.channels;

import com.example.projects.entities.Subscription;
import com.example.projects.entities.enums.ChannelEnum;
import com.example.projects.repositories.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindSubscribedChannels {
    private final SubscriptionRepository subscriptionRepository;

    public List<ChannelEnum> execute(String userId) {
        val subscriptions = subscriptionRepository.findAllByUserId(userId);
        return subscriptions.stream()
                .map(Subscription::getChannel)
                .collect(Collectors.toList());
    }

}
