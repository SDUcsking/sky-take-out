package com.sky.service;

import com.sky.dto.OrdersSubmitDTO;
import com.sky.result.PageResult;
import com.sky.vo.OrderSubmitVO;
import com.sky.vo.OrderVO;

/**
 * ClassName: OrderService
 * Package: com.sky.service
 * Description:
 *
 * @Author han
 * @Create 2024/2/28  15:18
 * Version 1.0
 */
public interface OrderService {
    OrderSubmitVO submitOrder(OrdersSubmitDTO ordersSubmitDTO);
    void paySuccess(String outTradeNo);

    PageResult pageQueryForUser(int page, Integer pagesize, Integer status);

    OrderVO details(Long id);

    void userCancelById(Long id);

    void repetition(Long id);
}
