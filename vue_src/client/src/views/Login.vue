<template>
  <v-app id="inspire">
    <v-content>
      <v-container class="fill-height" fluid>
        <v-row align="center" justify="center">
          <v-col cols="12" sm="8" md="4">
            <v-card class="elevation-12">
              <v-toolbar color="primary" dark flat>
                <v-toolbar-title>Login form</v-toolbar-title>
                <v-spacer />
                <!-- <v-tooltip bottom>
                  <template v-slot:activator="{ on }">
                    <v-btn :href="source" icon large target="_blank" v-on="on">
                      <v-icon>mdi-code-tags</v-icon>
                    </v-btn>
                  </template>
                  <span>Source</span>
                </v-tooltip>
                <v-tooltip right>
                  <template v-slot:activator="{ on }">
                    <v-btn icon large href="https://codepen.io/johnjleider/pen/pMvGQO"
                      target="_blank" v-on="on">
                      <v-icon>mdi-codepen</v-icon>
                    </v-btn>
                  </template>
                  <span>Codepen</span>
                </v-tooltip> -->
              </v-toolbar>
              <v-card-text>
                <v-form>
                  <v-text-field label="Login" name="login"  type="text" v-model="loginid" />
                  <v-text-field id="password" label="Password" name="password" v-model="loginpwd"  type="password" />
                </v-form>
              </v-card-text>
              <v-card-actions>
                <v-spacer />
                <v-btn color="primary" @click="loginOk">Login</v-btn>
              </v-card-actions>
            </v-card>
          </v-col>
        </v-row>
      </v-container>
    </v-content>

    <v-alert type="error" :value="alert"></v-alert>
  </v-app>
</template>

<script>
  import EventBus from "@/util/event_bus"
  //import LoginApi from "@/util/restapi/login"


  export default {
    data(){
      return {
        loginid:"",
        loginpwd:"",
        alert:false
      }
    },
    methods:{
      loginOk:function(){
        if(!this.loginid.trim()){
          //alert("아이디를 입력해 해주세요");
          
          this.alert=true

          return;
        }

        if(!this.loginpwd.trim()){
          alert("비밀번호를 입력해주세요");
          return;
        }

        // var reqData={
        //     "login_id":this.loginid,
        //     "login_pwd":this.loginpwd            
        // }           


        //성공여부 전달
        EventBus.$emit('login_ok', true);

        // // 서버에 로그인 정보를 던진다.
        // LoginApi.login(reqData)
        // .then(result => {
        //     console.log("result:", result);

        //   //성공여부 전달
        //   EventBus.$emit('login_ok', true);
          
        // })
        // .catch(error=>{
        //   console.log(error)         
        // })
        
        
      }
    }
  }
</script>