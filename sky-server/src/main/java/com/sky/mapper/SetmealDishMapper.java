package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName: SetmealDishMapper
 * Package: com.sky.mapper
 * Description:
 *
 * @Author han
 * @Create 2024/2/21  20:38
 * Version 1.0
 */
@Mapper
public interface SetmealDishMapper {


        List<Long> getSetmealIdsByDishIds(List<Long> dishIds);

}
