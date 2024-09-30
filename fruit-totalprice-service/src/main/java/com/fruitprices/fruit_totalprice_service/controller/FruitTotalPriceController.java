package com.fruitprices.fruit_totalprice_service.controller;

import com.fruitprices.fruit_totalprice_service.bean.FruitTotalPrice;
import com.fruitprices.fruit_totalprice_service.proxy.FruitTotalPriceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FruitTotalPriceController {

    @Autowired
    private Environment environment;

    @Autowired
    private FruitTotalPriceProxy fruitTotalPriceProxy;

    @GetMapping("/fruit-total-price/fruit/{fruit}/month/{month}/quantity/{qty}")
    public FruitTotalPrice retrieveDataFeign(
            @PathVariable String fruit,
            @PathVariable String month, @PathVariable Double qty) {

        String port = environment.getProperty("local.server.port");

        FruitTotalPrice data = fruitTotalPriceProxy.retrieveData(fruit, month);
        data.setQuantity(qty);
        data.setTotalPrice(data.getFmp() * data.getQuantity());
//        data.setEnvironment(port);
        return data;
    }
}
