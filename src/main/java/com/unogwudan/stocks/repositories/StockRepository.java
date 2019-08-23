package com.unogwudan.stocks.repositories;

import org.springframework.data.repository.CrudRepository;

import com.unogwudan.stocks.models.Stock;

public interface StockRepository extends CrudRepository<Stock, Integer> {

}
