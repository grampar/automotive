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
                { icon: 'mdi-contacts', text: 'Home', link:"/map/home" },
                { icon: 'mdi-contacts', text: 'About', link:"/map/about" },                
            ]
        }
      
    },
    // methods:{
    //     getDraw(){
    //         return this.$store.getters.drawer;
    //     }
    // }
}
</script>