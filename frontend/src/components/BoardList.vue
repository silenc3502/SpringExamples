<template>
  <div>
    <h3>Board List View</h3>
    <router-link :to="{ name: 'BoardReadPage', params: { boardNo: 1 } }">
      Detailed Board View
    </router-link>
  </div>
</template>

<script>
export default {
  name: 'BoardList'
}
</script>
