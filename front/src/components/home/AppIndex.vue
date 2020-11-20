<template>
  <div>
    <el-container>
  <el-header> 
    <br>  
  <p>

<img src="https://s3.ax1x.com/2020/11/16/Dkq0tU.png" alt="" width="667" height="109">
</p>
    <br>  
    
    <sousuokuang @onSearch="searchResult" ref="searchBar"></sousuokuang>
    </el-header>
  <el-main>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <huadongchuang></huadongchuang>

 </el-main>
 <el-container>
   <el-main>
<br>
<br>
<img src="https://s3.ax1x.com/2020/11/19/DKknC6.png" alt="" >
<br>
<br>
<br>
<Books class="books-area" ref="booksArea"></Books>

   </el-main>
   <el-aside>
    <br>
    <br>
    <br>
    <xiaoxitongzhi></xiaoxitongzhi></el-aside>
 </el-container>
    <el-container>
      <el-main>
          <br>

    <p> 我们组的项目为网上图书馆系统，该系统的宗旨是实现图书管理的系统化、规范化和自动化，达成图书资料集中、统一管理的目标。</p>
<br>
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
import Sousuokuang from './Homecommon/sousuokuang.vue'
import huadongchuang from'./Homecommon/huadongchuang.vue'
import Xiaoxitongzhi from './Homecommon/xiaoxitongzhi.vue'

  export default {
    name: 'Home',

    components: {Sousuokuang,huadongchuang, Xiaoxitongzhi,Books},
    
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
.books-area {
    width: 990px;
    margin-left: auto;
    margin-right: auto;
  }
</style>
