package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName: DishFlavorMapper
 * Package: com.sky.mapper
 * Description:
 *
 * @Author han
 * @Create 2024/2/16  17:16
 * Version 1.0
 */
@Mapper
public interface DishFlavorMapper {
    void insertBatch(List<DishFlavor> flavors);
}
