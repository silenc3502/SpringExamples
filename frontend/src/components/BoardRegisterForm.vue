<template>
  <div>
    <h3>Board Register Form</h3>
    <button type="submit">Register</button>
    <router-link :to="{ name: 'BoardListPage' }">
      Cancel
    </router-link>
  </div>
</template>

<script>
export default {
  name: 'BoardRegisterForm'
}
</script>
