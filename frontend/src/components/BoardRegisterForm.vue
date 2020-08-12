<template>
  <form @submit.prevent="onSubmit">
    <h3>Board Register Form</h3>
    <table>
      <tr>
        <td>Title</td>
        <td><input type="text" v-model="title"></td>
      </tr>
      <tr>
        <td>Writer</td>
        <td><input type="text" v-model="writer"></td>
      </tr>
      <tr>
        <td>Content</td>
        <td><textarea v-model="content" rows="5"></textarea></td>
      </tr>
    </table>

    <div>
      <button type="submit">Register</button>
      <router-link :to="{ name: 'BoardListPage' }">
        Cancel
      </router-link>
    </div>
  </form>
</template>

<script>
export default {
  name: 'BoardRegisterForm',
  data () {
    return {
      title: '',
      writer: '',
      content: ''
    }
  },
  methods: {
    onSubmit () {
      const { title, writer, content } = this
      this.$emit('submit', { title, writer, content })
    }
  }
}
</script>
