/*import Vue from 'vue'
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
*/

import Vue from 'vue'
import App from './App.vue'
import router from './router'
import vuetify from './plugins/vuetify';
import 'roboto-fontface/css/roboto/roboto-fontface.css'
import '@mdi/font/css/materialdesignicons.css'
import authentication from './wrapper'

Vue.config.productionTip = false

/**new Vue({
  router,
  vuetify,
  render: h => h(App)
}).$mount('#app')**/


Vue.config.productionTip = false

// Init adal authentication - then create Vue app.
authentication.initialize().then(_ => {
  /* eslint-disable no-new */
  new Vue({
    el: '#app',
    router,
    vuetify,
    template: '<App/>',
    components: { App },
    render: h => h(App),
    var: _
  });
});

//new Vue({ el: '#app', router, render: h => h(App) })
