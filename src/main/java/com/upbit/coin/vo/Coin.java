package com.upbit.coin.vo;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Coin {
	
	private String coin_name;
	
	private double price;
	
	private LocalDateTime update_date;

}
