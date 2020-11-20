<template>
  <!-- <el-menu
    :default-active="currentPath"
    router
    class="categories"
    default-active="0"
    @select="handleSelect"
    active-text-color="red">
    <el-menu-item index="0">
      <i class="el-icon-menu"></i>
      <span slot="title">个人信息</span>
    </el-menu-item>
    <el-menu-item index="1">
      <i class="el-icon-menu"></i>
      <span slot="title">借阅历史</span>
    </el-menu-item>
  </el-menu> -->
  <el-container>
    <el-aside style="width: 200px;margin-top: 30px">
      <el-tabs class="categories" v-model="activeName" tab-position="left" @tab-click="handleClick">
        <el-tab-pane label="个人信息" name="pi">
        </el-tab-pane>
        <el-tab-pane label="借阅历史" name="bh">
        </el-tab-pane>
        <el-tab-pane label="收藏图书" name="cb">
        </el-tab-pane>
      </el-tabs>
    </el-aside>
    <el-main>
      <div v-if="a">
        <personal-information></personal-information>
      </div>
      <div v-if="b">
        <borrowing-history></borrowing-history>
      </div>
      <div v-if="c">
        <collect-book></collect-book>
      </div>
    </el-main>
  </el-container>
</template>

<script>
 import BorrowingHistory from './mainmenu/BorrowingHistory'
 import PersonalInformation from './mainmenu/PersonalInformation'
 import CollectBook from './mainmenu/CollectBook'
  export default {
    name: 'SideMenu',
    components: {BorrowingHistory, PersonalInformation, CollectBook},
    data () {
      return {
        a: true,
        b: false,
        c: false,
        activeName: 'pi'
      }
    },
    methods: {
      handleClick(tab, event) {
        if(tab.name == 'pi'){
        	// 触发‘配置管理’事件
        	this.pi();
        }else if(tab.name == 'bh'){
        	// 触发‘用户管理’事件
        	this.bh();
        }else if(tab.name == 'cb'){
        	// 触发‘收藏图书’事件
        	this.cb();
        }
      },
      pi(){
        this.a = true;
        this.b = false;
        this.c = false;
      },
      bh(){
        this.b = true;
        this.a = false;
        this.c = false;
      },
      cb(){
        this.c = true;
        this.b = false;
        this.a = false;
      }
   }
 }
</script>

<style scoped>
  .categories {
    /* position: fixed; */
    /* margin-left: 50%; */
    /* left: 00px; */
    top: 100px;
    width: 150px;
  }
</style>