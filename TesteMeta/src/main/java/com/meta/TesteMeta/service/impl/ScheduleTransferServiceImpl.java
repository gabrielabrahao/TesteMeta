package com.meta.TesteMeta.service.impl;

import com.meta.TesteMeta.dto.ScheduleTransferCreateDto;
import com.meta.TesteMeta.dto.ScheduleTransferResponseDto;
import com.meta.TesteMeta.entity.ScheduleTransfer;
import com.meta.TesteMeta.enums.Tax;
import com.meta.TesteMeta.exception.ValidacaoException;
import com.meta.TesteMeta.mapper.ScheduleTransferMapper;
import com.meta.TesteMeta.repository.SchedulerTransferRepository;
import com.meta.TesteMeta.service.ScheduleTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ScheduleTransferServiceImpl implements ScheduleTransferService {

    @Autowired private ScheduleTransferMapper scheduleTransferMapper;
    @Autowired private SchedulerTransferRepository repository;

    @Override
    public ScheduleTransferResponseDto scheduleTransferCreate(ScheduleTransferCreateDto scheduleTransferCreateDto) {
        ScheduleTransfer scheduleTransfer = scheduleTransferMapper.toScheduleTransfer(scheduleTransferCreateDto);
        validDates(scheduleTransferCreateDto, scheduleTransfer);
        scheduleTransfer.setTax(calculateTax(scheduleTransfer.getScheduleDateCreated(), scheduleTransfer.getScheduleDate()));
        validAccounts(scheduleTransferCreateDto);
        validValues(scheduleTransferCreateDto);




        scheduleTransfer = repository.save(scheduleTransfer);
        return scheduleTransferMapper.toScheduleTransferResponseDto(scheduleTransfer);
    }

    private static void validDates(ScheduleTransferCreateDto scheduleTransferCreateDto, ScheduleTransfer scheduleTransfer) {
        if (scheduleTransferCreateDto.getScheduleDateCreated() == null){
            scheduleTransfer.setScheduleDateCreated(LocalDateTime.now());
        }
        if (scheduleTransfer.getScheduleDate() == null){
            throw new ValidacaoException("Transfer date is required");
        }
        if (scheduleTransfer.getScheduleDateCreated().isAfter(scheduleTransfer.getScheduleDate())){
            throw new ValidacaoException("Scheduling date cannot be greater than the transfer date");
        }
    }

    private static void validValues(ScheduleTransferCreateDto scheduleTransferCreateDto) {
        if (scheduleTransferCreateDto.getValueTransfer() <= 0){
            throw new ValidacaoException("Transfer amount is required");
        }
    }

    private static void validAccounts(ScheduleTransferCreateDto scheduleTransferCreateDto) {
        if (scheduleTransferCreateDto.getOriginAccount() == null || scheduleTransferCreateDto.getDestinationAccount() == null){
            throw new ValidacaoException("Source and destination account are required");
        }
        if (scheduleTransferCreateDto.getOriginAccount().isEmpty() || scheduleTransferCreateDto.getDestinationAccount().isEmpty()){
            throw new ValidacaoException("Source and destination account are required");
        }
    }

    public Page<ScheduleTransferResponseDto> findAll(int page, int size) {
        return repository.findAll(PageRequest.of(page, size)).map(scheduleTransferMapper::toScheduleTransferResponseDto);
    }


    private double calculateTax(LocalDateTime scheduleDateCreated, LocalDateTime scheduleDate){
        int days = scheduleDate.getDayOfYear() - scheduleDateCreated.getDayOfYear();
        double tax = Tax.getTax(days).getTax();
        if (tax == 0.0){
            throw new ValidacaoException("There is no fee applicable for the transfer");
        }
        return tax;
    }
}
