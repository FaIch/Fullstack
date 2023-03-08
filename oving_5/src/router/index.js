import { createRouter, createWebHistory } from 'vue-router'
import CalculatorView from '../views/CalculatorView.vue'
import LoginView from '../views/LoginView.vue'

const routes = [
  {
    path: '/calculator',
    name: 'calculator',
    component: CalculatorView
  },

  {
    path: '/',
    name: 'login',
    component: LoginView
  }
  
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
