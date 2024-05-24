package com.sky.controller.user;

import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController("userShopController")
@RequestMapping("/user/shop")
@Api(tags = "ship related api")
@Slf4j
public class ShopController {

    public static final String KEY = "SHOP_STATUS";

    @Autowired
    public RedisTemplate redisTemplate;


    @GetMapping("/status")
    @ApiOperation("get shop status")
    public Result<Integer> getStatus(){
        log.info("get shop status");
        return Result.success((Integer) redisTemplate.opsForValue().get(KEY));
    }
}
