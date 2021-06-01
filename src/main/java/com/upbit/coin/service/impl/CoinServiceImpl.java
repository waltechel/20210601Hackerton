package com.upbit.coin.service.impl;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upbit.coin.repo.CoinRepository;
import com.upbit.coin.service.CoinService;
import com.upbit.coin.vo.Coin;

@Service
public class CoinServiceImpl implements CoinService {

	//자동으로 묶어주는 어노테이션
	@Autowired
	private CoinRepository repo;
	
	@Override
	public ArrayList<Coin> searchAllCoins() {
		ArrayList<Coin> ret = repo.selectAllCoins();
		return ret;
	}

	@Override
	public Coin searchCoin(Map<String, Object> param) {
		Coin coin = new Coin();
		coin.setCoin_name((String) param.get("coinName"));
//		System.out.println("CoinserviceImpl : " + coin.toString());
		return repo.selectCoinbyCoinName(coin);
	}

	@Override
	public Coin updateCoin(Map<String, Object> params) {
		Coin coin = new Coin();
		coin.setCoin_name((String) params.get("coinName"));
		coin.setPrice(Double.parseDouble((String) params.get("price")));
		repo.updateCoinbyCoinInfo(coin);
//		System.out.println("CoinserviceImpl : " + coin.toString());
		return repo.selectCoinbyCoinName(coin);
	}

	@Override
	public Coin insertCoin(Map<String, Object> params) {
		Coin coin = new Coin();
		coin.setCoin_name((String) params.get("coinName"));
		coin.setPrice(Double.parseDouble((String) params.get("price")));
		repo.insertCoinbyCoinInfo(coin);
		return repo.selectCoinbyCoinName(coin);
	}

	@Override
	public void deleteCoin(Map<String, Object> params) {
		Coin coin = new Coin();
		coin.setCoin_name((String) params.get("coinName"));
		coin.setPrice(Double.parseDouble((String) params.get("price")));
		repo.deleteCoinbyCoinInfo(coin);
	}

}
