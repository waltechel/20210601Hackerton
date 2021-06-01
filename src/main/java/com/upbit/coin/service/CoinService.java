package com.upbit.coin.service;

import java.util.ArrayList;
import java.util.Map;

import com.upbit.coin.vo.Coin;

public interface CoinService {

	ArrayList<Coin> searchAllCoins();

	Coin searchCoin(Map<String, Object> params);

}
