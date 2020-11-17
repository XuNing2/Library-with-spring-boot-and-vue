//注册功能实现
<template>
  <body id="paper">
  <el-form :model="registerForm" :rules="rules" class="login-container" label-position="left"
           label-width="0px" v-loading="loading">
    <h3 class="login_title">用户注册</h3>
    <el-form-item prop="username">
      <el-input type="text" v-model="registerForm.username"
                auto-complete="off" placeholder="账号"></el-input>
    </el-form-item>
    <el-form-item prop="password">
      <el-input type="password" v-model="registerForm.password"
                auto-complete="off" placeholder="密码"></el-input>
    </el-form-item>
    <el-form-item>
      <el-input type="text" v-model="registerForm.name"
                auto-complete="off" placeholder="真实姓名"></el-input>
    </el-form-item>
    <el-form-item>
      <el-input type="text" v-model="registerForm.phone"
                auto-complete="off" placeholder="电话号码"></el-input>
    </el-form-item>
    <el-form-item>
      <el-input type="text" v-model="registerForm.email"
                auto-complete="off" placeholder="E-Mail"></el-input>
    </el-form-item>
    <el-form-item style="width: 100%">
      <el-button type="primary" style="width: 40%;background: #505458;border: none" v-on:click="register">注册</el-button>
    </el-form-item>
  </el-form>
  </body>
</template>

<!--
<template>
  <el-card>
      用户名:<input type="text" v-model="registerForm.username" placeholder="请输入用户名"/>
      <br><br>
      密码： <input type="password" v-model="registerForm.password" placeholder="请输入密码"/>
      <br><br>
      真实姓名： <input type="password" v-model="registerForm.password" placeholder="请输入真实姓名"/>
      <br><br>
      电话号码： <input type="password" v-model="registerForm.password" placeholder="请输入电话号码"/>
      <br><br>
      E-Mail： <input type="password" v-model="registerForm.emali" placeholder="请输入E-mail"/>
      <br><br>
      <button v-on:click="register">注册</button>
  </el-card>
</template>
<script>

  export default {
    name: 'Register',
    data () {
      return {
        registerForm: {
          username: '',
          password: '',
          name:'',
          phont:'',
          email:''
        },
        responseResult: []
      }
    },
    methods: {
      register () {
        this.$axios
          .post('/register', {
            username: this.registerForm.username,
            password: this.registerForm.password,
            name: this.registerForm.name,
            phone: this.registerForm.phone,
            email: this.registerForm.email
          })
          .then(successResponse => {
            if (successResponse.data.code === 200) {
              this.$router.replace({path: '/login'})
            }
          })
          .catch(failResponse => {
          })
      }
    }
  }
</script>
-->

<script>
  export default{
    data () {
      return {
        rules: {
          username: [{required: true, message: '用户名不能为空', trigger: 'blur'}],
          password: [{required: true, message: '密码不能为空', trigger: 'blur'}]
        },
        checked: true,
        registerForm: {
          username: '',
          password: '',
          name: '',
          phone: '',
          email: ''
        },
        loading: false
      }
    },
    //push
    methods: {
      register () {
        var _this = this
        this.$axios
          .post('/register', {
              //表格不能重名，并且要与方法统一
            username: this.registerForm.username,
            password: this.registerForm.password,
            name: this.registerForm.name,
            phone: this.registerForm.phone,
            email: this.registerForm.email
          })
          .then(resp => {
            if (resp.data.code === 200) {
              this.$alert('注册成功', '提示', {
                confirmButtonText: '确定'
              })
              _this.$router.replace('/login')
            } else {
              this.$alert(resp.data.message, '提示', {
                confirmButtonText: '确定'
              })
            }
          })
          .catch(failResponse => {})
      }
    }
  }
</script>


<style>
  body{
    margin: -5px 0px;
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
  }
  .login_remember {
    margin: 0px 0px 35px 0px;
    text-align: left;
  }
</style>
