<template>
  <div>
    <side-menu></side-menu>
    <router-view/>
  </div>
</template>

<script>
  import SideMenu from './SideMenu'
  export default {
    name: 'admin',
    components: {SideMenu}
  }
</script>

<style scoped>

</style>