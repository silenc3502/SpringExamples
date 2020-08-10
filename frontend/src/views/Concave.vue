<template>
  <div class="tictactoe">
    <div>{{ turn }}님의 턴입니다.</div>
    <table-component :table-data="tableData"
        :turn="turn"
        :winner="winner"
        v-on:updateTurn="updateTurn"
        v-on:updateTableData="updateTableData"
        v-on:updateWinner="updateWinner">
    </table-component>
    <div v-if="winner">{{ winner }}님의 승리!</div>
  </div>
</template>

<script>
import TableComponent from '../components/TableComponent.vue'

export default {
  components: {
    TableComponent
  },
  data () {
    return {
      turn: 'O',
      winner: '',
      tableData: [
        ['', '', ''],
        ['', '', ''],
        ['', '', '']
      ]
    }
  },
  updated: function () {
    console.log('tableData: ' + this.tableData +
                ', turn: ' + this.turn +
                ', winner: ' + this.winner)
  },
  methods: {
    updateTurn: function (val) {
      console.log('Concave updateTurn: ' + val)
      this.turn = val
    },
    updateTableData: function () {
      this.tableData = [
        ['', '', ''],
        ['', '', ''],
        ['', '', '']
      ]
    },
    updateWinner: function (val) {
      this.winner = val
    }
  }
}

</script>
