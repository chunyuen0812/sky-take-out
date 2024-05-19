package com.sky.controller.admin;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.SetMealService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/page")
    @ApiOperation("page result of setmeal")
    public Result<PageResult> PageQuery(SetmealPageQueryDTO setmealPageQueryDTO){
        log.info("page result of setmeal category: {}", setmealPageQueryDTO);
        PageResult pageResult = setMealService.pageQuery(setmealPageQueryDTO);
        return Result.success(pageResult);
    }

    @DeleteMapping
    @ApiOperation("batch delete setmeal")
    public Result delete(@RequestParam List<Long> ids){
        log.info("batch delte setmeal :{}",ids);
        setMealService.deleteBatch(ids);
        return Result.success();
    }

}
