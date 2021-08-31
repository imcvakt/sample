package com.example.projects.usecases.notification;

import com.example.projects.entities.Channel;
import com.example.projects.entities.Subscription;
import com.example.projects.entities.enums.ChannelEnum;
import com.example.projects.usecases.channels.FindSubscribedChannels;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateNotificationUseCase {

    private final CreateNotificationStrategyFactory createNotificationStrategyFactory;
    private final FindSubscribedChannels findSubscribedChannels;

    public void execute() {
        String userLoggedIn = "1";
        String event = "CREATE_NOMINATION";

        val subscriptions = findSubscribedChannels.execute(userLoggedIn, event);

        val fakeUsersSubscribed = Map.of(
                userLoggedIn,
                subscriptions
        );

        extracted(fakeUsersSubscribed);
    }

    private void extracted(Map<String, List<Subscription>> fakeUsersSubscribed) {
        fakeUsersSubscribed.forEach((user, subscriptions) -> {
            log.info("user: {}", user);
            sendNotification(subscriptions);
        });
    }

    private void sendNotification(List<Subscription> subscriptions) {
        subscriptions
                .forEach(subscription -> {
                    val strategy = createNotificationStrategyFactory.findStrategy(subscription.getChannel().getName());
                    val channelDetails = subscription.getChannel().getDetails();

                    // in a real scenario we would have a notification
                    strategy.create(channelDetails);
                });
    }
}
