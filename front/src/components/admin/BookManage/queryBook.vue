<template>
  <el-container>
     <el-aside style="width: 200px;margin-top: 20px">
      <switch></switch>
      <SideMenu @indexSelect="listByCategory" ref="sideMenu"></SideMenu>
    </el-aside> 
    <el-main>
      <Books class="books-area" ref="booksArea"></Books>
    </el-main>
  </el-container>
</template>

<script>
  import SideMenu from './wwq1/SideMenu' 
  import Books from './wwq1/Books'

  export default {
    name: 'AppLibrary',
    components: {Books, SideMenu},
    methods: {
      listByCategory () {
        var _this = this
        var cid = this.$refs.sideMenu.cid
        //0全部 1文学 2流行 3文化 4生活 5经营 6科技
        var url = 'library/categories/' + cid + '/books'
        this.$axios.get(url).then(resp => {
          if (resp && resp.status === 200) {
            _this.$refs.booksArea.books = resp.data
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