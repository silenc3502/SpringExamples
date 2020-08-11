<template>
  <div id="board">
    <h2>Board List</h2>
    <router-link :to="{ name: 'BoardRegisterPage' }">
      Create New Board
    </router-link>
    <board-list/>
  </div>
</template>

<script>
import BoardList from '@/components/BoardList'

export default {
  name: 'BoardListPage',
  components: {
    BoardList
  }
}

</script>
