<template>
  <div class="container">
    <div class="calc-div"><Calculator/></div>
    <div><History/></div>
  </div>
</template>

<script>
import Calculator from '../components/Calculator.vue'
import History from '../components/History.vue';

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
    
  },
  
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

