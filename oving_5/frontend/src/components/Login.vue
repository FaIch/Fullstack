<template>
    <body>
        <div id="login_box">
            <h3>Login</h3>
            <form id="form" @submit.prevent="submitData()">
                <label for="username_input">Username:</label>
                <input id="username_input" type="text" v-model="formData.username" placeholder="Username">

                <label for="password_input">Password:</label>
                <input id="password_input" type="password" v-model="formData.password" placeholder="Password">
                
                <label id="errorLabel"></label>

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

            },

            encryptPassword(password){

            }
        }
    }
</script>

<style scoped>
body{
    color: black;
}

#login_box{
    background-color: #b6b6b652;
    border-style: solid;
}

form{
    padding: 25px;
    display: grid;
    row-gap: 20px;
    width: 400px;
}

input{
    height: 40px;
    font-size: 25px;
    border: 1px solid #ccc;
    border-radius: 3px;
    width: 100%;
    box-sizing: border-box;
    font-family: montserrat;
    color: #2C3E50;
}

label{
    font-family: montserrat;
}


button{
    width: 60%;
    margin-left: auto;
    margin-right: auto;
    font-size: 18px;
    font-weight: bold;
    background: #fff;
    border-radius: 40px;
}

button:enabled:hover{
    transition: all .35s;
    background: #5a4edf;
    color: #fff;
}

</style>