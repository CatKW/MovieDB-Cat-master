<template>
  <div class="main">
      <div clas="header">
    <h1 class="title"> Actors</h1>
  </div>

  <router-link to="/actor" tag="button" class="button is-primary">Add Actor</router-link>

    <div class="content">
        <table id="actors" class="table">
          <thead>
              <tr>
                  <th>#</th>
                  <th>Name</th>
                  <th>Date of Birth</th>
                </tr>
            </thead>

            <tbody>
                <tr v-for="actor in actors" :key="actor.id">
                <td>{{actor.id}}</td>
                <td>{{actor.firstName}} {{actor.lastName}}</td>
                <td>{{ moment(actor.dateOfBirth).format("MM/DD/YYYY") }}</td>
              </tr>
            </tbody>
        </table>
      </div>
  </div>
</template>

<script>
export default {
  name: 'Actors',
  data: () => ({
    actors: []
  }),
  async mounted(){
    console.log('actors mounted being')
    const{ data } = await this.$http.get('http://localhost:8080/api/actors');
    console.log('actors mounted data', data)
    this.actors = data;
  }
}
</script>

<style scoped>
button{
  float: right;
}
</style>