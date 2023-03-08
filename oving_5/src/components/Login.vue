<template>
    <body>
        <div id="login_box">
            <form id="form" @submit.prevent="submitData()">
                <label for="username_input">Username:</label>
                <input id="username_input" type="text" v-model="formData.username" placeholder="Username">

                <label for="password_input">Password:</label>
                <input id="password_input" type="password" v-model="formData.password" placeholder="Password">
                
                

                <button type="submit" id="loginButton">Login</button>
            </form>
        </div>
    </body>
</template>

<script>
    export default{
        name: "Login",

        data(){
            return{
                formData:{
                username: "",
                password: ""
                }
            }
        },

        methods: {
            submitData(){

            }
        }
    }
</script>

<style scoped>
body{
    align-items: center;
}

form{
    background-color: #ddd;
    padding: 25px;
    display: grid;
    row-gap: 20px;
    width: 400px;
    border-style: solid;
}

label, input{
    display: block;
}

input{
    height: 30px;
    font-size: 20px;
}

#username_input, #password_input{
    display: grid;
    justify-items: center;
}


button{
    width: 60%;
    margin-left: auto;
    margin-right: auto;
    font-size: 18px;
    background-color: white;
}
</style>