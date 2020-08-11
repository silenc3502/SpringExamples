<template>
  <div align="center">
    <h2>Board Modification</h2>
    <board-modify-form/>
  </div>
</template>

<script>
import BoardModifyForm from '@/components/BoardModifyForm'

export default {
  name: 'BoardModifyPage',
  components: {
    BoardModifyForm
  }
}
</script>
