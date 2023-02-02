<template>
  <div class="container">
    <div class="calc-div"><Calculator @addEquation="getEquation"/></div>
    <div><History :equation_list="all_equations"/></div>
  </div>
</template>

<script>
import Calculator from '@/components/Calculator.vue'
import History from '@/components/History.vue';
import axios from 'axios';

export default {
  name: 'CalculatorView',
  components: {
    Calculator,
    History
  },

  data: () => {
    return {
      all_equations: []
    }
  },
  methods: {
    getEquation(sent_equation){
      this.all_equations.push(sent_equation);
    }
  },
  created(){
    axios.get('https://my-json-server.typicode.com/FaIch/db/events')
    .then(response =>{
      console.log("data:", response.data)
    })
  }
}
</script>
<style>
html{
    box-sizing: border-box;
    height: 100%;
}

body{
    align-items: center;
    background: linear-gradient(320deg, #2D3142, #4F5D75, #63c9b4);
    display: flex;
    height: inherit;
    justify-content: center;
}

.container{
  display: flex;
}

.calc-div{
  padding-right: 40px;
}
</style>

