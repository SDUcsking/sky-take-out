package com.sky.mapper;

import com.sky.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: OrderMapper
 * Package: com.sky.mapper
 * Description:
 *
 * @Author han
 * @Create 2024/2/28  15:20
 * Version 1.0
 */
@Mapper
public interface OrderMapper {
    void insert(Orders orders);
}
