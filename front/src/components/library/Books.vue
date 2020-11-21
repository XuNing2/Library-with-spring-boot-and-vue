<template>
  <div>
    <el-row style="height: 840px;">
      <search-bar @onSearch="searchResult" ref="searchBar"></search-bar>
      <el-tooltip effect="dark" placement="right"
                  v-for="item in books"
                  :key="item.id">
        <p slot="content" style="font-size: 14px;margin-bottom: 6px;">{{item.title}}</p>
        <p slot="content" style="font-size: 13px;margin-bottom: 6px">
          <span>{{item.author}}</span> /
          <span>{{item.press}}</span>
        </p>
        <p slot="content" style="width: 300px" class="abstract">{{item.outline}}</p>
        <el-card style="width: 135px;margin-bottom: 20px;height: 256px;float: left;margin-right: 15px" class="book"
                 bodyStyle="padding:10px" shadow="hover">
          <div class="cover">
            <img :src="item.cover" alt="封面">
          </div>
          <div class="info">
            <div class="title">
              {{item.title}}
            </div>
          </div>
          <div class="author">{{item.author}}</div>
          <el-button type="text" @click="open(item.id)" class="borrow">立即借书</el-button>
        </el-card>
      </el-tooltip>
    </el-row>
    <el-row>
      <el-pagination
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-size="pagesize"
        :total="books.length">
      </el-pagination>
    </el-row>
  </div>
</template>

<script>
  import SearchBar from './SearchBar'
  export default {
    name: 'Books',
    components: {SearchBar},
    data () {
      return {
        m:'借书成功',
        books: [
          {
            id: 1,
            author: '村上春树',
            title: '挪威的森林',
            press: '上海译文出版社',
            cate_id: 1,
            date: '2019.09.11',
            cover: 'https://img3.doubanio.com/view/subject/l/public/s1228930.jpg',
            outline: '故事讲述主角纠缠在情绪不稳定且患有精神疾病的直子和开朗活泼的小林绿子之间，展开了自我成长的旅程。自该书在日本问世，截止2012年在日本共销出1500余万册。',
          }
        ],
        currentPage: 1,
        pagesize: 10,
      }
    },
    mounted: function () {
      this.loadBooks()
    },
    methods: {
      loadBooks () {
        var _this = this
        this.$axios.get('/library/books').then(resp => {
          console.log(resp);
          if (resp && resp.data.code === 200) {
            console.log(resp);
            _this.books = resp.data.result
          }
        })
      },
      open(id) {
        this.$axios
              .post('/library/borrow', {id: id}).then(resp => {
          if (resp && resp.data.code === 200) {
            this.$alert('借书成功', '借书结果', {
              confirmButtonText: '确定',
              callback: action => {
                this.$message({
                  type: 'info',
                  message: `action: ${ action }`
                });
              }
            })
          }
          else{
            this.$alert('书库中暂无此书', '借书结果', {
              confirmButtonText: '确定',
              callback: action => {
                this.$message({
                  type: 'info',
                  message: `action: ${ action }`
                });
              }
            })
          }
        })
      },
      handleCurrentChange: function (currentPage) {
        this.currentPage = currentPage
      },
      searchResult () {
        var _this = this
        var value = this.$refs.searchBar.value
        //1 书名 2 出版社 3 作者
        this.$axios
          .get('library/search/'+value+'?keywords=' + this.$refs.searchBar.keywords, {
          }).then(resp => {
          if (resp && resp.data.code === 200) {
            _this.books = resp.data.result
          }
        })
      }   
    }
  }
</script>

<style scoped>
  .cover {
    width: 115px;
    height: 172px;
    margin-bottom: 7px;
    overflow: hidden;
    cursor: pointer;
  }

  img {
    width: 115px;
    height: 172px;
    /*margin: 0 auto;*/
  }

  .title {
    font-size: 14px;
    text-align: left;
  }

  .author {
    color: #333;
    width: 102px;
    font-size: 13px;
    margin-bottom: 6px;
    text-align: left;
  }

  .borrow{
    float: left;
    font-size: 10px;
  }

  .abstract {
    display: block;
    line-height: 17px;
  }

  a {
    text-decoration: none;
  }

  a:link, a:visited, a:focus {
    color: #3377aa;
  }
</style>