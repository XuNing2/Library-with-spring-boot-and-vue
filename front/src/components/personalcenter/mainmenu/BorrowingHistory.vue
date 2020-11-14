<template>
    <el-table
    :data="tableData"
    border
    style="width: 100%">
      <el-table-column
        prop="book"
        label="书籍"
        >
      </el-table-column>
      <el-table-column
        prop="borrowingtime"
        label="借阅日期"
        >
      </el-table-column>
      <el-table-column
        prop="returntime"
        label="归还日期"
        >
      </el-table-column>
    </el-table>
</template>

<script>
  export default {
    data() {
      return {
        tableData: [{
          book: '论富婆爱上我的500种方法',
          borrowingtime: '2020-11-14',
          returntime: '2020-11-15'
        }]
      }
    }
  }
</script>

<style>

</style>