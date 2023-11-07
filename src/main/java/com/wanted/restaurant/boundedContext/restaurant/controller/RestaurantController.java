package com.wanted.restaurant.boundedContext.restaurant.controller;

import com.wanted.restaurant.base.rsData.RsData;
import com.wanted.restaurant.boundedContext.restaurant.dto.RestaurantResponse;
import com.wanted.restaurant.boundedContext.restaurant.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/restaurant")
@RequiredArgsConstructor
public class RestaurantController {

  private final RestaurantService restaurantService;

  @GetMapping("list")
  public RsData<RestaurantResponse.RestaurantList> searchList
          (@RequestParam(value = "lat") Double lat,@RequestParam(value = "lng") Double lng,
           @RequestParam(value = "range") Double range,
           @RequestParam(value = "page")int page,@RequestParam(value = "size")int size){
    return RsData.of("S-1","success",restaurantService.search(lat,lng,range*1000,page,size));
  }
}
