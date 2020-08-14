<template>
  <form @submit.prevent="submit">
    <table>
      <tr>
        <td>Admin Id</td>
        <td><input type="text" v-model="userId"></td>
      </tr>
      <tr>
        <td>Password</td>
        <td><input type="password" v-model="userPw"></td>
      </tr>
      <tr>
        <td>Admin Name</td>
        <td><input type="text" v-model="userName"></td>
      </tr>
    </table>

    <div>
      <button type="submit">Register</button>
    </div>
  </form>
</template>

<script>
export default {
  name: 'AdminSetupForm',
  data () {
    return {
      userId: '',
      userName: '',
      userPw: ''
    }
  },
  methods: {
    submit () {
      console.log('this: ' + this.userId +
                  ', ' + this.userName +
                  ', ' + this.userPw)
      const { userId, userName, userPw } = this
      this.$emit('submit', { userId, userName, userPw })
    }
  }
}
</script>
