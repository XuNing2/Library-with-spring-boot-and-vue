<template>
  <div style="margin-bottom: 30px;display: flex;justify-content: center;align-items: center">
    <el-input
      @keyup.enter.native="searchClick"
      placeholder="通过书名/出版社/作者搜索..."
      prefix-icon="el-icon-search"
      size="small"
      style="width: 400px;margin-right: 10px"
      v-model="keywords">
      <el-select v-model="value" slot="prepend" placeholder="请选择">
        <el-option
          v-for="item in searchAttributes"
          :key="item.value"
          :label="item.label"
          :value="item.value">
        </el-option>
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
        cardLoading: [],
        searchAttributes:
        [
          {
            value: '1',
            label: '书名'
          },
          {
            value: '2',
            label: '出版社'
          },
          {
            value: '3',
            label: '作者'
          }
        ],
        value: ''
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