package com.sky.service.impl;


import com.sky.dto.DishDTO;
import com.sky.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class DishServiceImpl implements DishService {

    /**
     * Add new Dish and the corresponding flavor
     * @param dishDTO
     */
    @Transactional
    public void saveWithFlavor(DishDTO dishDTO) {

    }
}
