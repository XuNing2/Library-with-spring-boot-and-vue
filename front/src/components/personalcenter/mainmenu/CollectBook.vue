<template>
  <el-container>
    <el-table
    :data="collectBook"
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
    </el-table>
    <el-footer>
      <el-button round @click="refresh_2()" class="button">刷新</el-button>
    </el-footer>
  </el-container>
</template>

<script>
  export default {
    data() {
      return {
        username: '',
        collectBook: [{
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
          .get('/personalcenter_state=cb', {
            username: this.username,
          })
          .then(successResponse => {
            if (successResponse.data.code === 200) {
              this.collectBook = successResponse.data;
            }
          })
          .catch(failResponse => {
          })
      },
      refresh_2() {
        this.username = localStorage.getItem('username');
        this.$axios
          .get('/personalcenter_state=cb', {
            username: this.username,
          })
          .then(successResponse => {
            if (successResponse.data.code === 200) {
              this.collectBook = successResponse.data;
            }
          })
          .catch(failResponse => {
          })
        this.collectBook = [{
          ISBN: '978-7-107-18618-5',
          bookname: '全国富婆通讯录',
          author: '李长'
        }];
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