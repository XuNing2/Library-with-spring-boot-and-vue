<template>
  <el-container>
    <el-table
    :data="tableData"
    border
    style="width: 100%"
    >
      <el-table-column
        prop="book"
        label="书名"
        >
      </el-table-column>
      <el-table-column
        prop="date"
        label="日期"
        >
      </el-table-column>
      <el-table-column
        prop="havereturn"
        label="归还"
        :formatter="formatterColumn"
        >
      </el-table-column>
      <el-table-column>
        <template slot-scope="scope">
          <el-button round @click="returnbook(scope.row.book)" class="button">还书</el-button>
        </template>
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
        row: '',
        tableData: [{
          book: '',
          date: '',
          havereturn: ''
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
          .get('/personalcenter/borrowHistory?username='+this.username, {})
          .then(successResponse => {
            if (successResponse.data.code === 200) {
              console.log(successResponse);
              this.tableData = successResponse.data.result;
            }
          })
          .catch(failResponse => {
          })
      },
      refresh() {
        this.username = localStorage.getItem('username');
        this.$axios
          .get('/personalcenter/borrowHistory?username='+this.username, {})
          .then(successResponse => {
            if (successResponse.data.code === 200) {
              console.log("借阅");
              console.log(successResponse);
              this.tableData = successResponse.data.result;
            }
          })
          .catch(failResponse => {
          })
        // this.tableData = [{
        //   ISBN: '978-7-107-18618-6',
        //   bookname: '全国富婆通讯录',
        //   author: '李长春'
        // },
        // {
        //   ISBN: '978-7-107-18618-5',
        //   bookname: '全国富婆通讯录',
        //   author: '许宁'
        // }];
      },
      returnbook(val) {
        this.$axios
          .post('/personalcenter/returnBook?bookid='+this.tableData.book, {})
          .then(successResponse => {
            if (successResponse.data.code === 200) {
              console.log(success);
            }
          })
          .catch(failResponse => {
            console.log(fail);
          })
      },
      formatterColumn(row, column) {
        return row.havereturn  == 0 ? '未归还' : "已归还";
      }
    }
  }
</script>

<style>
  .button {
    margin-top: 20px;
    color: blue;
  }
</style>