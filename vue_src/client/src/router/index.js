import Vue from 'vue'
import VueRouter from 'vue-router'


Vue.use(VueRouter)

const routes = [
  {
    path: '/live', 
    name:"Live",   
    component: () => import('@/views/live/livemenu.vue'),
    children: [
        {
            path: 'home',            
            component: () => import('@/views/live/Home.vue')
        },
        {
            path: 'about',            
            component: () => import('@/views/live/About.vue')          
        }
    ]
  },
  {
    path: '/map', 
    name:"Map",   
    component: () => import('@/views/map/mapmenu.vue'),
    children: [
        {
            path: 'home',            
            component: () => import('@/views/map/Home.vue')
        },
        {
            path: 'about',            
            component: () => import('@/views/map/About.vue')          
        }
    ]
  },
  {
    path: '/user', 
    name:"User",   
    component: () => import('@/views/user/usermenu.vue'),
    children: [
        {
            path: 'user_list',            
            component: () => import('@/views/user/user_list.vue')
        },
        {
            path: 'group_list',            
            component: () => import('@/views/user/group_list.vue')          
        },
        {
            path: 'user_role',            
            component: () => import('@/views/user/user_role.vue')          
        },
        {
            path: 'user_set',            
            component: () => import('@/views/user/user_set.vue')          
        }
    ]
  }  
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
