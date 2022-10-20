package com.upbit.coin.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.upbit.coin.service.CoinService;

@AutoConfigureMockMvc
@SpringBootTest
//@WebMvcTest(CoinController.class)
public class CoinControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private CoinService coinService;
	
	@Test
	public void testSearchAllCoins() throws Exception {
		
		//given
		BDDMockito.given(coinService.searchAllCoins()).willReturn(null);
		
		String url = "/api/coin/searchAll";
		mockMvc.perform(get(url))
				.andExpect(status().isOk())
				.andDo(print());
	}

}
