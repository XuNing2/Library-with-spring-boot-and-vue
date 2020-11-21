<template>
   <!-- <el-container>
    <el-header style="margin-top: 5px; text-color: red">
        管理员界面
    </el-header> -->
    <!-- <el-container> -->
    <!-- <el-aside style="margin-top: 30px"> -->
      <!-- <el-row> -->
        <el-col :span="10" style="width: 205px; margin-top: 20px; margin-left: 20px">
            <el-menu
            :default-active="this.$route.path"
            class="el-menu-vertical-demo"
            @open="handleOpen"
            @close="handleClose"
            background-color="#545c64"
            text-color="#fff"
            active-text-color="#ffd04b"
            router>
              <el-submenu index="1" @open="handle">
                <template slot="title">
                    <i class="el-icon-menu"></i>
                    <span>用户管理</span>
                </template>
                <el-menu-item-group >
                    <el-menu-item index="/admin/queryUser">查询用户</el-menu-item>
                    <el-menu-item index="/admin/deleteUser">删除用户</el-menu-item>
                    <el-menu-item index="/admin/handleRequest">处理信息</el-menu-item>
                </el-menu-item-group>
              </el-submenu>
              <el-submenu index="2">
                <template slot="title">
                    <i class="el-icon-menu"></i>
                    <span>图书管理</span>
                </template>
                <el-menu-item-group>
                    <el-menu-item index="/admin/addBook">添加图书</el-menu-item>
                    <el-menu-item index="/admin/queryBook">查询图书</el-menu-item>
                    <el-menu-item index="/admin/deleteBook">删除图书</el-menu-item>
                    <el-menu-item index="/admin/changeBook">修改图书</el-menu-item>
                </el-menu-item-group>
              </el-submenu>
            </el-menu>
        </el-col>
      <!-- </el-row> -->
    <!-- </el-aside> -->
    <!-- </el-container> -->
  <!-- </el-container> -->
</template>

<script>
  export default {
    name: 'SideMenu',
    data () {
      return {
      }
    },
    methods: {
   }
 }
</script>

<style scoped>
  .categories {
    /* position: fixed; */
    /* margin-left: 50%; */
    /* left: 00px; */
    top: 100px;
    width: 100px;
  }
</style>