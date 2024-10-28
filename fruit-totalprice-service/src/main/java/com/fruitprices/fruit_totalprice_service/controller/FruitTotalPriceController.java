package com.fruitprices.fruit_totalprice_service.controller;

import com.fruitprices.fruit_totalprice_service.bean.FruitTotalPrice;
import com.fruitprices.fruit_totalprice_service.proxy.FruitTotalPriceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
public class FruitTotalPriceController {

    @Autowired
    private Environment environment;

    @Autowired
    private FruitTotalPriceProxy fruitTotalPriceProxy;

    @Autowired
    private RestTemplate restTemplate;

    /* using fruit total price proxy */
    @GetMapping("/fruit-total-price/fruit/{fruit}/month/{month}/quantity/{qty}")

    /* using fruit total price proxy */
//    public FruitTotalPrice retrieveDataFeign(
//            @PathVariable String fruit,
//            @PathVariable String month, @PathVariable Double qty) {
//
//        String port = environment.getProperty("local.server.port");
//
//        FruitTotalPrice data = fruitTotalPriceProxy.getForEntity(fruit, month);
//        data.setQuantity(qty);
//        data.setTotalPrice(data.getFmp() * data.getQuantity());
////        data.setEnvironment(port);
//        return data;
//    }

    /* using rest template */
    public FruitTotalPrice retrieveDataFeign(
            @PathVariable String fruit,
            @PathVariable String month, @PathVariable Double qty) {

        HashMap<String, String> uriVariables = new HashMap<>();
        uriVariables.put("fruit", fruit);
        uriVariables.put("month", month);

        // need to give complete url when using rest template
        ResponseEntity<FruitTotalPrice> responseEntity = restTemplate.getForEntity(
                "http://localhost:8000/fruit-month-price/fruit/{fruit}/month/{month}", FruitTotalPrice.class, uriVariables);

        return responseEntity.getBody();
    }



}
