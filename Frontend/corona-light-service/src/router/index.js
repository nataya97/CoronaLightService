/*import Vue from 'vue'
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
*/

import Vue from 'vue'
import VueRouter from 'vue-router'
import State from "../components/State";
import District from "../components/District";
import authentication from '../wrapper'

Vue.use(VueRouter)

/*const routes = [
  {
    path: '/',
    redirect: '/state',
    name: 'State',
    component: State,
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
]*/

const router = new VueRouter({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'State',
      component: State,
      meta: {
        requiresAuthentication: true
      }
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
})

// Global route guard
router.beforeEach((to, from, next) => {
  if (to.matched.some(record => record.meta.requiresAuthentication)) {
    // this route requires auth, check if logged in
    if (authentication.isAuthenticated()) {
      // only proceed if authenticated.
      next();
    } else {
      authentication.signIn();
    }
  } else {
    next();
  }
});

export default router
