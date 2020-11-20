<template>
  <div>
    <el-container>
  <el-header height="170px"> 
    <br>  
 

<img src="https://s3.ax1x.com/2020/11/16/Dkq0tU.png" alt="" width="667" height="109">

    <br>  
    </el-header>
     <el-container  style="background:#EBEEF5">
    <el-aside></el-aside>
  <el-main >

    <br>
    <huadongchuang ></huadongchuang>
  
  </el-main>
     <el-aside></el-aside>
     </el-container>
     <br>
<br>
<br>
 <el-container>
    <el-aside></el-aside>
   <el-container>

   <el-header>
     <img src="https://s3.ax1x.com/2020/11/19/DKknC6.png" alt="" ></el-header>
     
  <br>
   <el-main class="setbg">
<br>
<br>
<br>
<br>
<Books class="books-area" ref="booksArea"></Books>
   </el-main>
 
    
   </el-container>

   <el-aside width="450px" style="float: right" >
    <br>
    <br>
    <br>
    
    <xiaoxitongzhi ></xiaoxitongzhi>
    
    </el-aside>
 </el-container>
    <el-container>
      <el-main>
          <br>

  我们组的项目为网上图书馆系统，该系统的宗旨是实现图书管理的系统化、规范化和自动化，达成图书资料集中、统一管理的目标。<br>
该系统实现了四大功能模块：
<br>1.日常工作模块：借书管理、还书管理、登录功能
<br>2.查询模块：图书资料查询、读者资料查询、借阅历史查询
<br>3.系统管理模块：图书管理、用户管理  
      </el-main>
    </el-container>
</el-container>
  </div>

</template>

<script>
import Books from './Homecommon/Books2.vue'
import huadongchuang from'./Homecommon/huadongchuang.vue'
import Xiaoxitongzhi from './Homecommon/xiaoxitongzhi.vue'

  export default {
    name: 'Home',

    components: {huadongchuang, Xiaoxitongzhi,Books},
    
     method:{
     searchResult () {
        var _this = this
        this.$axios
          .get('/search?keywords=' + this.$refs.searchBar.keywords, {
          }).then(resp => {
          if (resp && resp.status === 200) {
            _this.books = resp.data
          }
        })
      } 
  }
  }
 
</script>

<style scoped>
.setbg{
  background: url(https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1605866129084&di=4951638f6d4081208adb48117cb6b6bf&imgtype=0&src=http%3A%2F%2Fwww.51yuansu.com%2Fpic2%2Fcover%2F00%2F16%2F42%2F579b47c7588c4_610.jpg);
}
.books-area {
    width: 990px;
    margin-left: auto;
    margin-right: auto;
  }

</style>
