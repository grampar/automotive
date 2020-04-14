<template>
    <div>  
        <v-app-bar :clipped-left="$vuetify.breakpoint.lgAndUp" 
        app color="blue darken-3" dark>
            <v-app-bar-nav-icon @click.stop="getDrawYn" />
            <template>
                <v-tabs align-with-title>
                <!-- <v-tab @click="setMenu('live')">Live</v-tab>
                <v-tab @click="setMenu('map')">Map</v-tab>
                <v-tab @click="setMenu('user')">User</v-tab> -->
                <v-tab><router-link to="/live">Live</router-link></v-tab>
                <v-tab><router-link to="/map">Map</router-link></v-tab>
                <v-tab><router-link to="/user">사용자</router-link></v-tab>
                </v-tabs>
            </template>                    
            <v-spacer />
            <v-btn icon><v-icon>mdi-apps</v-icon></v-btn>
            <v-btn icon><v-icon>mdi-bell</v-icon></v-btn>
            <v-btn icon large>
                <v-avatar size="32px" item>
                <v-img src="https://cdn.vuetifyjs.com/images/logos/logo.svg" alt="Vuetify"/></v-avatar>
            </v-btn>
        </v-app-bar>
    </div>
</template>

<script>
export default {
    name: 'Top',
    methods:{
        getDrawYn(){
            console.log("this", this)
            console.log("this.$store.state.drawer", this.$store.state.drawer)
            if(this.$store.state.drawer)
                this.$store.commit('toggle', false);
            else
                this.$store.commit('toggle', true);
        },
        setMenu(gubun){
            console.log(gubun)
            // if(gubun=="live"){

            // }else if(gubun==="live"){
                
            // }else{

            // }            
        }
    }
}
</script>