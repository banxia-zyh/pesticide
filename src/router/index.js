import Vue from 'vue'
import Router from 'vue-router'
import Login from '../components/auth/Login'
import HelloWorld from '../components/HelloWorld'
import Register from '../components/auth/Register'
import Index from '../components/index/Index'
import UserInfo from '../components/user/UserInfo'
import NewProject from '../components/project/NewProject'
import SearchInput from '../components/common/SearchInput'

Vue.use(Router)

export default new Router({
    routes: [
        {
            path: '/',
            name: 'HelloWorld',
            component: HelloWorld
        },
        {
            path: '/auth/login',
            name: 'Login',
            component: Login
        },
        {
            path: '/auth/register',
            name: 'Register',
            component: Register
        },
        {
            path: '/index',
            name: 'Index',
            component: Index
        },
        {
            path: '/userInfo',
            name: 'UserInfo',
            component: UserInfo
        },
        {
            path: '/test',
            name: 'NewPersonnel',
            component: HelloWorld
        }
    ]
})
