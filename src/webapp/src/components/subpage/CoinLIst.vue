<template>
  <div>
    <b-table striped hover :items="items" v-model="items"></b-table>
  </div>
</template>

<script>
  export default {
    name: "CoinList",
    data() {
      return {
        items: []
      };
		},
		mounted(){
			this.searchAllCoin();
		},
    methods: {
      searchAllCoin: function() {
        this.$axios
          .get("/api/coin/searchAll")
          .then(data => {
            console.log(data);
            this.items = data.data;
          })
          .catch(error => {
            alert(error);
          })
          .finally(() => {
            // alert("finally is called");
          });
      }
    }
  };
</script>

<style>
</style>