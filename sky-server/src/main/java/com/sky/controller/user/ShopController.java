package com.sky.controller.user;

import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: ShopController
 * Package: com.sky.controller.admin
 * Description:
 *
 * @Author han
 * @Create 2024/2/25  22:25
 * Version 1.0
 */
@RestController("userShopController")
@RequestMapping("/user/shop")
@Api("店铺相关课程")
@Slf4j
public class ShopController {
    public static final String KEY="SHOP_STATUS";
    @Autowired
    private RedisTemplate redisTemplate;

   @GetMapping("status")
    @ApiOperation("获取店铺营业状态")
    public Result<Integer>getStatus(){
        Integer status=(Integer) redisTemplate.opsForValue().get(KEY);
        log.info("获取到店铺的营业状态为{}",status==1?"营业中":"打烊");
        return Result.success(status);
    }
}
