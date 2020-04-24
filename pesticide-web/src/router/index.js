import Vue from 'vue'
import Router from 'vue-router'
import Login from '../components/auth/Login'
import HelloWorld from '../components/HelloWorld'
import Register from '../components/auth/Register'
import Index from '../components/index/Index'
import UserInfo from '../components/user/UserInfo'
import DefectOverview from '../components/statistics/DefectOverview'
import DefectDailyTrend from '../components/statistics/DefectDailyTrendChart'

Vue.use(Router)

export default new Router({
    routes: [
        {
            path: '/',
            redirect() {
                return '/index'
            }
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
            component: DefectDailyTrend
        }
    ]
})
