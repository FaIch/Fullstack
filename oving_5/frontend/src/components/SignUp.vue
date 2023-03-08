<template>
    <body>
        <div id="signup_box">
            <h3>Sign Up</h3>
            <form id="form" @submit.prevent="submitData()">
                <label for="username_input">Username:</label>
                <input id="username_input" type="text" v-model="formData.username" placeholder="Username">

                <label for="password_input">Password:</label>
                <input id="password_input" type="password" v-model="formData.password" placeholder="Password">

                <label for="re_password_input">Re enter password:</label>
                <input id="re_password_input" type="password" v-model="re_password" placeholder="Password">
                
                <label v-show="!matchingPasswords" id="errorLabel">Passwords are not matching!</label>

                <button :disabled="!matchingAndNotEmpty" type="submit" id="signupButton">Sign Up</button>
            </form>
        </div>
    </body>
</template>

<script>
    export default{
        name: "SignUp",

        data(){
            return{
                formData:{
                username: "",
                password: ""
                },

                re_password: ""

            }
        },

        methods: {
            submitData(){

            },

            encryptPassword(password){
                
            }
        },


        computed: {
            matchingPasswords() {
                return this.formData.password === this.re_password;
            },

            matchingAndNotEmpty(){
                return this.matchingPasswords && this.formData.password !== "" && this.re_password !== "";
            }
        }
    }
</script>

<style scoped>
body{
    align-items: center;
    color: black;
}

#signup_box{
    background-color: #b6b6b652;
    border-style: solid;
}

#errorLabel{
    color: red;
}

form{
    padding: 25px;
    display: grid;
    row-gap: 20px;
    width: 400px;
}

label, input{
    display: block;
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