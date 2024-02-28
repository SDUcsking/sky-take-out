package com.sky.mapper;

import com.sky.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * ClassName: OrderDetailMapper
 * Package: com.sky.mapper
 * Description:
 *
 * @Author han
 * @Create 2024/2/28  15:21
 * Version 1.0
 */
@Mapper
public interface OrderDetailMapper {

    @Select("select * from order_detail where order_id=#{orderId}")
  List<OrderDetail> getByOrderId(Long orderId) ;

    void insertBatch(List<OrderDetail> orderDetails);
}
