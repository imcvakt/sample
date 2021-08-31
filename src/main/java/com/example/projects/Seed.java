package com.example.projects;

import com.example.projects.entities.Channel;
import com.example.projects.entities.Subscription;
import com.example.projects.entities.Teams;
import com.example.projects.entities.WebPush;
import com.example.projects.entities.enums.ChannelEnum;
import com.example.projects.repositories.ChannelRepository;
import com.example.projects.repositories.SubscriptionRepository;
import com.example.projects.repositories.TeamsRepository;
import com.example.projects.repositories.WebPushRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class Seed implements CommandLineRunner {
    private final TeamsRepository teamsRepository;
    private final WebPushRepository webPushRepository;
    private final SubscriptionRepository subscriptionRepository;
    private final ChannelRepository channelRepository;

    @Override
    public void run(String... args) {
        log.info("Seeding");
        String userId = "1";
        String event = "CREATE_NOMINATION";

        val teamsChannel = new Channel();
        teamsChannel.setName(ChannelEnum.TEAMS);

        val webPushChannel = new Channel();
        webPushChannel.setName(ChannelEnum.WEB_PUSH);

        val savedTeamsChannel = channelRepository.save(teamsChannel);
        val savedWebPushChannel = channelRepository.save(webPushChannel);

        val teams = new Teams();
        teams.setWebhook("webhook");
        teams.setChannel(savedTeamsChannel);
        teamsRepository.save(teams);

        val webPush = new WebPush();
        webPush.setPlayerId("Player 123");
        webPush.setUserId(userId);
        webPush.setChannel(savedWebPushChannel);
        webPushRepository.save(webPush);

        val subscriptionPerTeams = new Subscription();
        subscriptionPerTeams.setChannel(savedTeamsChannel);
        subscriptionPerTeams.setUserId(userId);
        subscriptionPerTeams.setEvent(event);
        subscriptionRepository.save(subscriptionPerTeams);

        val subscriptionPerWebPush = new Subscription();
        subscriptionPerWebPush.setChannel(savedWebPushChannel);
        subscriptionPerWebPush.setUserId(userId);
        subscriptionPerWebPush.setEvent(event);
        subscriptionRepository.save(subscriptionPerWebPush);
    }
}
