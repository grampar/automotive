import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify';
import { store } from "./plugins/vuex"
import router from './router'


Vue.config.productionTip = false

new Vue({
  vuetify,
  store: store,
  router,
  render: h => h(App)
}).$mount('#app')
