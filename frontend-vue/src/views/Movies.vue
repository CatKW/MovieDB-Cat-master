<template>
    <div class="main">
        <div class="header">
            <h1 class="title">Movies</h1>
        </div>

        <router-link to="movies/add" tag="button" class="button is-primary"> Add Movie </router-link>

        <div class="content">
            <table>
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Movie Title</th>
                            <th>Movie Length</th>
                            <th>Release Date</th>
                        </tr>
                    </thead>

                    <tbody>
                        <tr v-for="movie in movies" :key="movie.id">
                            <td>{{movie.id}}</td>
                            <td><a @click="movieDetail(movie.id)">{{movie.movieTitle}}</a></td>
                            <td>{{movie.movieLength}}</td>
                            <td>{{movie.releaseDate}}</td>
                        </tr>
                    </tbody>


            </table>

        </div>

    </div>

</template>

<script>
export default {
    data: () => ({
        movies: []
    }),
    methods: {
        movieDetail(movieId) {
            this.$router.push('movie/' + movieId);
        }
    },
    async mounted(){
        const { data } = await this.$http.get('http://localhost:8080/api/movies');
        this.movies = data;
    }
    
}
</script>