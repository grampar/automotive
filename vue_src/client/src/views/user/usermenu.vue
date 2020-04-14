<template>
    <div>      
        <Menu v-bind:menuitem="items"></Menu>       
        <router-view></router-view>
            
        
        
    </div>
</template>

<script>
import Menu from "@/views/layout/menu.vue"
export default {
    components:{
        Menu
    },   
    data() {
        return {            
            items: [
                { icon: 'mdi-contacts', text: '사용자', link:"/user/user_list" },
                { icon: 'mdi-contacts', text: '사용자그룹', link:"/user/group_list" },
                { icon: 'mdi-contacts', text: 'role', link:"/user/user_role" },                
                { icon: 'mdi-contacts', text: 'role 및  resource할당', link:"/user/user_set" },                
            ]
        }
      
    }   
}
</script>