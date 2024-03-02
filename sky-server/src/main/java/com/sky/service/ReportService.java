package com.sky.service;

import com.sky.vo.TurnoverReportVO;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * ClassName: ReportService
 * Package: com.sky.service
 * Description:
 *
 * @Author han
 * @Create 2024/3/2  10:31
 * Version 1.0
 */
public interface ReportService {
    TurnoverReportVO getTurnoverStatistics(LocalDate begin, LocalDate end);
}
