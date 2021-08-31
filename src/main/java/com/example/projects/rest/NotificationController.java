package com.example.projects.rest;

import com.example.projects.usecases.notification.CreateNotificationUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class NotificationController {
    private final CreateNotificationUseCase createNotificationUseCase;

    @GetMapping
    private void test() {
        createNotificationUseCase.execute();
    }

}
