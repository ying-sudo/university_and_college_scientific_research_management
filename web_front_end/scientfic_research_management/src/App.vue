<template>
  <div id="app">
    <headernav></headernav>
    <router-view/>
  </div>
</template>

<script>
import BaseHeaderNav from './components/views/BaseHeaderNav'

export default {
  name: 'App',
  components: {
    headernav: BaseHeaderNav
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
