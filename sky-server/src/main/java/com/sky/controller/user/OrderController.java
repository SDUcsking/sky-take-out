package com.sky.controller.user;

import com.alibaba.fastjson.JSON;
import com.sky.dto.OrdersPaymentDTO;
import com.sky.dto.OrdersSubmitDTO;
import com.sky.mapper.OrderDetailMapper;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.OrderService;
import com.sky.vo.OrderPaymentVO;
import com.sky.vo.OrderSubmitVO;
import com.sky.vo.OrderVO;
import com.sky.websocket.WebSocketServer;
import io.netty.handler.logging.LogLevel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: OrderController
 * Package: com.sky.controller.user
 * Description:
 *
 * @Author han
 * @Create 2024/2/28  15:15
 * Version 1.0
 */
@RestController("userOrderController")
@RequestMapping("user/order")
@Api("订单操作")
@Slf4j
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    WebSocketServer webSocketServer;
    @PostMapping("submit")
    @ApiOperation("用户下单")

    public Result<OrderSubmitVO> submit(@RequestBody OrdersSubmitDTO ordersSubmitDTO){
        log.info("用户下单,{}",ordersSubmitDTO);
        OrderSubmitVO orderSubmitVO=orderService.submitOrder(ordersSubmitDTO);
        return Result.success(orderSubmitVO);
    }

    @PutMapping("/payment")
    @ApiOperation("订单支付")
    public Result<OrderPaymentVO> payment(@RequestBody OrdersPaymentDTO ordersPaymentDTO) throws Exception {
        orderService.paySuccess(ordersPaymentDTO.getOrderNumber());
//        log.info("订单支付：{}", ordersPaymentDTO);
//        OrderPaymentVO orderPaymentVO = orderService.payment(ordersPaymentDTO);
//        log.info("生成预支付交易单：{}", orderPaymentVO);
        Map map=new HashMap();
        Long orderId=orderService.getIdByOrderNumber(ordersPaymentDTO);
        map.put("type",1);
        map.put("orderId",orderId);
        map.put("content",ordersPaymentDTO.getOrderNumber());
        String json= JSON.toJSONString(map);
        webSocketServer.sendToAllClient(json);
        return Result.success();
    }
    @GetMapping("historyOrders")
    @ApiOperation("历史订单查询")
    public Result<PageResult> page(int page,int pageSize,Integer status){
        PageResult pageResult=orderService.pageQueryForUser(page,pageSize,status);
        return Result.success(pageResult);
    }
    @GetMapping("/orderDetail/{id}")
    @ApiOperation("查询订单详情")
    public Result<OrderVO> details(@PathVariable Long id){
        OrderVO orderVO=orderService.details(id);
        return Result.success(orderVO);
    }
    @PutMapping("cancel/{id}")
    @ApiOperation("取消订单")
    public Result cancel(@PathVariable Long id){
        orderService.userCancelById(id);
        return  Result.success();
    }
    @PostMapping("repetition/{id}")
    @ApiOperation("再来一单")
    public Result repetition(@PathVariable Long id){
        orderService.repetition(id);
        return Result.success();

    }


}
