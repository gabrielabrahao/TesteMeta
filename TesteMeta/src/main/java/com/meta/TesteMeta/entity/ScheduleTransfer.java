package com.meta.TesteMeta.entity;

import lombok.*;

import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScheduleTransfer {

    @Id
    private Long id;
    private String originAccount;
    private String destinationAccount;
    private double valueTransfer;
    private double tax;
    private LocalDateTime scheduleDate;
    private LocalDateTime scheduleDateCreated;

}
