import Vue from 'vue'
import App from './components/App.vue'
import axios from 'axios'
import router from './hooks/movie-api'
import moment from 'moment'
import VueCompositionAPI from '@vue/composition-api'

require("./assets/main.css");

Vue.config.productionTip = false
Vue.prototype.$http = axios
Vue.prototype.moment = moment
Vue.use(VueCompositionAPI);


new Vue({
    router,
    render: h => h(App)
}).$mount('#app')