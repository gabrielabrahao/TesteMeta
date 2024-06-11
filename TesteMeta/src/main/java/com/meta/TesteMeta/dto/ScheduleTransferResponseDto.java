package com.meta.TesteMeta.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScheduleTransferResponseDto {
    private String originAccount;
    private String destinationAccount;
    private double valueTransfer;
    private double tax;
    private LocalDateTime scheduleDate;
    private LocalDateTime scheduleDateCreated = LocalDateTime.now();
}
