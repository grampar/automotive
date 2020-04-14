<template>
  <v-app id="inspire">  
    <Top v-if="loginyn"></Top>
    <!-- <Menu></Menu> -->
    <!-- <Content></Content>     -->

    <!-- <v-content v-show="loginyn">
        <v-container class="fill-height" fluid>
            <router-view></router-view>
        </v-container>
    </v-content> -->
    <v-content v-if="loginyn">
        <v-container  fluid>
            <router-view></router-view>
        </v-container>
    </v-content>

    <!-- <Login v-show="!loginyn" v-on:login_ok="setLogin" ></Login> -->
    <Login v-if="!loginyn"></Login>    
  </v-app>
  
</template>

<script>
import Top from './views/layout/top.vue'
import Login from './views/Login.vue'
import EventBus from './util/event_bus'

export default {
  components:{
    Top,
    Login
    //Menu,
    //Content
  },
  data(){
    return {
      loginyn:true
    }
  },
  created(){
    //서버에서 login    
    console.log(EventBus)
    EventBus.$on('login_ok', this.setLogin)
    //this.$on('login_ok', this.setLogin)
    //this.loginyn=true
  },
  methods:{
    setLogin:function(loginyn){
      this.loginyn=loginyn
      console.log(this.loginyn)
    }
  }
}
</script>