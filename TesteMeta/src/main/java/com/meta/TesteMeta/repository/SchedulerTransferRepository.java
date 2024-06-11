package com.meta.TesteMeta.repository;

import com.meta.TesteMeta.entity.ScheduleTransfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  SchedulerTransferRepository extends JpaRepository<ScheduleTransfer, Long> {



}
