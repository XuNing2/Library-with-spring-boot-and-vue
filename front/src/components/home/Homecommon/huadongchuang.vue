<template>
  <el-carousel :interval="4000" type="card" height="400px">
    <el-carousel-item  class="carousel-item" v-for="item in imagesbox" :key="item.id">
      <img :src="item.idView" class="image">
     
    </el-carousel-item>
  </el-carousel>
</template>

<style>
   .carousel-item {
    width: 100%;
    height: 100%;
    background: #99a9bf;
    display: flex;
    justify-content: center;
  }

  .image {
    max-width: 100%;
    max-height: 100%;
  }
</style>

<script> 
  export default{
    data(){
      return {
        imagesbox:[{id:0,idView:require("../../../assets/P1.jpg")}, 
                   {id:1,idView:require("../../../assets/P2.jpg")},
                  {id:2,idView:require("../../../assets/P3.jpg")},
                  {id:3,idView:require("../../../assets/P4.jpg")},
                   ]
      }
    },
    methods: {
      
    },
    mounted() {
    }
  }
</script>
<style>
</style>