package com.example.projects;

import com.example.projects.entities.ChannelInfo;
import com.example.projects.entities.Subscription;
import com.example.projects.entities.Teams;
import com.example.projects.entities.WebPush;
import com.example.projects.entities.enums.ChannelEnum;
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

    @Override
    public void run(String... args) {
        log.info("Seeding");
        String userId = "1";

        val teamsInfo = new ChannelInfo();
        teamsInfo.setName(ChannelEnum.TEAMS);

        val teams = new Teams();
        teams.setChannelInfo(teamsInfo);
        teams.setWebhook("webhook");
        teamsRepository.save(teams);

        val webPushInfo = new ChannelInfo();
        webPushInfo.setName(ChannelEnum.WEB_PUSH);

        val webPush = new WebPush();
        webPush.setChannelInfo(webPushInfo);
        webPush.setPlayerId("Player 123");
        webPush.setUserId(userId);
        webPushRepository.save(webPush);

        val subscriptionPerTeams = new Subscription();
        subscriptionPerTeams.setChannel(ChannelEnum.TEAMS);
        subscriptionPerTeams.setTeams(teams);
        subscriptionPerTeams.setUserId(userId);
        subscriptionRepository.save(subscriptionPerTeams);

        val subscriptionPerWebPush = new Subscription();
        subscriptionPerWebPush.setChannel(ChannelEnum.WEB_PUSH);
        subscriptionPerWebPush.setWebPush(webPush);
        subscriptionPerWebPush.setUserId(userId);
        subscriptionRepository.save(subscriptionPerWebPush);
    }
}
