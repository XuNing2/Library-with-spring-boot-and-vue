<template>
  <el-container>
       <!-- style="width: 200px;margin-top: 20px" -->
    <el-aside style="width: 200px;margin-top: 20px">
      <!-- <switch></switch> -->
      <SideMenu></SideMenu>
    </el-aside>
    <el-main>
    </el-main>
  </el-container>
</template>

<script>
  import SideMenu from './SideMenu'
  export default {
    name: 'PersonalCenter',
    components: {SideMenu}
  }
</script>

<style scoped>

</style>
