<template>
    <div id="history-box">
        <p>25 x 25 = 120</p>
    </div>    
</template>

<script>
export default{
    name: "History",
    props: {
        msg: String
    },
    
    methods: {
        insertEquation(equation){
            var element = document.createElement("p");
            element.innerText = equation;
            document.getElementById('history-box').appendChild(element);
        }
    }

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
    }

    p{
        font-size: 20px;
    }
</style>