 <template>
 
    <el-table
      :data="tableData"
      style="width: 65%"
      max-height="400"
     
      >
      <el-table-column
        prop="information"
        label="通知"
        width="180"
        
        >
      </el-table-column>
      <el-table-column
        prop="date"
        label="日期"
        width="110">
      </el-table-column>
     
    </el-table>
 
  </template>

<style scoped>

</style>


  <script>
    export default {
      data() {
        return {
          tableData: [{
            information: '<<西游记>>归还超时',
            date: '2020.12.01',
          }, {
           information: '<<西游记>>归还超时',
            date: '2020.12.01',
          }, {
            information: '<<西游记>>归还超时',
            date: '2020.12.01',
          }, {
            information: '<<西游记>>归还超时',
            date: '2020.12.01',
          }, {
            information: '<<西游记>>归还超时',
            date: '2020.12.01',
          }, {
            information: '<<西游记>>归还超时',
            date: '2020.12.01',
          }, {
            information: '<<西游记>>归还超时',
            date: '2020.12.01',
          }, {
            information: '<<西游记>>归还超时',
            date: '2020.12.01',
          }, {
            information: '<<西游记>>归还超时',
            date: '2020.12.01',
          }, {
            information: '<<西游记>>归还超时',
            date: '2020.12.01',
          }, {
            information: '<<西游记>>归还超时',
            date: '2020.12.01',
          }]
        }
      }
    }
  </script>