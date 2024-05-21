package com.sky.controller.admin;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.SetMealService;
import com.sky.vo.SetmealVO;
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

    @GetMapping("/{id}")
    @ApiOperation("get setmeal details")
    public Result<SetmealVO> getById(@PathVariable Long id){
        log.info("get setmeal by id : {}", id);
        SetmealVO setmealVO = setMealService.getById(id);
        return Result.success(setmealVO);
    }

    @PutMapping
    @ApiOperation("update setmeal details")
    public Result udpate(@RequestBody SetmealDTO setmealDTO){
        log.info("udpate setmeal detail: {}", setmealDTO);
        setMealService.updateWithSetmealDishes(setmealDTO);
        return Result.success();
    }

    @PostMapping("/status/{status}")
    @ApiOperation("update status")
    public Result updateStatus(@PathVariable("status") Integer status, Long id){
        log.info("update setmeal {} status {}",id, status);
        setMealService.updateStatus(status, id);
        return Result.success();
    }

}
