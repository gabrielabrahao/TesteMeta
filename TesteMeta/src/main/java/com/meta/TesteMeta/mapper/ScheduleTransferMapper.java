package com.meta.TesteMeta.mapper;

import com.meta.TesteMeta.dto.ScheduleTransferCreateDto;
import com.meta.TesteMeta.dto.ScheduleTransferResponseDto;
import com.meta.TesteMeta.entity.ScheduleTransfer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ScheduleTransferMapper {

    //ScheduleTransferMapper INSTANCE = Mappers.getMapper(ScheduleTransferMapper.class);

    ScheduleTransferCreateDto toScheduleTransferCreateDto(ScheduleTransfer scheduleTransfer);

    ScheduleTransfer toScheduleTransfer(ScheduleTransferCreateDto scheduleTransferCreateDto);

    ScheduleTransferResponseDto toScheduleTransferResponseDto(ScheduleTransfer scheduleTransfer);

}
