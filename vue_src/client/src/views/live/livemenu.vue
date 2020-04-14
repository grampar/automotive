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
                { icon: 'mdi-contacts', text: 'Home', link:"/live/home" },
                { icon: 'mdi-contacts', text: 'About', link:"/live/about" }
                // { icon: 'mdi-content-copy', text: 'Duplicates' },
                // {
                //     icon: 'mdi-chevron-up',
                //     'icon-alt': 'mdi-chevron-down',
                //     text: 'Labels',
                //     model: true,
                //     children: [
                //         { icon: 'mdi-plus', text: 'Create label' },
                //     ]
                // },
                // {
                //     icon: 'mdi-chevron-up',
                //     'icon-alt': 'mdi-chevron-down',
                //     text: 'More',
                //     model: false,
                //     children: [
                //         {  icon: 'mdi-plus', text: '  Import' },
                //         { icon: 'mdi-plus', text: 'Export' },
                //         {  icon: 'mdi-plus',text: 'Print' },
                //         {  icon: 'mdi-plus',text: 'Undo changes' },
                //         {  icon: 'mdi-plus',text: 'Other contacts' },
                //     ]
                // },
                // { icon: 'mdi-settings', text: 'Settings' },
                // { icon: 'mdi-message', text: 'Send feedback' },
                // { icon: 'mdi-help-circle', text: 'Help' },
                // { icon: 'mdi-cellphone-link', text: 'App downloads' },
                // { icon: 'mdi-keyboard', text: 'Go to the old version' },
            ]
        }
      
    },
    
}
</script>