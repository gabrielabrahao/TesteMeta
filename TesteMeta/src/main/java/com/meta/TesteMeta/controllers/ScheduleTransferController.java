package com.meta.TesteMeta.controllers;

import com.meta.TesteMeta.dto.ScheduleTransferCreateDto;
import com.meta.TesteMeta.dto.ScheduleTransferResponseDto;
import com.meta.TesteMeta.services.ScheduleTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedule")
public class ScheduleTransferController {

    @Autowired
    private ScheduleTransferService scheduleTransferService;

    @PostMapping("/transfer")
    public ScheduleTransferResponseDto scheduleTransferCreate(@RequestBody ScheduleTransferCreateDto scheduleTransferCreateDto) {
        return scheduleTransferService.scheduleTransferCreate(scheduleTransferCreateDto);
    }
}
