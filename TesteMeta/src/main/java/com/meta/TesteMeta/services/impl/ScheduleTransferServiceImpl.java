package com.meta.TesteMeta.services.impl;

import com.meta.TesteMeta.dto.ScheduleTransferCreateDto;
import com.meta.TesteMeta.dto.ScheduleTransferResponseDto;
import com.meta.TesteMeta.entity.ScheduleTransfer;
import com.meta.TesteMeta.enuns.Tax;
import com.meta.TesteMeta.exception.ValidacaoException;
import com.meta.TesteMeta.mapper.ScheduleTransferMapper;
import com.meta.TesteMeta.repository.SchedulerTransferRepository;
import com.meta.TesteMeta.services.ScheduleTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class ScheduleTransferServiceImpl implements ScheduleTransferService {

    @Autowired private ScheduleTransferMapper scheduleTransferMapper;
    @Autowired private SchedulerTransferRepository repository;

    @Override
    public ScheduleTransferResponseDto scheduleTransferCreate(ScheduleTransferCreateDto scheduleTransferCreateDto) {
        ScheduleTransfer scheduleTransfer = scheduleTransferMapper.toScheduleTransfer(scheduleTransferCreateDto);
        scheduleTransfer.setTax(calculateTax(scheduleTransfer.getScheduleDateCreated(), scheduleTransfer.getScheduleDate()));
        validAccounts(scheduleTransferCreateDto);
        validValues(scheduleTransferCreateDto);
        if (scheduleTransferCreateDto.getScheduleDateCreated().isAfter(scheduleTransferCreateDto.getScheduleDate())){
            throw new ValidacaoException("Data de agendamento não pode ser maior que a data de transferência");
        }


        scheduleTransfer = repository.save(scheduleTransfer);
        return scheduleTransferMapper.toScheduleTransferResponseDto(scheduleTransfer);
    }

    private static void validValues(ScheduleTransferCreateDto scheduleTransferCreateDto) {
        if (scheduleTransferCreateDto.getValueTransfer() <= 0){
            throw new ValidacaoException("Valor da transferência é obrigatório");
        }
    }

    private static void validAccounts(ScheduleTransferCreateDto scheduleTransferCreateDto) {
        if (scheduleTransferCreateDto.getOriginAccount() == null || scheduleTransferCreateDto.getDestinationAccount() == null){
            throw new ValidacaoException("Conta de origem e destino são obrigatórias");
        }
        if (scheduleTransferCreateDto.getOriginAccount().isEmpty() || scheduleTransferCreateDto.getDestinationAccount().isEmpty()){
            throw new ValidacaoException("Conta de origem e destino são obrigatórias");
        }
    }

    public Page<ScheduleTransferResponseDto> findAll(int page, int size) {
        return repository.findAll(PageRequest.of(page, size)).map(scheduleTransferMapper::toScheduleTransferResponseDto);
    }


    private double calculateTax(LocalDateTime scheduleDateCreated, LocalDateTime scheduleDate){
        int days = scheduleDate.getDayOfYear() - scheduleDateCreated.getDayOfYear();
        double tax = Tax.getTax(days).getTax();
        if (tax == 0.0){
            throw new ValidacaoException("Não há taxa aplicável para a transferência");
        }
        return tax;
    }
}
