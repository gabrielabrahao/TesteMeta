package com.meta.TesteMeta.services;

import com.meta.TesteMeta.dto.ScheduleTransferCreateDto;
import com.meta.TesteMeta.dto.ScheduleTransferResponseDto;

public interface ScheduleTransferService {

    ScheduleTransferResponseDto scheduleTransferCreate(ScheduleTransferCreateDto scheduleTransferCreateDto);
}
