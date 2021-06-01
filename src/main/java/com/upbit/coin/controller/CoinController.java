package com.upbit.coin.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.upbit.coin.service.CoinService;
import com.upbit.coin.vo.Coin;

@RestController
public class CoinController {
	
	@Autowired
	private CoinService service;

	@GetMapping("/api/coin/searchAll")
	public ResponseEntity<?> searchAllCoins(){
		ArrayList<Coin> ret = service.searchAllCoins();
		return ResponseEntity.ok(ret);		
	}
	
	@GetMapping("/api/coin/search")
	public ResponseEntity<?> searchCoin(@RequestParam Map<String, Object> params){
		System.out.println("controller : params : " + params.toString());
		Coin coin = service.searchCoin(params);
		System.out.println("controller > coin : " + coin.toString());
		if(coin != null) {
			return ResponseEntity.ok(coin);
		}else {
			return ResponseEntity.badRequest().body(coin);
		}
		
	}
}
