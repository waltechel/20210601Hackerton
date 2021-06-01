package com.upbit.coin.repo;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.upbit.coin.vo.Coin;

@Mapper
public interface CoinRepository {

	ArrayList<Coin> selectAllCoins();

	Coin selectCoinbyCoinName(Coin coin);

	void updateCoinbyCoinInfo(Coin coin);

	void insertCoinbyCoinInfo(Coin coin);

	void deleteCoinbyCoinInfo(Coin coin);

}
