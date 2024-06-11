package com.meta.TesteMeta.controller;

import com.meta.TesteMeta.dto.ScheduleTransferCreateDto;
import com.meta.TesteMeta.dto.ScheduleTransferResponseDto;
import com.meta.TesteMeta.service.ScheduleTransferService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedule")
@Api(value = "Transfer Management System", tags = "Transfer Management")
public class ScheduleTransferController {

    @Autowired
    private ScheduleTransferService scheduleTransferService;

    @PostMapping("/transfer")
    @ApiOperation(value = "Schedule a new transfer", response = ScheduleTransferResponseDto.class)
    public ScheduleTransferResponseDto scheduleTransferCreate(@RequestBody ScheduleTransferCreateDto scheduleTransferCreateDto) {
        return scheduleTransferService.scheduleTransferCreate(scheduleTransferCreateDto);
    }

    @GetMapping("/transfer")
    @ApiOperation(value = "List all transfers", response = Page.class)
    public ResponseEntity<Page<ScheduleTransferResponseDto>> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                                     @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return ResponseEntity.ok(scheduleTransferService.findAll(page, size));
    }
}
