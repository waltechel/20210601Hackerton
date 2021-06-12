import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import CoinManage from '@/components/CoinManage'
import BuyCoin from '@/components/BuyCoin'

Vue.use(Router)

export default new Router({
	mode: 'history',
  routes: [
		{
      path: '/coinManage',
      name: 'CoinManage',
      component: CoinManage
		},
		{
			path: '/buyCoin',
			name: 'buyCoin',
			component: BuyCoin
		},
		{
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
		}
  ]
})
