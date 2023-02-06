<template>
    <div id="formBox" @submit.prevent="submitData">
        <BaseInput
        v-model="inputs.name"
        label="Name"
        type="text"
        />

        <BaseInput
        v-model="inputs.email"
        label="Email"
        type="text"
        />
        <p>{{ email_result }}</p>

        <BaseInput
        v-model="inputs.message"
        label="Message"
        type="text"
        />

        <button @click="validateEmail" :disabled="isDisabled" type="submit">Submit</button>
        <div id="resultdiv">{{ post_result }}</div>
    </div>
</template>

<script>
import BaseInput from "@/components/BaseInput.vue"
import axios from "axios";

export default{
    components: {
        BaseInput,
    },

    data() {
        return {
            inputs: {
                name: "",
                email: "",
                message: "",
            },
            post_result: "",
            email_result: "",
        }
    },
    methods: {
        submitData() {
            this.$store.commit("SET_NAME",this.inputs.name);
            this.$store.commit("SET_EMAIL",this.inputs.email);
            axios.post(
                'https://my-json-server.typicode.com/FaIch/db/form',
                this.inputs
            )
            .then(
                this.post_result = "Success!",
                this.inputs.name = this.$store.state.name,
                this.inputs.email = this.$store.state.email
            )
            .catch(error =>{
                this.post_result = error
            })
        },
        validateEmail(){
            const regex = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
            if (!regex.test(String(this.inputs.email).toLowerCase())) {
                this.email_result = 'Please enter a valid email address'
            }
            else{
            this.submitData()
            this.email_result = ""
            return true
            }
        }
    },
    computed: {
        isDisabled() {
            return !(this.inputs.name && this.inputs.email && this.inputs.message);
        }
    },
    created(){
        this.inputs.name = this.$store.state.name;
        this.inputs.email = this.$store.state.email;
    }
}
</script>

<style scoped>
button{
    background-color: white;
    border-radius: 10%;
    color: black;
    font-size: large;
    font-weight: 500;
}
button:disabled{
    color: grey;
    border-style: none;
}

p{
    color:red;
}

#resultdiv{
    color: white;
}
</style>