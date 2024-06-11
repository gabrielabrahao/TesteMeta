package com.meta.TesteMeta.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ScheduleTransfer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String originAccount;
    private String destinationAccount;
    private double valueTransfer;
    private double tax;
    private LocalDateTime scheduleDate;
    private LocalDateTime scheduleDateCreated;

}
