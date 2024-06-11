package com.meta.TesteMeta.services;

import com.meta.TesteMeta.dto.ScheduleTransferCreateDto;
import com.meta.TesteMeta.dto.ScheduleTransferResponseDto;
import org.springframework.data.domain.Page;

public interface ScheduleTransferService {

    ScheduleTransferResponseDto scheduleTransferCreate(ScheduleTransferCreateDto scheduleTransferCreateDto);

    Page<ScheduleTransferResponseDto> findAll(int page, int size);
}
