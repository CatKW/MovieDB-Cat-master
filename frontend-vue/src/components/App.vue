<template>
  <div id="app">
      <Header :title="'movieDB Application'"/>
    <div id="nav">
      <router-link to="./">Home</router-link> |
      <router-link to="./actors">Actors</router-link> |
      <router-link to="./movies">Movies</router-link> |
    </div>

      <div class="container">
         <router-view/>
        </div>

        <Search :search="state.search" @search="handleSearch"/>
        <p class="welcome">Sharing a few of our favorite movies</p>
        <div class="movies">
          <Movie v-for="movie in state.movies" :movie="movie" :key="movie.imdbID"/>

        </div>
  </div>
</template>

<script>
import Header from './Header.vue';
import Search from './Search';
import Movie from './AMovie.vue';

import {useMovieApi} from '../hooks/movie-api';

export default {
    name: 'app',
    components: {Header, Search, Movie},
    setup() {
      const state = useMovieApi();

      return {
        state,
        handleSearch(searchTerm) {
          state.loading = true;
          state.search = searchTerm;
        }
      }

    }
}
</script>

<style scoped>
#app {
  text-align: center;
}
.header {
  background-color: #282c34;
  height: 70px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  color: white;
  font-size: 18pt;
  padding: 20px;
  cursor: pointer;
}
.header h2 {
  margin: 0;
}
.spinner {
  height: 80;
  margin: auto;
}
.welcome {
  font-size: larger;
}

/* new css for movie component*/
* {
  box-sizing: border-box;
}
.movies {
  display: flex;
  flex-wrap: wrap;
}

</style>