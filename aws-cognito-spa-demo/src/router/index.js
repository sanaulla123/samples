/* eslint-disable */
import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import auth from '../app/auth';
import LogoutSuccess from '@/components/LogoutSuccess';
import UserInfoStore from '../app/user-info-store';
import UserInfoApi from '../app/user-info-api';
import ErrorComponent from '@/components/Error';

Vue.use(Router)

function requireAuth(to, from, next) {
  
  if (!auth.auth.isUserSignedIn()) {
      UserInfoStore.setLoggedIn(false);
      next({
      path: '/login',
      query: { redirect: to.fullPath }
      });
  } else {
    UserInfoApi.getUserInfo().then(response => {
      UserInfoStore.setLoggedIn(true);
      UserInfoStore.setCognitoInfo(response);
      next();
    });
      
  }
}

export default new Router({
  mode: 'history',
  base: '/',
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home,
      beforeEnter: requireAuth
    },
    {
      path: '/login', beforeEnter(to, from, next){
        auth.auth.getSession();
      }
    },
    {
      path: '/login/oauth2/code/cognito', beforeEnter(to, from, next){
        var currUrl = window.location.href;
        
        //console.log(currUrl);
        auth.auth.parseCognitoWebResponse(currUrl);
        //next();
      }
    },
    {
      path: '/logout', component: LogoutSuccess,  beforeEnter(to, from, next){
        auth.logout();
        next();
      }

    },
    {
      path: '/error', component: ErrorComponent
    }
  ]
})
