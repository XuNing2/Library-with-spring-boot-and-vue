<template>
  <div style="margin-bottom: 30px;display: flex;justify-content: center;align-items: center">
    <el-input
      @keyup.enter.native="searchClick"
      placeholder="通过书名或作者搜索..."
      prefix-icon="el-icon-search"
      size="small"
      style="width: 400px;margin-right: 10px"
      v-model="keywords">
      <el-select v-model="select" slot="prepend" placeholder="请选择">
        <el-option label="书名" value="1"></el-option>
        <el-option label="出版社" value="2"></el-option>
        <el-option label="作者" value="3"></el-option>
      </el-select>
    </el-input>
    <el-button size="small" type="primary" icon="el-icon-search" @click="searchClick">搜索</el-button>
  </div>
</template>

<script>
  export default {
    name: 'SearchBar',
    data () {
      return {
        keywords: '',
        books: [],
        cardLoading: []
      }
    },
    methods: {
      searchClick () {
        this.$emit('onSearch')
      }
    }
  }
</script>

<style scoped>

</style>