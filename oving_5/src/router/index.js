import { createRouter, createWebHistory } from 'vue-router'
import CalculatorView from '../views/CalculatorView.vue'

const routes = [
  {
    path: '/calculator',
    name: 'calculator',
    component: CalculatorView
  },
  
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
