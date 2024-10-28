package com.fruitprices.fruit_monthprice_service.controller;

import com.fruitprices.fruit_monthprice_service.bean.FruitData;
import com.fruitprices.fruit_monthprice_service.repository.FruitPriceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FruitMonthPriceController {

    private Logger logger = LoggerFactory.getLogger(FruitMonthPriceController.class);

    @Autowired
    private Environment environment;
    @Autowired
    private FruitPriceRepository fruitPriceRepository;

    public FruitMonthPriceController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/fruit-month-price/fruit/{fruit}/month/{month}")
    public FruitData retrieveData(@PathVariable String fruit, @PathVariable String month){
//        FruitData fruitData = new FruitData(1, fruit, 5.89, month );

        // INFO [fruit-price,945fedee70bc7c5ae78ef9d332125472,26617733c86163ad] #SB3
        logger.info("retrieve fruit month price called with {} {} ", fruit, month);


        FruitData fruitData = fruitPriceRepository.readFruitDataByFruitAndMonth(fruit, month);
        if (fruitData == null){
            throw new RuntimeException("Unable to find fruit " + fruit + "for month " + month + "\n");
        }
        String port = environment.getProperty("local.server.port");
        fruitData.setEnvironment(port);
        return fruitData;
    }
}
