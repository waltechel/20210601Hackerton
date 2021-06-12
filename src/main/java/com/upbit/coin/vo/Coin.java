package com.upbit.coin.vo;

import java.time.LocalDateTime;

import lombok.Data;

/**
 * @Data
 * @author leedongjun
 *         lombok을 사용하면 VO 클래스를 컴파일 할 때,
 *         자동으로 생성자, Getter, Setter, toString()같은 코드를 자동으로
 *         추가해준다.
 */
@Data
public class Coin {

	private String coin_name;

	private double price;

	private LocalDateTime update_date;

}
