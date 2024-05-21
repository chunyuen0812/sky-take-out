package com.sky.service;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.vo.DishVO;
import com.sky.result.PageResult;


import java.util.List;

public interface DishService {

    /**
     * Add new dish
     * @param dishDTO
     */
    void saveWithFlavor(DishDTO dishDTO);


    /**
     * dish page searching
     * @param dishPageQueryDTO
     * @return
     */
    PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO);

    /**
     * delete dish batch
     * @param ids
     */
    void deleteBatch(List<Long> ids);

    DishVO getByIdwithFlavor(Long id);

    /**
     * update basic info and flavor of dish by id
     * @param dishDTO
     */
    void updateWithFlavor(DishDTO dishDTO);

    List<Dish> getListByCategory(Long categoryId);

    void updateStatus(Integer status, Long id);
}
