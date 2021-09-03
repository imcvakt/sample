package com.example.projects.usecases.subscription;

import com.example.projects.entities.Subscription;
import com.example.projects.repositories.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindUsersSubscribedTo {

    private final SubscriptionRepository subscriptionRepository;

    public List<String> execute(String legalEntityId, List<String> deskIds, String productGradeId) {
        val subscriptions = subscriptionRepository
                .findUsersSubscribedByLegalEntityAndDeskOrProductGrade(legalEntityId, deskIds, productGradeId);

        return subscriptions.stream().map(Subscription::getUserId).collect(Collectors.toList());
    }
}
