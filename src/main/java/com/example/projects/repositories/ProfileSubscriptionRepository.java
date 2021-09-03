package com.example.projects.repositories;


import com.example.projects.entities.ProfileSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileSubscriptionRepository extends JpaRepository<ProfileSubscription, Long> {

    @Query("SELECT ps FROM ProfileSubscription ps " +
            "JOIN FETCH ps.event evt " +
            "JOIN FETCH ps.profile prf " +
            "JOIN FETCH ps.channel chn " +
            "LEFT JOIN FETCH chn.teams " +
            "LEFT JOIN FETCH chn.wehPushs wp " +
            "WHERE " +
            "evt.id = :eventId AND " +
            "prf.userId IN :users AND " +
            "prf.current = TRUE AND " +
            "wp.userId = prf.userId")
    List<ProfileSubscription> findPreferencesForUsersAndEvent(List<String> users, Long eventId);
}
