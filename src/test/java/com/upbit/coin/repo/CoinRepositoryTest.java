package com.upbit.coin.repo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.annotation.Rollback;

import com.upbit.coin.vo.Coin;

@MybatisTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(value = true)
public class CoinRepositoryTest {

	@Autowired
	private CoinRepository coinRepository;

	@Test
	public void selectTest() {
		List<Coin> coinList = coinRepository.selectAllCoins();
		for (Coin coin : coinList) {
			System.out.println(coin.toString());
		}
	}

}
