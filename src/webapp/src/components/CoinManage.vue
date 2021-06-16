<template>
  <div class="hello">
    <!-- 중괄호 두 개를 넣어서 변숫값을 불러올 수 있습니다. -->
    <h1>{{ msg }}</h1>
    <h2>CoinMain page</h2>
    <!-- 여기가 부트스트랩뷰(BootstrapVue)를 활용한 부분이에요! -->
		<!-- v-model을 이용해서 양방향 데이터 렌더링을 구현 -->
    <b-table striped hover :items="items" v-model="items"></b-table>
    <div>
      <b-button variant="primary" @click="searchAllCoin">모든 코인 조회</b-button>
      <b-button variant="secondary" @click="searchCoinByCoinName">특정 코인 조회</b-button>
      <b-button variant="dark" @click="updateCoinByCoinName">업데이트</b-button>
      <b-button variant="success" @click="insertCoinByCoinName">추가</b-button>
      <b-button variant="danger" @click="deleteCoinByCoinName">삭제</b-button>
      <b-button variant="outline-primary" @click="goToMainPage">메인 페이지로 넘어가기</b-button>
			<b-button variant="outline-primary" @click="goToBuyPage">구매 페이지로 넘어가기</b-button>
    </div>
    <div>
      <span>
        <b-form-input v-model="params.coinName" placeholder="코인 이름을 입력하세요"></b-form-input>
        <b-form-input v-model="params.price" placeholder="코인 가격을 입력하세요"></b-form-input>
      </span>
    </div>
  </div>
</template>

<script>
  export default {
    name: "CoinManage",
    // 컴포넌트들이 들어가는 부분
    components: {},
    data() {
      return {
        msg: "this is hello world page",
        items: [],
        params: {
          coinName: "",
          price: "",
          updateDate: ""
        }
      };
		},
		/**
		 * Vue instance life cycle
		 * 1. created : Vue instance가 생성
		 * 2. mounted : 데이터가 마운트된 후에 호출
		 * 3. destroyed : Vue instance가 삭제된 이후에 호
		 */
    // 해당 뷰 페이지 가 생성되었을 때 나타나는 작업
    created() {},
		// 해당 뷰 페이지가 마운트 되었을 때 나타나는 작업
		mounted() {},
    methods: {
      searchAllCoin: function() {
        this.$axios
          .get("/api/coin/searchAll")
          .then(data => {
            debugger;
            console.log(data);
            this.items = data.data;
          })
          .catch(error => {
            alert(error);
          })
          .finally(() => {
            // alert("finally is called");
					});
      },
      searchCoinByCoinName: function() {
        if (this.params.coinName == undefined || this.params.coinName == "") {
          alert("코인 이름을 입력해주세요!");
          return;
        }
        this.$axios
          .get("/api/coin/search", {
            params: this.params
          })
          .then(data => {
            debugger;
            console.log(data);
            this.items = [];
            this.items.push(data.data);
          })
          .catch(error => {
            alert(error);
          })
          .finally(() => {
            // alert("finally is called");
          });
      },
      updateCoinByCoinName: function() {
        if (this.params.coinName == undefined || this.params.coinName == "") {
          alert("코인 이름을 입력해주세요!");
          return;
        }
        if (this.params.price == undefined || this.params.price == "") {
          alert("코인 가격을 입력해주세요!");
          return;
        }
        this.$axios
          .get("/api/coin/update", {
            params: this.params
          })
          .then(data => {
            this.searchCoinByCoinName();
          })
          .catch(error => {
            alert(error);
          })
          .finally(() => {
            // alert("finally is called");
          });
      },
      insertCoinByCoinName: function() {
        if (this.params.coinName == undefined || this.params.coinName == "") {
          alert("코인 이름을 입력해주세요!");
          return;
        }
        if (this.params.price == undefined || this.params.price == "") {
          alert("코인 가격을 입력해주세요!");
          return;
        }
        this.$axios
          .get("/api/coin/insert", {
            params: this.params
          })
          .then(data => {
            this.searchCoinByCoinName();
          })
          .catch(error => {
            alert(error);
          })
          .finally(() => {
            // alert("finally is called");
          });
			},
			deleteCoinByCoinName: function(){
					if (this.params.coinName == undefined || this.params.coinName == "") {
          alert("코인 이름을 입력해주세요!");
          return;
        }
        this.$axios
          .get("/api/coin/delete", {
            params: this.params
          })
          .then(data => {
						alert("삭제되었습니다!");
						this.items = [];
          })
          .catch(error => {
            alert(error);
          })
          .finally(() => {
            // alert("finally is called");
          });
			},
      goToMainPage: function() {
        this.$router.push("/");
			},
			goToBuyPage: function() {
        this.$router.push("/buyCoin");
      }
    }
  };
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  h1,
  h2 {
    font-weight: normal;
  }
  ul {
    list-style-type: none;
    padding: 0;
  }
  li {
    display: inline-block;
    margin: 0 10px;
  }
  a {
    color: #42b983;
  }
</style>
