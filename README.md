# Hackerton Project(20210601)
* Spring boot, Mybatis(Oracle), Vue.js, BootStrapVue를 활용한 해커톤 프로젝트 기초 샘플 프로젝트

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