package com.unogwudan.stocks.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.unogwudan.stocks.models.Reponse;
import com.unogwudan.stocks.models.Stock;
import com.unogwudan.stocks.services.StockService;

@RestController
@CrossOrigin(origins = "*")
public class StockController {

	@Autowired
	private StockService stockService;
	
	
	@GetMapping("/stocks")
	public List<Stock> getAllStocks() {
		return stockService.getAllStocks();
	}
	
	@GetMapping("stocks/{id}")
	public Stock getStock(@PathVariable Integer id) {
		return stockService.getStock(id);
	}
	
	@PostMapping("/stocks")
	public ResponseEntity<Reponse> addStock(@RequestBody Stock stock) {
		stock.setCreatedDate(new Date());
		stockService.addStock(stock);
		return new ResponseEntity<>(new Reponse(201, "Created Successful"), HttpStatus.CREATED);
	}
	
	@PutMapping("/stocks/{id}")
	public ResponseEntity<Reponse> updateStock(@RequestBody Stock stock, @PathVariable Integer id) {
		stock.setLastUpdated(new Date());
		stockService.updateStock(id, stock);
		return new ResponseEntity<>(new Reponse(201, "Updated Successfully"), HttpStatus.CREATED);
	}
	
	@DeleteMapping(value="stocks/{id}")
	public void deleteTopic(@PathVariable Integer id) {
		stockService.deleteStock(id);
	}
	
}
