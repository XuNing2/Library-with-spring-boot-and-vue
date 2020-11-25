<template>
  <el-container>
    <el-main style="margin-top: 0px">
  <div id="user1" style="margin-top: 60px;opacity: 0.8;">
    用户信息
  </div>
  <div id="user4" style="margin-top: 10px;margin-left: 150px;margin-right: 150px;">
    <el-table
    :data="tableData"
    border
    style="width: 100%">
      <el-table-column
        prop="username"
        label="用户名"
        >
      </el-table-column>
      <el-table-column
        prop="telephone"
        label="电话"
        >
      </el-table-column>
      <el-table-column
        prop="role.rolename"
        label="角色"
        >
      </el-table-column>
      <el-table-column>
        <template slot-scope="scope">
          <el-button round @click="deleteUser(scope.row.username)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <div style="margin-top: 20px">
      <el-button round @click="addUser">添加用户</el-button>
      <el-button id="addUserElement1" round @click="cancel" style="display: none">取消添加</el-button>
    </div>
    <div id="addUserElement2" style="margin-top: 20px;display: none">
      <table class="white-pink">
    <label>
      <span>用户名 :</span>
      <input id= "name" name="name" v-model="info.username"/>
      <span>密码 :</span>
      <input id= "password" name="name" v-model="info.password"/>
      <span>电话 :</span>
      <input id= "telephone" name="telephone" v-model="info.telephone"/>
      <span>角色 :</span>
      <input id= "role" name="role" v-model="info.role_id"/>
    </label>
    <el-button native-type='submit' round id="submit" @click="submit()">提交信息</el-button>
  </table>
    </div>
  </div>
  </el-main>
  </el-container>
</template>

<script>
export default {
    name: 'queryUser',
    data(){
      return {
        info:{
          username: '',
          password: '',
          telephone: '',
          role_id: ''
        },
        tableData: [{
          username: '',
          telephone: '',
          role: {
            roleid: '',
            rolename: ''
          }
        }]
      }
    },
    mounted:function() {
      this.init();
    },
    methods: {
      init() {
        this.$axios
        .get('/admin/manageUser')
        .then((successResponse => {
            if (successResponse.data.code === 200) {
              console.log(successResponse.data.result);
              this.tableData = successResponse.data.result;
            }
          }))
      },
      deleteUser(val) {
        console.log(val);
        this.$axios
        .post('/admin/manageUser/'+val+'/deleteUser')
        .then((successResponse => {
            if (successResponse.data.code === 200) {
              console.log(successResponse);
            }
          }))
          location.reload();
      },
      addUser(){
        document.getElementById("addUserElement1").style.display = '';
        document.getElementById("addUserElement2").style.display = '';
      },
      cancel(){
        document.getElementById("addUserElement1").style.display = 'none';
        document.getElementById("addUserElement2").style.display = 'none';
      },
      submit(){
        var username = this.tableData[0].username;
        var id = this.tableData[0].id;
        var password = this.tableData[0].password;
        var telephone = this.tableData[0].telephone;
        var roleid = this.tableData[0].roleid;
        var rolename = this.tableData[0].rolename;
        this.tableData[0].id = '';
        this.tableData[0].password = this.info.password;
        this.tableData[0].telephone = this.info.telephone;
        this.tableData[0].username = this.info.username;
        this.tableData[0].role.roleid = this.info.role_id;
        this.tableData[0].role.rolename = this.find(this.info.role_id);
        console.log(this.tableData[0].rolename);
        this.$axios
        .post('/admin/manageUser/addUser',
        // {
        //   username: this.info.username,
        //   password: this.info.password,
        //   telephone: this.info.telephone,
        //   // role: this.info.role_id
        // }
        this.tableData[0]
        )
        .then((successResponse => {
            if (successResponse.data.code === 200) {
              console.log(successResponse);
            }
          }))
        this.tableData[0].username = username;
        this.tableData[0].id = id;
        this.tableData[0].password = password;
        this.tableData[0].telephone = telephone;
        this.tableData[0].role.roleid = roleid;
        this.tableData[0].role.rolename = rolename;
          location.reload();
      },
      find(val){
        switch(val){
          case 1:
            return '图书管理员';
            break;
          case 2:
            return '书籍管理员';
            break;
          case 3:
            return '用户管理员';
            break;
          case 4:
            return '读者';
            break;
          default:
            return '读者';
        }

      }
    }
}
</script>

<style scoped>
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