<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <h2>CoinMain page</h2>
    <b-table striped hover :items="items" v-model="items"></b-table>
    <div>
      <b-button variant="primary" @click="searchAllCoin">모든 코인 조회</b-button>
      <b-button variant="secondary" @click="searchCoinByCoinName">특정 코인 조회</b-button>
      <b-button variant="dark" @click="updateCoinByCoinName">업데이트</b-button>
      <b-button variant="success" @click="insertCoinByCoinName">추가</b-button>
      <b-button variant="danger" @click="deleteCoinByCoinName">삭제</b-button>
      <b-button variant="outline-primary" @click="goToMainPage">메인 페이지로 넘어가기</b-button>
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
    name: "CoinMain",
    // 컴포넌트들이 들어가는 부분
    components: {},
    data() {
      return {
        msg: "this is hello world page",
				items: [],
				params:{
					coinName: "",
					price: "",
					updateDate: ""
				}
      };
    },
    // 해당 뷰 페이지 가 생성되었을 때 나타나는 작업
    created() {},
    // 해당 뷰 페이지가 마운트 되었을 때 나타나는 작업
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
        this.$axios
					.get("/api/coin/search",{
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
      goToMainPage: function() {
        this.$router.push("/");
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
