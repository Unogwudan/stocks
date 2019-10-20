package com.unogwudan.stocks.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unogwudan.stocks.models.Stock;
import com.unogwudan.stocks.repositories.StockRepository;

@Service
public class StockService {
	
	@Autowired
	StockRepository stockRepository;

	public List<Stock> getAllStocks() {
		List<Stock> stockList = new ArrayList<Stock>();
		stockRepository.findAll().forEach(stockList:: add);
		return stockList;
	}
	
	public Stock getStock(Integer stockId) {
		return stockRepository.findById(stockId).get();
	}

	public void addStock(Stock stock) {
		stockRepository.save(stock);
	}

	public void updateStock(Integer id, Stock stock) {
		Stock stockObject = null;
		try {
			 stockObject = stockRepository.findById(id).get();
		}catch(Exception e) {
			System.out.println("No stock found with given id");
		}
		if(stockObject != null)
			stockRepository.save(stock);
	}
	
	public void deleteStock(Integer id) {
		stockRepository.deleteById(id);
	}

}
