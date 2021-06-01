package com.upbit.coin.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upbit.coin.service.CoinService;
import com.upbit.coin.vo.Coin;

@RestController
public class CoinController {
	
	@Autowired
	private CoinService service;

	@GetMapping("/api/coin/searchAll")
	public ResponseEntity<?> searchAllCoins(){
		System.out.println("searchAllCoins is called");
		System.out.println("searchAllCoins is called");
		System.out.println("searchAllCoins is called");
		System.out.println("searchAllCoins is called");
		System.out.println("searchAllCoins is called");
		ArrayList<Coin> ret = service.searchAllCoins();
		return ResponseEntity.ok(ret);		
	}
	
}
