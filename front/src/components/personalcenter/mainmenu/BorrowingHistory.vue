<template>
  <el-container>
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
    <el-footer>
      <el-button round @click="refresh()" class="button">刷新</el-button>
    </el-footer>
  </el-container>
</template>

<script>
  export default {
    data() {
      return {
        username: '',
        tableData: [{
          book: '',
          borrowingtime: '',
          returntime: ''
        }]
      }
    },
    mounted:function() {
      this.init();
    },
    methods: {
      init() {
        this.username = localStorage.getItem('username');
        this.$axios
          .get('/personalcenter_state=bh', {
            username: this.username,
          })
          .then(successResponse => {
            if (successResponse.data.code === 200) {
              this.tableData = successResponse.data;
            }
          })
          .catch(failResponse => {
          })
      },
      refresh() {
        this.username = localStorage.getItem('username');
        this.$axios
          .get('/personalcenter_state=bh', {
            username: this.username,
          })
          .then(successResponse => {
            if (successResponse.data.code === 200) {
              this.tableData = successResponse.data;
            }
          })
          .catch(failResponse => {
          })
        this.tableData = [{
          book: '全国富婆通讯录',
          borrowingtime: '2020-11-14',
          returntime: '2020-11-15'
        }];
      }
    }
  }
</script>

<style>
  .button {
    margin-top: 20px;
    color: red;
  }
</style>