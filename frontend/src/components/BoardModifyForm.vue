<template>
  <div>
    <h3>Board Modified Form</h3>
    <button type="submit">Modification</button>
    <router-link :to="{ name: 'BoardReadPage', params: { boardNo: 1 } }">
      Cancel
    </router-link>
  </div>
</template>

<script>
export default {
  name: 'BoardModifyForm'
}
</script>
