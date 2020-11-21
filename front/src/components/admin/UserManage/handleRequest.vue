<template>
    <el-container>
    <el-main>
    <div style="margin-top: 50px">
    <el-table
    :data="tableData"
    border
    style="width: 100%">
      <el-table-column
        prop="username"
        label="用户名字"
        >
      </el-table-column >

      <el-table-column label="原信息">
        <template scope="scope">
          <!-- <el-button round @click="confirm(scope.row.primeInfo)" class="button">确认1</el-button> -->
        <el-table
        :data="scope.row.primeInfo"
        border
        style="width: 100%">
          <el-table-column
          prop="name"
          label="名字"
          >
          </el-table-column>
          <el-table-column
          prop="telephone"
          label="电话"
          >
          </el-table-column>
          <el-table-column
          prop="role"
          label="角色"
          >
          </el-table-column>
        </el-table>
        </template>

      </el-table-column>
      <el-table-column
        prop="changeInfo"
        label="修改信息"
        >
        
        <template scope="scopes">
        <el-table
        :data="scopes.row.changeInfo"
        border
        style="width: 100%">
          <el-table-column
          prop="name"
          label="名字"
          >
          </el-table-column>
          <el-table-column
          prop="telephone"
          label="电话"
          >
          </el-table-column>
          <el-table-column
          prop="role"
          label="角色"
          >
          </el-table-column>
        </el-table>
        </template>

      </el-table-column>
      <el-table-column>
        <template>
          <el-button round @click="confirm" class="button">确认</el-button>
          <el-button round @click="reject" class="button">驳回</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
        </el-main>
    </el-container>
</template>

<script>
export default {
    name: 'handleRequest',
    data(){
      return {
        tableData: [{
          username: '',
          primeInfo: [{
            name: '',
            telephone: '',
            role: ''
          }],
          changeInfo: [{
            name: '',
            telephone: '',
            role: ''
          }]
        }],
        // tableData: [{
        //   username: '',
        //   primeInfo: "",
        //   changeInfo: ""
        // }]
      }
    },
    mounted:function() {
      this.init();
    },
    methods: {
      init() {
        this.$axios
        .get('/admin/handleRequest')
        .then((successResponse => {
            if (successResponse.data.code === 200) {
              this.tableData = successResponse.data;
            }
          }))
        this.tableData = [{
          username: '1',
          primeInfo: [{
            name: '1',
            telephone: '1',
            role: '1'
          }],
          changeInfo: [{
            name: '1',
            telephone: '2',
            role: '1'
          }]
        }]
      },
      confirm(val){
        this.$axios
        .post('/admin/handleRequest/confirm',{
          name: this.tableData.changeInfo.name,
          telephone: this.tableData.changeInfo.telephone,
          role: this.tableData.changeInfo.telephone
        })
        .then((successResponse => {
            if (successResponse.data.code === 200) {
            }
          }))
      },
      reject(){
        this.$axios
        .post('/admin/handleRequest/reject',{
          name: this.tableData.changeInfo.name,
          telephone: this.tableData.changeInfo.telephone,
          role: this.tableData.changeInfo.telephone
        })
        .then((successResponse => {
            if (successResponse.data.code === 200) {
            }
          }))
      }
    }
}
</script>

<style scoped>
 input{
        border: 1px solid #ccc; 
        padding: 7px 0px;
        border-radius: 3px; /*css3属性IE不支持*/
        padding-left:5px; 
      }
</style>