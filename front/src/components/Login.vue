<!--<template>
  <el-card>
      用户名:<input type="text" v-model="loginForm.username" placeholder="请输入用户名"/>
      <br><br>
      密码： <input type="password" v-model="loginForm.password" placeholder="请输入密码"/>
      <br><br>
      <button v-on:click="login">登录</button>
  </el-card>
</template>-->
//登录功能实现
<template>
  <body id="paper">
  <el-form :model="loginForm" :rules="rules" class="login-container" label-position="left"
           label-width="0px" v-loading="loading">
    <h3 class="login_title">用户登录</h3>
    <h4 class="login_background"></h4>
    <!--<h5 class="username_rule">账号名开头两个字必须是刘鼎</h5>-->
    <el-form-item prop="username">
      <el-input type="text" v-model="loginForm.username"
                auto-complete="off" placeholder="账号"></el-input>
    </el-form-item>
    <el-form-item prop="password">
    <!--<h6 class="password_rule">密码开头两个字母必须是ld</h6>-->
      <el-input type="password" v-model="loginForm.password"
                auto-complete="off" placeholder="密码"></el-input>
    </el-form-item>

    <el-form-item style="width: 100%">
      <el-button type="primary" style="width: 40%;background: #505458;border: none" v-on:click="login">登录</el-button>
    </el-form-item>

    <el-form-item style="width: 100%">
      <el-button type="success"  style="width: 40%;background: #505458;border: none" v-on:click="register">立即注册</el-button>
    </el-form-item>
  </el-form>
  </body>
</template>
<script>
  export default {
    name: 'Login',
    data () {
      return {
        rules: {
          username: [{required: true, message: '用户名不能为空', trigger: 'blur'}],
          password: [{required: true, message: '密码不能为空', trigger: 'blur'}]
        },
        loginForm: {
          username: '',
          password: ''
        },
        responseResult: []
      }
    },
    methods: {
      login () {
        this.$axios
          .post('/login', {
            username: this.loginForm.username,
            password: this.loginForm.password
          })
          .then(successResponse => {
            if (successResponse.data.code === 200) {
              // goto();
              this.$router.replace({path: '/index'});
              localStorage.setItem('username',this.loginForm.username)
              localStorage.setItem('userid',successResponse.data.result.id)
            }
          })
          .catch(failResponse => {
          })
      },
      goto() {
        this.$axios
          .get('/login/'+this.loginForm.username+'/goto')
          .then(successResponse => {
            if (successResponse.data.code === 200) {
              if(successResponse.data.role_id == '1'){
                this.$router.replace({path: '/index'});
              }
              else if(successResponse.data.role_id == '2'){
                this.$router.replace({path: '/admin'});
              }
            }
          })
          .catch(failResponse => {
          })
      },
      register()
      {
        this.$router.push({ name:'Register'})
      }
    }
  }
</script>
<style>
  body{
    margin: -5px 0px;
  }
  .login_background{
  position: absolute;
  left: 0%;
  top: 0%;
  width: 2000px;
  height: 1000px;
  padding: 10px;
  color: red;
  z-index:-1;
  background: rgba(0, 0, 0, 0) url("../assets/background_1.jpg") no-repeat scroll 100% 100%;
      background-size: auto;
  background-size: cover;
}
  .login-container {
    border-radius: 15px;
    background-clip: padding-box;
    margin: 90px auto;
    width: 350px;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
  }
  .login_title {
    margin: 0px auto 40px auto;
    text-align: center;
    color: #505458;
    z-index:0;
  }
  .username_rule {
    margin: -20px auto 5px auto;
    text-align: left;
    color:rgb(78, 117, 156,56);
    z-index:0;
  }
  .password_rule {
    margin: -20px auto 5px auto;
    text-align: left;
    color:rgb(78, 117, 156,56);
    z-index:0;
  }
  .login_remember {
    margin: 0px 0px 35px 0px;
    text-align: left;
  }
</style>

