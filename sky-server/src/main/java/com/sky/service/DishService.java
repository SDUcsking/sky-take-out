package com.sky.service;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;

/**
 * ClassName: DishService
 * Package: com.sky.service
 * Description:
 *
 * @Author han
 * @Create 2024/2/16  16:47
 * Version 1.0
 */
public interface DishService {

    public void saveWithFlavor(DishDTO dishDTO);
    public PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO);
}
