package com.upbit.coin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication
 * @author leedongjun
 * 자동 컴포넌트 스캔
 * 애노테이션은 스프링 부트로 만든 애플리케이션의 시작 클래스임을 의미
 */
@SpringBootApplication
public class Application {

	/**
	 * 유일하게 구현된 main() 메서드는 SpringApplication 객체의 run() 메서드를
	 * 정적(static) 메서드 방식으로 호출한다.
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
