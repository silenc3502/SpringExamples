<template>
  <Layout>
    <template #menubar>
      <v-btn @click="start('society')" text color="black"
        style="padding: 10px; width: 90px;">사회</v-btn>
      <v-btn @click="start('politics')" text color="black"
        style="padding: 10px; width: 90px;">정치</v-btn>
      <v-btn @click="start('economic')" text color="black"
        style="padding: 10px; width: 90px;">경제</v-btn>
      <v-btn @click="start('foreign')" text color="black"
        style="padding: 10px; width: 90px;">국제</v-btn>
      <v-btn @click="start('culture')" text color="black"
        style="padding: 10px; width: 90px;">문화</v-btn>
      <v-btn @click="start('digital')" text color="black"
        style="padding: 10px; width: 90px;">IT</v-btn>
    </template>
    <template #content>
      <v-simple-table>
        <template v-slot:default>
          <thead>
            <tr>
              <th class="text-left">No.</th>
              <th class="text-left">제목</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="list of lists" :key="list.title">
              <td style="color: gray">{{ list.newNo }}</td>
              <td><a @click="clickNews(i.newsNo)">{{ list.title }}</a></td>
            </tr>
          </tbody>
        </template>
      </v-simple-table>
    </template>
  </Layout>
</template>

<script>
import Layout from '../components/Layout'
import { mapState } from 'vuex'

export default {
  components: { Layout },
  computed: {
    ...mapState({
      list: state => state.list
    })
  },
  methods: {
    clickNews (newsNo) {
      console.log('clickNews: ' + newsNo)
      this.$store.dispatch('crawlFindOne', newsNo)
    },
    start (category) {
      this.$store.dispatch('crawlFind', category)
    }
  }
}
</script>
