<template>
    <div id="history-box">
        <ul>
            <li v-for="(equation, index) in equation_list" :key="index">
                {{ equation }}
            </li>
        </ul>
    </div>    
</template>

<script>
export default{
    name: "History",
    props: [
        "equation_list"
    ]
}
</script>

<style scoped>
    #history-box{
        height: 580px;
        width: 200px;
        background-color: white;
        border-style: solid;
        border-color: black;
        border-width: 2px;
        overflow: auto;
    }

    li{
        list-style-type: none;
        font-size: 18px;
    }
</style>