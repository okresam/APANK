import { createRouter, createWebHistory } from 'vue-router'
import store from './store.js'
import Login from './components/Login.vue'
import HelloWorldVue from './components/HelloWorld.vue'
import PleaseLogin from './components/PleaseLogin.vue'
import Register from './components/Register.vue'
import ListAnketa from './components/ListAnketa.vue'
import Anketa from './components/Anketa.vue'

const routes = [
    {
        path: '/',
        name: 'home',
        component: ListAnketa
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
    },
    {
        path: '/anketa/:id',
        name: 'Anketa',
        component: Anketa
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

router.beforeEach(async (to, from) => {

    if (!store.state.user && to.name !== 'Login' && to.name !== 'Register') {
        return { name: 'Login' }
    }

    if (store.state.user && (to.name === 'Login' || to.name === 'Register')) {
        return { name: 'home' }
    }
})

export default router