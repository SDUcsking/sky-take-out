package com.sky.service;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;

/**
 * ClassName: SetmealService
 * Package: com.sky.service
 * Description:
 *
 * @Author han
 * @Create 2024/2/24  8:46
 * Version 1.0
 */
public interface SetmealService {

    void save(SetmealDTO setmealDTO);

    PageResult pageQuery(SetmealPageQueryDTO setmealPageQueryDTO);
}
