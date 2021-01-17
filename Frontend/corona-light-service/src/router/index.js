import Vue from 'vue'
import VueRouter from 'vue-router'
import State from "../components/State";
import District from "../components/District";
import Home from "../components/Home";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home,
  },
  {
    path: '/state',
    name: 'State',
    component: State,
  },
  {
    path: '/district',
    name: 'District',
    component: District,
  }
]

const router = new VueRouter({
  routes,
})

export default router
