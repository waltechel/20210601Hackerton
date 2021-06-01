package com.upbit.coin.service;

import java.util.ArrayList;
import java.util.Map;

import com.upbit.coin.vo.Coin;

public interface CoinService {

	ArrayList<Coin> searchAllCoins();

	Coin searchCoin(Map<String, Object> params);

	Coin updateCoin(Map<String, Object> params);

	Coin insertCoin(Map<String, Object> params);

	void deleteCoin(Map<String, Object> params);

}
