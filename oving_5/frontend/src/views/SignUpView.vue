<template>
    <SignUp/>
</template>

<script>
import SignUp from '../components/SignUp.vue';

export default{
    name: "SignUpView",
    
    components:{
        SignUp
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