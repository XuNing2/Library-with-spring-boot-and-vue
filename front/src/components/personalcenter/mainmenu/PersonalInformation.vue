<template>
  <table class="white-pink">
    <label>
      <span>姓名 :</span>
      <input id= "name" name="name" />
      <span>电话 :</span>
      <input id= "telephone" name="telephone" />
      <span>角色 :</span>
      <input id= "role" name="role" />
    </label>
    <button onclick="change()">修改个人信息</button>
  </table>
</template>

<script>
  export default {
    data() {
      document.getElementById('name').value='王小虎';
      return {
          name: '王小虎',
          telephone: '18012345678',
          role: '用户',
          status: true
      }
    }
  }
  function change(){
    document.getElementById("role").value = document.getElementById("name").value;
  }
</script>

<style>
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