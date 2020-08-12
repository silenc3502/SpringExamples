<template>
  <div>
    <h3>Board Detailed View</h3>
    <table>
      <tr>
        <td>No</td>
        <td><input type="text" :value="board.boardNo" readonly></td>
      </tr>
      <tr>
        <td>Registration Date</td>
        <td><input type="text" :value="board.regDate" readonly></td>
      </tr>
      <tr>
        <td>Title</td>
        <td><input type="text" :value="board.title" readonly></td>
      </tr>
      <tr>
        <td>Writer</td>
        <td><input type="text" :value="board.writer" readonly></td>
      </tr>
      <tr>
        <td>Content</td>
        <td><textarea :value="board.content" rows="5" readonly></textarea></td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: 'BoardRead',
  props: {
    board: {
      type: Object,
      required: true
    }
  }
}
</script>
