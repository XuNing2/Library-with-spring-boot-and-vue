<template>
  <el-container>
    <el-table
    :data="tableData"
    border
    style="width: 100%">
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
      <el-table-column>
        <template slot-scope="scope">
          <el-button round @click="returnbook(scope.row.ISBN)" class="button">还书</el-button>
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
          ISBN: '',
          bookname: '',
          author: ''
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
          .get('/personalcenter/borrowHistory', {
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
          .get('/personalcenter/borrowHistory', {
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
          ISBN: '978-7-107-18618-6',
          bookname: '全国富婆通讯录',
          author: '李长春'
        },
        {
          ISBN: '978-7-107-18618-5',
          bookname: '全国富婆通讯录',
          author: '许宁'
        }];
      },
      returnbook(val) {
        this.$axios
          .get('/personalcenter/returnBook', {
            ISBN: val,
          })
          .then(successResponse => {
            if (successResponse.data.code === 200) {
              console.log(success);
            }
          })
          .catch(failResponse => {
            console.log(fail);
          })
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