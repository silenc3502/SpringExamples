<template>
  <div align="center">
    <h2>Detailed Board List</h2>
    <board-read/>
    <router-link :to="{ name: 'BoardModifyPage', params: { boardNo: 1 } }">
      Edit
    </router-link>
    <button>Delete</button>
    <router-link :to="{ name: 'BoardListPage' }">
      List
    </router-link>
  </div>
</template>

<script>
import BoardRead from '@/components/BoardRead'

export default {
  name: 'BoardReadPage',
  components: {
    BoardRead
  }
}
</script>
