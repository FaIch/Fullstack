<template>
    <div id="formBox">
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

        <BaseInput
        v-model="inputs.message"
        label="Message"
        type="text"
        />

        <button @click="submitData" :disabled="isDisabled" type="submit">Submit</button>
        <div>{{ $store.state.name }}</div>
    </div>
</template>

<script>
import BaseInput from "@/components/BaseInput.vue"
export default{
    name : "Form",
    components: {
        BaseInput
    },
    data() {
        return {
            inputs: {
                name: "",
                email: "",
                message: "",
            }
        }
    },
    methods: {
        submitData() {
            this.$store.commit("SET_DATA",this.inputs.name,this.inputs.email);
        }
    },
    computed: {
        isDisabled() {
            return !(this.inputs.name && this.inputs.email && this.inputs.message);
        }
    }
}
</script>

<style scoped>

</style>