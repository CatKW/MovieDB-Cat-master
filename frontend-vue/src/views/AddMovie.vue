<template>
    <div>
        <h1 class="title"> Add Actor </h1>

    <div class="field">
        <label class="label" for="movieTitle">Movie Title</label>
        <div class="controller">
            <input id="movieTitle" class="input" type="text" v-model="movie.movieTitle" placeholder="Movie Title" />
        </div>
    </div>


    </div>
</template>
<script>
export default {
    data: () => ({
        movie: {
            movieTitle: "",
            movieLength: null,
            releaseDate: null,
            trailerUrl: null,
            director: {},
            genre: {},
            actors: []
        },
        directors: [],
        genres: [],
        rating: [],
        actors: []
    }) 
}
</script>