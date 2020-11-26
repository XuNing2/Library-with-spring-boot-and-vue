<template>
  <el-container>
      <el-main style="margin-top: 0px">
        <el-button round @click="dialogFormVisible = true">添加图书</el-button>
<el-dialog title="添加图书" :visible.sync="dialogFormVisible">
  <el-form :model="form">
    <el-form-item label="ISBN" :label-width="formLabelWidth">
      <el-input id="id" v-model="info.id" auto-complete="off"></el-input>
    </el-form-item>
    <el-form-item label="书名" :label-width="formLabelWidth">
      <el-input id="title" v-model="info.title" auto-complete="off"></el-input>
    </el-form-item>
    <el-form-item label="作者" :label-width="formLabelWidth">
      <el-input id="author" v-model="info.author" auto-complete="off"></el-input>
    </el-form-item>
    <el-form-item label="出版社" :label-width="formLabelWidth">
      <el-input id="press" v-model="info.press" auto-complete="off"></el-input>
    </el-form-item>
    <el-form-item label="类别" :label-width="formLabelWidth">
      <el-input id="cate" v-model="info.cate" auto-complete="off"></el-input>
    </el-form-item>
    <el-form-item label="入馆日期" :label-width="formLabelWidth">
      <el-input id="date" v-model="info.date" auto-complete="off"></el-input>
    </el-form-item>
    <el-form-item label="封面" :label-width="formLabelWidth" prop="cover">
  <el-input v-model="form.cover" autocomplete="off" placeholder="图片 URL"></el-input>
  <img-upload @onUpload="uploadImg" ref="imgUpload"></img-upload>
</el-form-item>
  </el-form>
  <div slot="footer" class="dialog-footer">
    <el-button round @click="dialogFormVisible = false">取 消</el-button>
    <el-button native-type='submit' round id="submit" @click="submit()">提交信息</el-button>
  </div>
</el-dialog>
  
  
  <div id="user1" style="margin-top: 60px;opacity: 0.8;">
    图书信息
  </div>
  <div id="user4" style="margin-top: 10px;margin-left: 150px;margin-right: 150px;">
    <el-table
    :data="tableData"
    border
    style="width: 100%">
      <el-table-column
        prop="id"
        label="ISBN"
        >
      </el-table-column>
      <el-table-column
        prop="title"
        label="书名"
        >
      </el-table-column>
      <el-table-column
        prop="author"
        label="作者"
        >
      </el-table-column>
      </el-table-column>
      <el-table-column
        prop="press"
        label="出版社"
        >
      </el-table-column>
      </el-table-column>
      <el-table-column
        prop="category.name"
        label="类别"
        >
      </el-table-column>
      </el-table-column>
      <el-table-column
        prop="date"
        label="入馆日期"
        >
      </el-table-column>
      </el-table-column>
      <el-table-column
        prop="borrow"
        label="借阅状态"
        >
      </el-table-column>
      <el-table-column
        prop="cover"
        label="封面"
        >
      </el-table-column>
      <el-table-column>
        <template slot-scope="scope">
          <el-button round @click="deleteBook(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <br>
    <!-- <div style="margin-top: 20px">
      <el-button round @click="addBook=true">添加图书</el-button>

   
      <el-button id="addBookElement1" round @click="cancel" style="display: none">取消添加</el-button>
    </div>
    <!-- <div id="addBookElement2" style="margin-top: 20px;display: none">
      <table class="white-pink"> -->
    <!-- <label>
      <span>ISBN :</span>
      <input id= "id" name="id" v-model="info.id"/>
      <span>书名 :</span>
      <input id= "title" name="title" v-model="info.title"/>
      <span>作者 :</span>
      <input id= "author" name="author" v-model="info.author"/>
      <span>出版社 :</span>
      <input id= "press" name="press" v-model="info.press"/>
      <span>类别 :</span>
      <input id= "cate" name="cate" v-model="info.cate"/>
      <span>入馆日期 :</span>
      <input id= "date" name="date" v-model="info.date"/>
    </label>
    <el-button native-type='submit' round id="submit" @click="submit()">提交信息</el-button>
  <!-- </table> 
    </div> --> 
  </div> 

  </el-main>
  </el-container>
</template>

<script>
import ImgUpload from './wwq1/ImgUpload.vue'
export default {
    name: 'queryUser',
     components: {ImgUpload},
    data(){
      return {
        info:{
          id: '',
          title: '',
          author: '',
          press: '',
          cate: '',
          date: ''
        },
        tableData: [],
                dialogFormVisible: false,
        form: {
          name: '',
          region: '',
          date1: '',
          date2: '',
          delivery: false,
          type: [],
          resource: '',
          desc: ''
        },
        formLabelWidth: '120px'

      }
    },
    mounted:function() {
      this.init();
    },
    methods: {
      uploadImg () {
      this.form.cover = this.$refs.imgUpload.url
          },
      init() {
        this.$axios
        .get('/library/books')
        .then((successResponse => {
            if (successResponse.data.code === 200) {
              console.log(successResponse);
              this.tableData = successResponse.data.result;
            }
          }))
      },
      deleteBook(val) {
        console.log(val)
        this.$axios
        .post('/admin/manageBook/'+val+'/deleteBook')
        .then((successResponse => {
            if (successResponse.data.code === 200) {
            }
          }))
        this.init();
      },
      addBook(){
        document.getElementById("addBookElement1").style.display = '';
        document.getElementById("addBookElement2").style.display = '';
      },
      cancel(){
        document.getElementById("addBookElement1").style.display = 'none';
        document.getElementById("addBookElement2").style.display = 'none';
      },
      submit(){
        console.log(val)
        this.$axios
        .post('/admin/manageBook/addBook',{
          id: this.info.id,
          title: this.info.title,
          author: this.info.author,
          press: this.info.press,
          cate: this.info.cate,
          date: this.info.date
        })
        .then((successResponse => {
            if (successResponse.data.code === 200) {
            }
          }))
        this.init();
      }
    }
}
</script>

<style scoped>
.white-pink {
 
    margin-left: auto;
 
         margin-right: auto;
 
         max-width: 700px;
         width: 600px;
 
         background: #fff;
 
         padding: 30px 30px 20px 30px;
 
         box-shadow: rgba(187, 187, 187, 1) 0 0px 20px -1px;
 
         -webkit-box-shadow: rgba(187, 187, 187, 1) 0 0px 20px -1px;
 
         font: 12px Arial, Helvetica, sans-serif;
 
         color: #666;
 
         border-radius: 10px;
 
         -webkit-border-radius: 10px;
   }
 
 
.white-pink label {
 
         display: block;
 
         margin: 0px 0px 5px;
 
}
 
.white-pink label>span {
 
         float: left;
 
         width: 20%;
 
         text-align: right;
 
         padding-right: 10px;
 
         margin-top: 10px;
 
         color: #969696;
 
}
.white-pink input {
 
         color: #555;
 
         width: 70%;
 
         padding: 3px 0px 3px 5px;
 
         margin-top: 2px;
 
         margin-right: 6px;
 
         margin-bottom: 16px;
 
         border: 1px solid #e5e5e5;
 
         background: #fbfbfb;
 
         height: 25px;
 
         line-height:15px;
 
         outline: 0;
 
         -webkit-box-shadow: inset 1px 1px 2px rgba(200,200,200,0.2);
 
         box-shadow: inset 1px 1px 2px rgba(200,200,200,0.2);
 
}
</style>