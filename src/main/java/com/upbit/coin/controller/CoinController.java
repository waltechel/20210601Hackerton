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

/**
 * @RestController
 * @author leedongjun
 * View를 별도로 만들지 않는 대신 컨트롤러 메서드가 리턴한 데이터를 리턴
 * REST API
 */
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
//		System.out.println("controller : params : " + params.toString());
		Coin coin = service.searchCoin(params);
//		System.out.println("controller > coin : " + coin.toString());
		if(coin != null) {
			return ResponseEntity.ok(coin);
		}else {
			return ResponseEntity.badRequest().body(coin);
		}
		
	}
	
	@GetMapping("/api/coin/update")
	public ResponseEntity<?> updateCoin(@RequestParam Map<String, Object> params){
//		System.out.println("controller : params : " + params.toString());
		Coin coin = service.updateCoin(params);
//		System.out.println("controller > coin : " + coin.toString());
		if(coin != null) {
			return ResponseEntity.ok(coin);
		}else {
			return ResponseEntity.badRequest().body(coin);
		}
		
	}
	
	@GetMapping("/api/coin/insert")
	public ResponseEntity<?> insertCoin(@RequestParam Map<String, Object> params){
//		System.out.println("controller : params : " + params.toString());
		Coin coin = service.insertCoin(params);
//		System.out.println("controller > coin : " + coin.toString());
		if(coin != null) {
			return ResponseEntity.ok(coin);
		}else {
			return ResponseEntity.badRequest().body(coin);
		}
		
	}
	
	@GetMapping("/api/coin/delete")
	public ResponseEntity<?> deleteCoin(@RequestParam Map<String, Object> params){
//		System.out.println("controller : params : " + params.toString());
		service.deleteCoin(params);
//		System.out.println("controller > coin : " + coin.toString());
		return ResponseEntity.ok(null);
				
	}
}
