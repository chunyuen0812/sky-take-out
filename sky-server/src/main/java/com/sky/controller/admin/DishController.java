package com.sky.controller.admin;

import com.sky.dto.CategoryDTO;
import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Category;
import com.sky.entity.Dish;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.DishService;
import com.sky.vo.DishVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Dish Related API
 */
@RestController
@RequestMapping("/admin/dish")
@Api(tags = "Dish Related API")
@Slf4j
public class DishController {

    @Autowired
    private DishService dishService;

    /**
     * Add New Dish
     * @param dishDTO
     * @return
     */
    @PostMapping
    @ApiOperation("Add New Dish")
    public Result save(@RequestBody DishDTO dishDTO){
        log.info("Add new dish:{}", dishDTO);
        dishService.saveWithFlavor(dishDTO);
        return Result.success();
    }

    @GetMapping("/page")
    @ApiOperation("Dish Page Searching")
    public Result<PageResult> page(DishPageQueryDTO dishPageQueryDTO){
        log.info("dish search: {}", dishPageQueryDTO);
        PageResult pageResult = dishService.pageQuery(dishPageQueryDTO);
        return Result.success(pageResult);
    }

    @DeleteMapping
    @ApiOperation("delete dish")
    public Result delete(@RequestParam List<Long> ids){
        log.info("delete dish: {}", ids);
        dishService.deleteBatch(ids);
        return Result.success();
    }

    @GetMapping("/{id}")
    @ApiOperation("get dish by id")
    public Result<DishVO> getById(@PathVariable Long id){
        log.info("get dish by Id: {}", id);
        DishVO dishVo = dishService.getByIdwithFlavor(id);
        return Result.success(dishVo);
    }

    @PutMapping
    @ApiOperation("udpate dish")
    public Result update(@RequestBody DishDTO dishDTO){
        log.info("update dish: {}",dishDTO);
        dishService.updateWithFlavor(dishDTO);
        return Result.success();
    }

    @GetMapping("/list")
    @ApiOperation("get dish by category")
    public Result<List> getListByCategory(Long categoryId){
        log.info("get dish by category: {}", categoryId);
        List<Dish> dishList = dishService.getListByCategory(categoryId);
        return Result.success(dishList);
    }

    @PostMapping("/status/{status}")
    @ApiOperation("update status")
    public Result updateStatus(@PathVariable("status") Integer status, Long id){
        log.info("update dish {} status {}",id, status);
        dishService.updateStatus(status, id);
        return Result.success();
    }


}
