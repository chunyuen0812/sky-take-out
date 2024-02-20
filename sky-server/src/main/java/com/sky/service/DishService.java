package com.sky.service;

import com.sky.dto.DishDTO;

public interface DishService {

    /**
     * Add new dish
     * @param dishDTO
     */
    void saveWithFlavor(DishDTO dishDTO);

}
