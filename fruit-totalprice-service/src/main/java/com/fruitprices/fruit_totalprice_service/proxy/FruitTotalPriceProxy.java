package com.fruitprices.fruit_totalprice_service.proxy;

import com.fruitprices.fruit_totalprice_service.bean.FruitTotalPrice;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "fruit-prices", url = "localhost:8000")

@FeignClient(name = "fruit-price")
/* feign client talking to eureka to get any running service */
public interface FruitTotalPriceProxy {
    @GetMapping("/fruit-month-price/fruit/{fruit}/month/{month}")
    public FruitTotalPrice getForEntity(@PathVariable String fruit, @PathVariable String month);
}
