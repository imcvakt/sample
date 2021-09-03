package com.example.projects.usecases.profile;

import com.example.projects.entities.Profile;
import com.example.projects.entities.ProfileSubscription;
import com.example.projects.repositories.ProfileSubscriptionRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindUserPreferences {
    private final ProfileSubscriptionRepository profileSubscriptionRepository;

    public Map<String, List<ProfileSubscription>> execute(List<String> users, Long eventId) {
        val profileSubscriptions = profileSubscriptionRepository
                .findPreferencesForUsersAndEvent(users, eventId);

        return groupProfileSubscriptionsByUser(profileSubscriptions);
    }

    private Map<String, List<ProfileSubscription>> groupProfileSubscriptionsByUser(List<ProfileSubscription> profileSubscriptions) {
        val profiles = profileSubscriptions.stream()
                .map(ProfileSubscription::getProfile)
                .collect(Collectors.toList());

        return profiles.stream()
                .collect(Collectors.toMap(Profile::getUserId, profile -> filterChannelsByUser(profile, profileSubscriptions)));
    }

    private List<ProfileSubscription> filterChannelsByUser(Profile profile, List<ProfileSubscription> profileSubscriptions) {
        return profileSubscriptions.stream()
                .filter(profileSubscription -> profileSubscription.getProfile().getUserId().equals(profile.getUserId()))
                .collect(Collectors.toList());
    }
}
