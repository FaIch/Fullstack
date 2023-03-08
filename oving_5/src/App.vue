<template>
  <nav>
    <router-link to="/">Login</router-link> |
    <router-link to="/form">Sign up</router-link>
  </nav>
  <router-view/>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  box-sizing: border-box;
  width: 500px;
  padding: 0 20px 20px;
  margin: 0 auto;
}

nav {
  padding: 30px 30px 0 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: white;
}
</style>
