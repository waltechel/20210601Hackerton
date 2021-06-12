# Hackerton Project(20210601)
* Spring boot, Mybatis(Oracle), Vue.js, BootStrapVue를 활용한 해커톤 프로젝트 기초 샘플 프로젝트

---
### 시스템 실행하는 방법
#### git으로 해당 레포지토리를 받아옵니다.
1. git clone https://github.com/waltechel/20210601Hackerton.git
#### spring boot 서버를 동작시킵니다.
2. /src/main/java/com/upbit/coin/Application.java 파일 실행
#### npm 서버를 동작시킵니다.
3. cd src/webapp
4. npm install
5. npm start
#### http://localhost:4200 에서 동작을 확인합니다.

---
### 기술스택
* Spring boot(Spring 4 이상)
* Mybatis
* Vue.js
	* Vue.js 2버전을 바탕으로 만듦
	* CLI 3를 사용하지 않음
* BootstrapVue

---
### 필요 developing tools 
* github
* codemix
* Spring Tools 3 STS 또는 해당 스펙을 갖춘 eclipse
* npm(node.js)
* postman
* sqldeveloper

---
### Spring boot 라이브러리 
* Lombok
* Spring boot devtools
* Spring Web
* Mybatis
* Oracle Driver

---
### 오라클 사용하기 위한 테이블 명령어 및 기본 데이터 주입 쿼리
```oracle

DROP TABLE COIN;

CREATE TABLE COIN(
    COIN_NAME VARCHAR(100) NOT NULL PRIMARY KEY,
    PRICE NUMBER NOT NULL,
    UPDATE_DATE DATE DEFAULT SYSDATE NOT NULL
);

INSERT INTO COIN (COIN_NAME, PRICE, UPDATE_DATE) VALUES ('BIT', 50000000, SYSDATE);

INSERT INTO COIN (COIN_NAME, PRICE, UPDATE_DATE) VALUES ('ETH', 2000000, SYSDATE);

INSERT INTO COIN (COIN_NAME, PRICE, UPDATE_DATE) VALUES ('XRP', 1000, SYSDATE);

INSERT INTO COIN (COIN_NAME, PRICE, UPDATE_DATE) VALUES ('EOS', 500, SYSDATE);

INSERT INTO COIN (COIN_NAME, PRICE, UPDATE_DATE) VALUES ('DONGJUN', 500000000, SYSDATE);

COMMIT;

```

---
### Vue.js 프로젝트를 만들기 위한 명령어 모음
```cmd
ls
cd src
ls
vue init webpack webapp    
Project name webapp        
Project description this is vue.js project for hackerton project    
Author knecht    
Vue build standalone          
Install vue-router? Yes    
Use ESLint to lint your code? No    
Set up unit tests No    
Setup e2e tests with Nightwatch? No    
Should we run `npm install` for you after the project has been created? (recommended) npm    
ls
cd webapp
npm install
npm install --save axios
npm install vue bootstrap bootstrap-vue
npm add bootstrap bootstrap-vue
npm start
```

---
### Spring boot Project와 Vue.js를 연동하기 위한 프록시 설정
* src/webapp/config/index.js 파일에 설정
```javascript
proxyTable: {
	'/api': {
		target: 'http://localhost:8080',
		changeOrigin: true
	}
},
```
---
### Spring boot Project와 Vue.js를 연동하기 위한 axios 설정
* src/webapp/src/main.js 파일에 다음 문장 작성함으로써 axios를 전역에서 사용 가능하도록 설정    
```javascript
import axios from 'axios'    
Vue.prototype.$http = axios
```    

---
### Vue router 사용
* src/webapp/src/main.js 파일에 다음 문장 작성함으로써 router.js 파일에 vue-router를 사용할 수 있는 설정을 기록하도록 만듦
```javascript
import router from './router'
```
* src/webapp/src/router/index.js 파일에 내용을 작성함으로써 router.js 파일을 사용할 수 있도록 만듦
```javascript
import Router from 'vue-router'
Vue.use(Router)

```
---
### BootstrapVue 사용
* src/webapp/src/main.js 에 다음 문장 작성함으로써 BootstrapVue를 사용 가능하도록 설정
```javascript
Vue.use(BootstrapVue)    
Vue.use(IconsPlugin)
```

---
### 참고 자료와 사이트
* Mybatis.org      
	*	https://mybatis.org/mybatis-3/ko/index.html    
	* https://blog.mybatis.org/

* Vue.js Guide    
	* https://kr.vuejs.org/v2/guide/index.html

* BootstrapVue Guide    
	* https://bootstrap-vue.org/

* JavaTpoint
	* 자바 튜토리얼 사이트
	* https://www.javatpoint.com/java-tutorial

* Spring boot initializer
	* https://start.spring.io/

* postman
	* restapi 개발을 위한 웹 사이트
	* https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop?hl=ko	

---
### 참고 자료
#### ※ 해당 내용에 대해서는 저작권과 관련하므로 절대 수정 불가하며, fork 및 재사용 시 절대 수정하지 마십시오.

* 다음 책들의 내용을 프로젝트에 중간 중간 주석으로 달아 학생들의 해커톤 멘토링에 필요한 자료를 구성했음을 밝힙니다. 
* 프로젝트의 내용에 대해 原 저자 및 출판사의 별도 요청이 있을 시 레포지토리를 private하게 닫거나 저작권과 관련한 내용을 수정할 수 있습니다. 

* Vue.js 퀵 스타트(원형섭, 루비페이퍼, 2017)
	* https://www.aladin.co.kr/m/mproduct.aspx?ItemId=116453349

* 스프링 부트 퀵스타트(채규태, 루비페이퍼, 2019)
	* https://www.aladin.co.kr/m/mproduct.aspx?ItemId=195446636
	* 117쪽 까지의 내용이 반영되었으며, 해당 프로젝트는 JPA를 쓰지 않았으므로 그 이후의 내용은 반영되지 않았습니다.

* 코드로 배우는 스프링 웹 프로젝트(구멍가게 코딩단, 남가람북스, 2020)
	* https://www.aladin.co.kr/m/mproduct.aspx?ItemId=258087170

* 실전! 스프링 5와 Vue.js 2로 시작하는 모던 웹 애플리케이션 개발(제임스 J.예 지음, 김현만, 권봉혁, 변준석 옮김, 위키북스, 2020)
	* https://www.aladin.co.kr/m/mproduct.aspx?ItemId=227128459