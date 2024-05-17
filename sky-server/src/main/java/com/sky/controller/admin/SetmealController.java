package com.sky.controller.admin;

import com.sky.dto.SetmealDTO;
import com.sky.result.Result;
import com.sky.service.SetMealService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/admin/setmeal")
@Api(tags = "set related interface")
public class SetmealController {

    @Autowired
    private SetMealService setMealService;

    /**
     * add new set
     * @param setmealDTO
     */
    @PostMapping
    @ApiOperation("add new set")
    public Result addSetmeal(@RequestBody SetmealDTO setmealDTO){
        log.info("add new set:{}",setmealDTO);
        setMealService.add(setmealDTO);
        return Result.success();
    }
}
