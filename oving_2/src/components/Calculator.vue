<template>
  <div class="calculator">
        <section class="screen">
            {{ buffer }}
        </section>
        <section class="calc-buttons">
            <div class="calc-button-row">
                <button class="calc-button" v-for = "e in row_1_elements" :key="e" :class ="{triple: e == row_1_elements[0]}" @click="buttonClick(e)">{{ e }}</button>
            </div>

            <div class="calc-button-row">
                <button class="calc-button" v-for = "e in row_2_elements" :key="e" @click="buttonClick(e)">{{ e }}</button>
            </div>

            <div class="calc-button-row">
              <button class="calc-button" v-for = "e in row_3_elements" :key="e" @click="buttonClick(e)">{{ e }}</button>
            </div>

            <div class="calc-button-row">
              <button class="calc-button" v-for = "e in row_4_elements" :key="e" @click="buttonClick(e)">{{ e }}</button>
            </div>

            <div class="calc-button-row">
              <button class="calc-button" v-for = "e in row_5_elements" :key="e" :class ="{triple: e == row_5_elements[0]}" @click="buttonClick(e)">{{ e }}</button>
            </div>
        </section>
    </div>

</template>

<script>
export default {
  name: "Calculator",
  props: {
    msg: String
  },


  data() {
    return {
      buffer: "0",
      runningTotal: 0,
      previousOperator: null,
      current_equation: "",
      row_1_elements: ["C","/"],
      row_2_elements: [7,8,9,"x"],
      row_3_elements: [4,5,6,"+"],
      row_4_elements: [1,2,3,"-"],
      row_5_elements: [0,"="]
    }
  },

  methods: {
    buttonClick(value){
      if(isNaN(value)){
        this.handleSymbol(value);
      }
      else{
        this.handleNumber(value);
      }
    },

    handleSymbol(symbol){
    switch(symbol){
        case 'C':
            this.buffer = "0";
            this.runningTotal = 0;
            this.current_equation = "";
            break;
        case '=':
            if(this.previousOperator === null){
                return;
            }
            this.flushOperation(parseInt(this.buffer));
            this.previousOperator = null;
            this.previousOperator = null;
            this.buffer = this.runningTotal;
            this.runningTotal = 0;

            if(!this.isNumber(this.current_equation.charAt(0))){
              this.current_equation = "Ans " + this.current_equation + " = " + this.buffer;
            }
            else{
            this.current_equation = this.current_equation + " = " + this.buffer + "";
            }
            this.$emit("addEquation", this.current_equation);
            this.current_equation = "";
            break;
        case '+':
        case '-':
        case 'x':
        case '/':
            this.handleMath(symbol);
            if(this.current_equation.length > 0 && !this.isNumber(this.current_equation.charAt(this.current_equation.length-1))){
              return;
            }
            else if(this.current_equation.length === 0){
              return;
            }
            else{
            this.current_equation = this.current_equation + " " + symbol + " ";
            }
            break;
      }
    },

    handleMath(symbol){
      if(this.buffer === '0'){
          return;
      }
      
      const intBuffer = parseInt(this.buffer);

      if(this.runningTotal === 0){
        this.runningTotal = intBuffer;
      }
      else{
          this.flushOperation(intBuffer);
      }
      this.previousOperator = symbol;
      this.buffer = '0';
    },

    flushOperation(intBuffer){
      if(this.previousOperator === '+'){
        this.runningTotal += intBuffer;
      }
      else if(this.previousOperator === '-'){
        this.runningTotal -= intBuffer;
      }
      else if(this.previousOperator === 'x'){
        this.runningTotal *= intBuffer;
      }
      else if(this.previousOperator === '/'){
        this.runningTotal /= intBuffer;
      }
    },

    handleNumber(numberString){
      if(this.buffer === "0"){
        this.buffer = numberString;
        this.current_equation = this.current_equation + numberString + "";
        }
        else{
          this.buffer += numberString + "";
          this.current_equation = this.current_equation + numberString + "";
        }
    },
    
    isNumber(char) {
      return /^\d$/.test(char);
    }
  }
}

</script>

<style scoped>
.calculator{
    backdrop-filter: blur(5.5px);
    -webkit-backdrop-filter: blur(5.5px);
    background: rgba(255, 255, 255, 0.75);
    border-radius: 16px;
    box-shadow: 0 4px 30px rgba(35,35,35,0.1);
    color: #232323;
    flex-basis: 400px;
    height: 540px;
    padding: 20px 35px;
}

.screen{
    backdrop-filter: blur(5.5px);
    -webkit-backdrop-filter: blur(5.5px);
    background: rgba(255,255,255,0.75);
    border: 1px solid rgba(255, 255, 255, 0.01);
    border-radius: 16px;
    box-shadow: 0 4px 30px rgba(35,35,35,0.1);
    color: #232323;
    font-size: 35px;
    overflow: auto;
    padding: 20px;
    text-align: right;
    width: 356px;
}

.calc-button-row{
    display: flex;
    justify-content: space-between;
    margin: 5% 0;
}

.calc-button{
    backdrop-filter: blur(5.5px);
    -webkit-backdrop-filter: blur(5.5px);
    background: rgba(255,255,255,0.75);
    border: 1px solid rgba(255,255,255,0.01);
    border-radius: 16px;
    box-shadow: 0 4px 30px rgba(35,35,35,0.1);
    color: #232323;
    flex-basis: 20%;
    font-size: 24px;
    height: 65px;
}

.calc-button:last-child{
    background: orange;
}

.calc-button:hover{
    opacity: 0.6;
}

.triple{
    flex-basis: 73%;
}
</style>
