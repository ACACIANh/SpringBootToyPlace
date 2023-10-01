package com.example.quartzscheduler.repository;

import com.example.quartzscheduler.entity.QuartzHistoryLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuartzHistoryRepository extends JpaRepository< QuartzHistoryLog, Long > {
}
