package com.fruitprices.fruit_monthprice_service.repository;

import com.fruitprices.fruit_monthprice_service.bean.FruitData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FruitPriceRepository extends JpaRepository<FruitData, Integer> {
//    FruitData findByFromAndTo(String fruit, String month);
    FruitData readFruitDataByFruitAndMonth(String fruit, String month);
}
