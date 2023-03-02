import axios from 'axios';

const restCalc = axios.create({
    baseURL: "http://localhost:8090",
    headers: {
        "Content-Type": "application/json",
    }
})

export const postEquation = (equation) => {
    return restCalc.post("/calculate", equation);
}