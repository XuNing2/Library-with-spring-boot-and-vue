<template>
  <el-container>
    <el-main style="margin-top: 60px">
  <table class="white-pink">
    <label>
      <span>用户名字 :</span>
      <input id= "name1" name="name" v-model="info.name" placeholder="请输入用户名字"/>
    </label>
    <el-button round @click="query()">查询</el-button>
  </table>
  <div id="user1" style="margin-top: 60px;opacity: 0.8;display: none">
    用户信息
  </div>
  <div id="user2" style="margin-top: 15px; display: none" >
    <table class="white-pink">
    <label title="用户信息">
      <span>姓名 :</span>
      <input id= "name2" name="name" :readonly="true"/>
      <span>电话 :</span>
      <input id= "telephone" name="telephone" :readonly="true"/>
      <span>角色 :</span>
      <input id= "role" name="role" :readonly="true"/>
    </label>
    </table>
  </div>
  <div id="user3" style="margin-top: 60px;opacity: 0.8; display: none">
    用户借阅记录
  </div>
  <div id="user4" style="margin-top: 10px;margin-left: 150px; display: none">
    <el-table
    :data="tableData"
    border
    style="width: 80%">
      <el-table-column
        prop="ISBN"
        label="ISBN"
        >
      </el-table-column>
      <el-table-column
        prop="bookname"
        label="书名"
        >
      </el-table-column>
      <el-table-column
        prop="author"
        label="作者"
        >
      </el-table-column>
    </el-table>
  </div>
  </el-main>
  </el-container>
</template>

<script>
export default {
    name: 'queryUser',
    data(){
      return {
        info: {
          name: '',
        },
        tableData: [{
          ISBN: '',
          bookname: '',
          author: ''
        }]
      }
    },
    methods: {
      query() {
        this.$axios
        .get('/admin/queryUser',{username: this.info.name})
        .then((successResponse => {
            if (successResponse.data.code === 200) {
              document.getElementById("name").value = this.username;
              document.getElementById("telephone").value = successResponse.data.telephone;
              document.getElementById("role").value = successResponse.data.role;
              this.tableData = successResponse.data.tableData;
              document.getElementById("user1").style.display = '';
              document.getElementById("user2").style.display = '';
              document.getElementById("user3").style.display = '';
              document.getElementById("user4").style.display = '';
            }
          }))
        document.getElementById("name2").value = "张三";
        document.getElementById("telephone").value = "18012345678";
        document.getElementById("role").value = "读者";
        this.tableData = [{
          ISBN: '978-7-107-18618-6',
          bookname: '全国富婆通讯录',
          author: '李长春'
        },
        {
          ISBN: '978-7-107-18618-5',
          bookname: '全国富婆通讯录',
          author: '许宁'
        }];
        document.getElementById("user1").style.display = '';
        document.getElementById("user2").style.display = '';
        document.getElementById("user3").style.display = '';
        document.getElementById("user4").style.display = '';
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