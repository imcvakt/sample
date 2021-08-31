package com.example.projects.usecases.notification;

import com.example.projects.entities.enums.ChannelEnum;
import com.example.projects.usecases.channels.FindSubscribedChannels;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateNotificationUseCase {

    private final CreateNotificationStrategyFactory createNotificationStrategyFactory;
    private final FindSubscribedChannels findSubscribedChannels;

    public void execute() {
        String userLoggedIn = "1";

        val subscribedChannels = findSubscribedChannels.execute(userLoggedIn);

        val fakeUsersSubscribed = Map.of(
                userLoggedIn,
                subscribedChannels
        );

        fakeUsersSubscribed.forEach((user, channels) -> {
            log.info("user: {}", user);
            sendNotification(channels);
        });
    }

    private void sendNotification(List<ChannelEnum> channels) {
        channels
                .forEach(channel -> {
                    val strategy = createNotificationStrategyFactory.findStrategy(channel);
                    // in a real scenario we would have a notification
                    strategy.create();
                });
    }
}
