package com.example.projects.entities;

import com.example.projects.entities.enums.NotificationStatusEnum;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
    @Id
    @GeneratedValue
    @Column(name = "NTF_ID")
    private Long id;

    @Embedded
    private Message message;

    @Column(name = "NTF_LEGAL_ENTITY")
    private String legalEntity;

    @Column(name = "NTF_SENDER")
    private String sender;

    @Column(name = "NTF_RECEIVER")
    private String receiver;

    // This timestamp is related to when the event was created, not the notification
    @Column(name = "NTF_EVENT_TIMESTAMP", updatable = false)
    private LocalDateTime eventTimestamp;

    @Column(name = "NTF_DISPATCHED_TIMESTAMP")
    private LocalDateTime dispatchTimestamp;

    @Column(name = "NTF_READ")
    private boolean read;

    @Column(name = "NTF_STATUS")
    @Enumerated(EnumType.STRING)
    private NotificationStatusEnum status;

    @Column(name = "NTF_REFERENCE_CODE")
    private String referenceCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EVT_ID")
    private Event event;

    @Column(name = "USR_ID")
    private String userId;

    @Column(name = "NTF_DISPLAYED")
    private Boolean displayed;
}
