package com.upbit.coin;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Component;

import com.upbit.coin.service.CoinService;

@Component
public class BeanUtils {

	@MockBean
	private CoinService coinService;
	
}
