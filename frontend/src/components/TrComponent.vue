<template>
  <tr>
    <td-component
      v-for="(cellData, index) in rowData"
      :key="index"
      :cell-data="cellData"
      :cell-index="index"
      :row-index="rowIndex"
      :table-data="tableData"
      :turn="turn"
      :winner="winner"
      v-on:updateTurn="updateTurn"
      v-on:updateTableData="updateTableData"
      v-on:updateWinner="updateWinner"
      v-model="propTurn"
    ></td-component>
  </tr>
</template>

<script>
import TdComponent from '../components/TdComponent.vue'
export default {
  components: {
    TdComponent
  },
  data () {
    return {
      parent: '부모',
      propTurn: this.turn,
      propWin: this.winner
    }
  },
  props: {
    rowData: Array,
    rowIndex: Number,
    tableData: Array,
    turn: String,
    winner: String
  },
  updated: function () {
    console.log('tableData: ' + this.tableData +
                ', turn: ' + this.turn +
                ', winner: ' + this.winner)
  },
  methods: {
    updateTurn: function (val) {
      console.log('TrComponent updateTurn: ' + val)
      this.propTurn = val
      this.$emit('updateTurn', this.propTurn)
    },
    updateTableData: function () {
      this.$emit('updateTableData')
    },
    updateWinner: function (val) {
      this.propWin = val
      this.$emit('updateWinner', this.propWin)
    }
  },
  beforeUpdate: function () {
  }
}
</script>

<style></style>
