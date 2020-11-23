import Vue from 'vue'
import VueRouter from 'vue-router'
// import Home from '../views/Home.vue'
// 导入刚才编写的组件
import AppIndex from '../components/home/AppIndex.vue'
import Login from '../components/Login.vue'
import Home from '../components/Home'
import PersonalCenter from '../components/personalcenter/PersonalCenter'
import Register from '../components/Register.vue'
import LibraryIndex from '../components/library/LibraryIndex'
import Admin from '../components/admin/Admin'
import manageUser from '../components/admin/UserManage/manageUser'
import manageBook from '../components/admin/BookManage/manageBook'

Vue.use(VueRouter)
//pus
// const routes = [
//   // {
//   //   path: '/',
//   //   name: 'Home',
//   //   component: Home
//   // },
//   // {
//   //   path: '/about',
//   //   name: 'About',
//   //   // route level code-splitting
//   //   // this generates a separate chunk (about.[hash].js) for this route
//   //   // which is lazy-loaded when the route is visited.
//   //   component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
//   // },
//   {
//     path: '/',
//     redirect:'/login'
//   },
//   {
//     path: '/login',
//     name: 'Login',
//     component: Login
//   },
//   {
//     path: '/index',
//     name: 'AppIndex',
//     component: AppIndex
//   }
// ]

// const router = new VueRouter({
//   mode: 'history',
//   base: process.env.BASE_URL,
//   routes
// })

// export default router

export default new VueRouter({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home,
      // home页面并不需要被访问
      redirect: '/login',
      children: [
        {
          path: '/index',
          name: 'AppIndex',
          component: AppIndex,
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/library',
          name: 'Library',
          component: LibraryIndex,
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/personalcenter',
          name: 'PersonalCenter',
          component: PersonalCenter,
          meta: {
            requireAuth: true
          }
        },
      //  {
      //    path: '/register',
      //   name: 'Register',
      //   component: Register,
      //    meta: {
      //      requireAuth: true
      //  }
       // }
      ]
    },
  //  {
  //    path: '/register',
  //    name: 'Register',
  //    component: Register,
   //   meta: {
    //    requireAuth: true
    //  }
    //},
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/admin',
      name: 'Admin',
      component: Admin,
      children: [
        {
          name: "manageUser",
          path: "/admin/manageUser",
          component: manageUser,
          meta: {
            requireAuth: true
          }
        },
        {
          name: "manageBook",
          path: "/admin/manageBook",
          component: manageBook
        },
      ]
    },
     {
       path: '/register',
       name: 'Register',
       component: Register,
       
       meta: {
         requireAuth: true
       },
      }
    
    //   children: [
    //     {
    //       path: '/personalcenter/PI',
    //       name: 'PersonalInformation',
    //       component: 
    //     }
    //   ]
    // }
  ]
})