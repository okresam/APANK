import { createRouter, createWebHistory } from 'vue-router'
import store from './store.js'
import Login from './components/Login.vue'
import HelloWorldVue from './components/HelloWorld.vue'
import PleaseLogin from './components/PleaseLogin.vue'
import Register from './components/Register.vue'

const routes = [
    {
        path: '/',
        name: 'home',
        component: PleaseLogin
    },
    {
        path: '/login',
        name: 'Login',
        component: Login
    },
    {
        path: '/register',
        name: 'Register',
        component: Register
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router