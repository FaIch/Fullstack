<template>
    <Login/>
</template>

<script>
import Login from '../components/Login.vue';

export default{
    name: "LoginView",
    
    components:{
        Login
    }
}
</script>

<style scoped>
    * {
        display: flex;
        justify-content: center;
        font-size: 30px;
        margin-top: 25px;
    }
</style>