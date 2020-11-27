import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import store from './store'

// 设置反向代理，前端请求默认发送到 http://localhost:8443/api
var axios = require('axios')
axios.defaults.baseURL = 'http://localhost:8443/api'
// 全局注册，之后可在其他组件中通过 this.$axios 发送数据
Vue.prototype.$axios = axios
Vue.config.productionTip = false

Vue.use(ElementUI)

router.beforeEach((to, from, next) => {
  if (to.meta.requireAuth) {
    if (store.state.user.username) {
      next()
    } else {
      next({
        path: 'login',
        query: {redirect: to.fullPath}
      })
    }
  } else {
    next()
  }
}
)

// router.beforeEach((to, from, next) => {
//   if (to.matched.some(res => res.meta.requireAuth)) {// 判断是否需要登录权限
//     if (store.state.role_id==1) {// 判断条件，是否登录
//       next()  //条件匹配进行下一步路由
//     } else {// 条件不匹配则跳转到登录界面或指定页面
//       next({
//         path: '/login',
//         query: {redirect: to.fullPath} //这个会在地址栏上带上路径
//       })
//     }
//   } else {
//     next()
//   }
// })
// router.beforeEach((to, from, next) => {
//   if (to.matched.some(res => res.meta.requireAdmin)) {// 判断是否需要登录权限
//     if (store.state.role_id==2) {// 判断条件，是否登录
//       next()  //条件匹配进行下一步路由
//     } else {// 条件不匹配则跳转到登录界面或指定页面
//       next({
//         path: '/admin_login',
//         query: {redirect: to.fullPath} //这个会在地址栏上带上路径
//       })
//     }
//   } else {
//     next()
//   }
// })

new Vue({
  el: '#app',
  router,
  components: {App},
  template: '<App/>',
  store,
  render: h => h(App)
}).$mount('#app')
