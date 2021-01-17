import Vue from 'vue'
import VueRouter from 'vue-router'
import State from "../components/State";
import District from "../components/District";
import authentication from '../wrapper'

Vue.use(VueRouter)

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
