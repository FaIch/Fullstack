let runningNumber = 0;

const counter = document.getElementById("counter");
const lorem = document.getElementById("lorem_ipsum");
const hide_show_button = document.getElementById("hide_show_button");
const word_1 = document.getElementById("word-1");
const word_2 = document.getElementById("word-2");
const word_3 = document.getElementById("word-3");

function increaseCounter(){
    runningNumber++;
    counter.innerText = runningNumber;
}

function hide_show_text(){
    if(!is_visible(lorem)){
        lorem.style.visibility = "visible";
        hide_show_button.innerText = "Hide";
    }
    else{
        lorem.style.visibility = "hidden";
        hide_show_button.innerText = "Show";
    }
}

function is_visible(e){
    if(window.getComputedStyle(e).visibility === "hidden"){
        return false;
    }
    return true;
}

function setWords(){
    const words = ["Shoe", "Dog", "Umbrella", "Computer", "Water", "Plate", "Cookies"];
    const words_out = [word_1,word_2,word_3];
    for(let i = 0; i < words_out.length; i++){
        index = Math.floor(Math.random() * words.length);
        words_out[i].innerHTML = words[index];
    }
}

function init(){
    document.getElementById("counter_button").
    addEventListener('click', function(){
        increaseCounter();
    })
    hide_show_button.addEventListener('click', function(){
        hide_show_text();
    })
    setWords();
}

init();