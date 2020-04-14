<template>
  <div>
    <v-card>
     
      <v-container>
        <v-row>
          <v-col cols="12" md="4">
              <v-card-title>
                <span class="headline">사용자 리스트</span>
              </v-card-title>
            </v-col>

            <!-- 검색 조건 -->          
            <v-col cols="12" md="2">
              <v-select :items="items" ></v-select>                    
            </v-col> 
            <!-- 검색 text -->
            <v-col cols="12" md="4">            
              <v-text-field @click="getSearch"  label="Regular" append-icon="mdi-magnify" single-line hide-details></v-text-field>                                        
            </v-col>
            <!-- 등록 버튼 -->
            <v-col cols="12" md="2">              
              <v-btn color="primary" dark @click.stop="dialog = true">Open Dialog</v-btn>        
            </v-col>
              
        </v-row>
      </v-container>

      <v-data-table :headers="headers" :items="desserts" :items-per-page="5"
      class="elevation-1"></v-data-table>      
    </v-card>

    
    <!-- 등록 dialog-->
    <v-dialog v-model="dialog" persistent max-width="800px">        
      <v-card>
        <v-card-title>
          <span class="headline">User Profile</span>
        </v-card-title>
        <v-card-text>
          <v-form v-model="valid">
          <v-container>              
            <v-row>
              <v-col cols="12" sm="6">
                <v-text-field label="아이디*" v-model="inputdata.user_id" :rules="[rules.required]"></v-text-field>
              </v-col>              
              <v-col cols="12" sm="6">
                <v-text-field label="이름*" v-model="inputdata.user_nm" :rules="[rules.required]"></v-text-field>
              </v-col>
              <v-col cols="12" sm="6">
                <v-text-field label="이메일" v-model="inputdata.user_email" :rules="[rules.required,rules.email]"></v-text-field>
              </v-col>              
              <v-col cols="12" sm="6">
                <v-text-field label="모바일" v-model="inputdata.user_mobile"></v-text-field>
              </v-col>
              <v-col cols="12">
                <v-text-field v-model="inputdata.user_pwd"
                          :append-icon="show1 ? 'mdi-eye' : 'mdi-eye-off'"
                          :rules="[rules.required]"
                          :type="show1 ? 'text' : 'password'"
                          name="input-10-1"
                          label="비밀번호"
                          hint="At least 8 characters"
                          counter
                          @click:append="show1 = !show1"
                ></v-text-field>
              </v-col>
              <v-col cols="12">
                <v-text-field v-model="inputdata.user_repwd"
                          :append-icon="show2 ? 'mdi-eye' : 'mdi-eye-off'"
                          :rules="[rules.required]"
                          :type="show2 ? 'text' : 'password'"
                          name="input-10-1"
                          label="비밀번호확인"
                          hint="At least 8 characters"
                          counter
                          @click:append="show2 = !show2"
                ></v-text-field>
                
              </v-col>
             
            </v-row>
          </v-container>
          </v-form>
          <small>*indicates required field</small>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="blue darken-1" text @click="dialog = false">Close</v-btn>
          <v-btn color="blue darken-1" text @click="saveUser">Save</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>

    
  </div>

  
</template>

<script>
import Socket from "@/util/websocket"


export default {
  
  data () {
    return {
      socket:null,
      headers: [
        { text: 'user_id', value: 'user_id' },
        { text: 'site_id', value: 'site_id' },
        { text: 'user_nm', value: 'user_nm' },
        { text: 'user_email', value: 'user_email' },
        { text: 'user_mobile', value: 'user_mobile' },
        { text: 'user_pwd', value: 'user_pwd' },        
        { text: 'pwd_chg_date', value: 'pwd_chg_date' },        
        { text: 'user_photo', value: 'user_photo' },        
        { text: 'online_yn', value: 'online_yn' },        
        { text: 'user_desc', value: 'user_desc' }, 
        { text: 'login_fail_cnt', value: 'login_fail_cnt' },                  
      ],
      desserts: [],
      items: ['foo', 'bar', 'fizz', 'buzz'],
      value: ['foo', 'bar', 'fizz', 'buzz'],
      dialog:false,
      inputdata:{        
        "user_id":"",
        "user_nm":"",
        "user_email":"",
        "user_mobile":"",
        "user_pwd":"",
        "user_repwd":"",
        "online_yn":"",
        "user_desc":"",           
      },
      valid: false,
      show1: false,
      show2: false,
      password: 'Password',
      rules: {
        required: value => !!value || 'Required.',                
        email: value => {
            const pattern = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
            return pattern.test(value) || 'Invalid e-mail.'
        },
      },
    }
  },
  // computed:{
  //   dataWatch:function(){
  //     return this.desserts;
  //   }    
  // },
  created(){
    //Socket.connect("/topic/greetings", this)    
    Socket.connect("/topic/greetings", this) 
    
    
    
  },

  methods:{
    setData(data){
      this.desserts=data
    },
    getSearch(){
      var obj={
          "method":"user.getUserList",          
          "search_param":{
              "search_value":""
          }
      }           
      console.log("Socket.desserts:",Socket.desserts)
      Socket.send("/app/datarequest", JSON.stringify(obj));
    },
    saveUser(){
      // if(this.inputdata.user_id.trim()===""){
      //   alert("사용자 아이디를 입력해주세요.")
      //   return;
      // }

      // if(this.inputdata.user_nm.trim()===""){
      //   alert("사용자 이름을 입력해주세요.")
      //   return;
      // }

      // if(this.inputdata.user_email.trim()===""){
      //   alert("이메일을 입력해주세요.")
      //   return;
      // }

      console.log(this.$refs.form.validate())
      // var obj={
      //     "method":"user.updateUser",
      //     "user_id":this.inputdata.user_id,
      //     "user_nm":this.inputdata.user_nm,
      //     "user_email":this.inputdata.user_email,
      //     "user_mobile":this.inputdata.user_mobile,
      //     "user_pwd":this.inputdata.user_pwd,
      //     "online_yn":"1",
      //     "user_desc":this.inputdata.user_desc
      // }           
      // Socket.send("/app/datarequest", JSON.stringify(obj));
      // this.dialog=false
      // this.getSearch()
    }
  }
}
</script>
