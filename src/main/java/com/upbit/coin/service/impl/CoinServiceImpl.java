package com.upbit.coin.service.impl;

import java.util.ArrayList;

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

}
