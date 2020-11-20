<template>
  <el-container>
  <table class="white-pink">
    <label>
      <span>姓名 :</span>
      <input id= "name" name="name" v-model="info.name" :readonly="status"/>
      <span>电话 :</span>
      <input id= "telephone" name="telephone" v-model="info.telephone" :readonly="status"/>
      <span>角色 :</span>
      <input id= "role" name="role" v-model="info.role" :readonly="status"/>
    </label>
    <el-button @click="change()">修改个人信息</el-button>
    <el-button native-type='submit' id="submit" @click="submit()" :disabled="submit">提交个人信息</el-button>
  </table>
  </el-container>
</template>

<script>
  export default {
    data(){
      return {
        status: true,
        submit: true,
        username: "",
        info: {
          name: '',
          telephone: '',
          role: ''
        }
      }
    },
    mounted:function() {
      this.init();
    },
    methods: {
      init(){
        this.username = localStorage.getItem('username');
        this.$axios
        .get('/personalcenter/personalInformation',{username: this.username})
        .then((successResponse => {
            if (successResponse.data.code === 200) {
              document.getElementById("name").value = this.username;
              document.getElementById("telephone").value = successResponse.data.telephone;
              document.getElementById("role").value = successResponse.data.role;
            }
          }))
        document.getElementById("name").value = this.username;
        document.getElementById("telephone").value = "18012345678";
        document.getElementById("role").value = "读者";
      },
      change(){
        this.status = false;
        this.submit = false;
      },
      submit(){
        this.$axios
        .post('/personalcenter/changeInformation',{
          name: this.info.name,
          telephone: this.info.telephone,
          role: this.info.role
        })
        .then(successResponse => {
          if (successResponse.data.code === 200) {
          }
        })
        .catch(failResponse => {
        })
      }
    }
  }
</script>

<style>
  .white-pink {
 
    margin-left: auto;
 
         margin-right: auto;
 
         max-width: 700px;
         width: 600px;
 
         background: #fff;
 
         padding: 30px 30px 20px 30px;
 
         box-shadow: rgba(187, 187, 187, 1) 0 0px 20px -1px;
 
         -webkit-box-shadow: rgba(187, 187, 187, 1) 0 0px 20px -1px;
 
         font: 12px Arial, Helvetica, sans-serif;
 
         color: #666;
 
         border-radius: 10px;
 
         -webkit-border-radius: 10px;
   }
 
 
.white-pink label {
 
         display: block;
 
         margin: 0px 0px 5px;
 
}
 
.white-pink label>span {
 
         float: left;
 
         width: 20%;
 
         text-align: right;
 
         padding-right: 10px;
 
         margin-top: 10px;
 
         color: #969696;
 
}
.white-pink input {
 
         color: #555;
 
         width: 70%;
 
         padding: 3px 0px 3px 5px;
 
         margin-top: 2px;
 
         margin-right: 6px;
 
         margin-bottom: 16px;
 
         border: 1px solid #e5e5e5;
 
         background: #fbfbfb;
 
         height: 25px;
 
         line-height:15px;
 
         outline: 0;
 
         -webkit-box-shadow: inset 1px 1px 2px rgba(200,200,200,0.2);
 
         box-shadow: inset 1px 1px 2px rgba(200,200,200,0.2);
 
}
</style>