<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <h2>CoinMain page</h2>
    <b-table striped hover :items="items" v-model="items"></b-table>
    <div>
      <b-button @click="searchAllCoin">Button</b-button>
      <b-button variant="danger">Button</b-button>
      <b-button variant="success">Button</b-button>
      <b-button variant="outline-primary">Button</b-button>
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
        items: []
      };
    },
    // 해당 뷰 페이지 가 생성되었을 때 나타나는 작업
    created() {},
    // 해당 뷰 페이지가 마운트 되었을 때 나타나는 작업
    methods: {
			searchAllCoin: function(){
				// debugger;
				alert("searchAllCoin method is called");
				this.$axios.get("/api/coin/searchAll")
				.then((data) => {
					debugger;
					console.log(data)
					// alert(data)
					this.items = data.data
				})
				.catch((error) => {
					alert(error);
				})
				.finally(() => {
					alert("finally is called");
				});
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
