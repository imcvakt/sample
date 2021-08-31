package com.example.projects.usecases.channels;

import com.example.projects.entities.Subscription;
import com.example.projects.repositories.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindSubscribedChannels {
    private final SubscriptionRepository subscriptionRepository;

    public List<Subscription> execute(String userId, String event) {
        return subscriptionRepository.findAllByUserIdAndEvent(userId, event);
    }

}
