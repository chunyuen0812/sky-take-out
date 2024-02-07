package com.sky.controller.admin;


import com.sky.properties.JwtProperties;
import com.sky.result.PageResult;
import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.service.CategoryService;


/**
 * 分類管理
 */
@RequestMapping("/admiin/category")
@RestController
@Slf4j
@Api("分類相關接口")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/page")
    @ApiOperation("分类分页查询")
    public Result<PageResult> page(CategoryDTO categoryDTO){
        log.info("分類分頁查詢:{}",categoryDTO);
        PageResult pageResult = CategoryService.pageQuery(categoryDTO);
        return Result.success(pageResult);
    }



}