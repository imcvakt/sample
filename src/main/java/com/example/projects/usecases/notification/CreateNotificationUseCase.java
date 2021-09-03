package com.example.projects.usecases.notification;

import com.example.projects.entities.Event;
import com.example.projects.entities.Message;
import com.example.projects.entities.ProfileSubscription;
import com.example.projects.repositories.EventRepository;
import com.example.projects.usecases.profile.FindUserPreferences;
import com.example.projects.usecases.subscription.FindUsersSubscribedTo;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.BiConsumer;

@Data
class MockNotification {
    private Message message;
    private LocalDateTime dispatchTimestamp;
    private Event event;
    private String legalEntity;
    private String productGrade;
    private Boolean displayed;

    private String deskId;
    /*
    //NOT REQUIRED
    private LocalDateTime eventTimestamp;
    private Channel channel;
    private String sender;
    private String receiver;
    private String tenant;
    private String referenceCode;
    private boolean read;
    private NotificationStatusEnum status;
    private String userId;
    private String hashCode;
     */

    public static MockNotification build() {
        val mockNotification = new MockNotification();
        mockNotification.message = Message.builder().content("").link("").title("").build();
        mockNotification.dispatchTimestamp = null;
        mockNotification.event = Event.builder().name("Create Nomination").build();
        mockNotification.legalEntity = "shell";
        mockNotification.productGrade = "P1";
        mockNotification.displayed = false;
        mockNotification.deskId = "DESK 1";
        return mockNotification;
    }
}

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateNotificationUseCase {

    private final CreateNotificationStrategyFactory createNotificationStrategyFactory;

    private final EventRepository eventRepository;

    private final FindUsersSubscribedTo findUsersSubscribedTo;
    private final FindUserPreferences findUserPreferences;

    public void execute() {
        val notification = MockNotification.build();
        notification.setEvent(eventRepository.findEventByName(notification.getEvent().getName()));

        val legalEntity = notification.getLegalEntity();
        val desks = getDesks(legalEntity, notification);
        val productGrade = notification.getProductGrade();
        val eventId =  notification.getEvent().getId();

        val usersSubscribed = findUsersSubscribedTo.execute(legalEntity, desks, productGrade);
        val profileSubscriptions = findUserPreferences
                .execute(usersSubscribed, eventId);

        profileSubscriptions.forEach(sendNotification());
    }

    private BiConsumer<String, List<ProfileSubscription>> sendNotification() {
        return (user, profileSubscriptions) -> {
            profileSubscriptions
                .forEach(profileSubscription -> {
                    val strategy = createNotificationStrategyFactory.findStrategy(profileSubscription.getChannel().getName());
                    val channel = profileSubscription.getChannel();

                    // in a real scenario we would have a notification
                    strategy.create(channel);
                });
        };
    }

    private List<String> getDesks(String legalEntity, MockNotification notification) {
        return StringUtils.hasText(notification.getDeskId()) ?
                List.of(notification.getDeskId()) : null;
                //tradesDeskGateway.findDesksNameByProduct(legalEntity, notification.getProductGrade());
    }
}
