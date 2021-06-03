<template>
  <div>
    <div class="header">
      <b-navbar toggleable="lg" type="dark" variant="dark">
        <b-navbar-brand tag="h1" class="mb-0 naviagtor" href="#">구매 화면</b-navbar-brand>

        <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

        <b-collapse id="nav-collapse" is-nav>
          <b-navbar-nav>
            <b-nav-item href="#" @click="changeSubPage('CoinList')" class="item">CoinList(코인 살펴보기)</b-nav-item>
            <b-nav-item href="#" @click="changeSubPage('BuyingList')" class="item">BuyingList(구매내역)</b-nav-item>
            <b-nav-item href="#" @click="changeSubPage('Buy')" class="item">Buy(구매하기)</b-nav-item>
          </b-navbar-nav>
        </b-collapse>
      </b-navbar>
    </div>
    <div class="container">
      <component v-bind:is="currentView"></component>
    </div>
    <div>
      <h1>footer</h1>
    </div>
  </div>
</template>

<script>
  import CoinList from "./subpage/CoinList.vue";
  import BuyingList from "./subpage/BuyingList.vue";
  import Buy from "./subpage/Buy.vue";
  export default {
    name: "BuyCoin",
    components: { CoinList, BuyingList, Buy },
    data() {
      return {
        currentView: "CoinList"
      };
    },
    methods: {
      changeSubPage(subpage) {
        // debugger;
        this.currentView = subpage;
      }
    }
  };
</script>

<style>
  a.navbar-brand.mb-0.naviagtor {
    padding-left: 20px;
    margin-left: 20px;
  }
  .item {
    padding-left: 10px;
    margin-left: 10px;
  }
  .header {
    padding: 10px 0px 0px 0px;
  }
</style>