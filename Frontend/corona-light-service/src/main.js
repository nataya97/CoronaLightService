import Vue from 'vue'
import App from './App.vue'
import router from './router'
import vuetify from './plugins/vuetify'
import 'roboto-fontface/css/roboto/roboto-fontface.css'
import '@mdi/font/css/materialdesignicons.css'

Vue.config.productionTip = false

const app = new Vue({
  router,
  vuetify,
  render: h => h(App)
}).$mount('#app')

app.config.$msalInstance = {}
app.config.$emitter = require('tiny-emitter');
