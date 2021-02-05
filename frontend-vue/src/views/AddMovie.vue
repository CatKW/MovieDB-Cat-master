<template>
    <div>
        <h1 class="title"> Add Movie </h1>

    <div class="field">
        <label class="label" for="movieTitle">Movie Title</label>
        <div class="controller">
            <input id="movieTitle" class="input" type="text" v-model="movie.movieTitle" placeholder="Movie Title" />
        </div>
    </div>

    <div class="field">
        <label class="label" for="movieLength">Movie Length</label>
        <div class="controller">
            <input id="movieLength" class="input" type="number" v-model="movie.movieLength" placeholder="Movie Length" />
        </div>
    </div>

    <div class="field">
        <label class="label" for="releaseDate">Release Date</label>
        <div class="controller">
            <input id="releaseDate" class="input" type="date" v-model="movie.releaseDate"/>
        </div>
    </div>

    <div class="field">
        <label class="label">Director</label>
        <div class="select">
            <select v-model="movie.director.id">
                <option v-for="director in directors" :value="director.id" :key="director.id">
                    {{director.firstName}} {{director.lastName}}
                </option>
            </select>
        </div>
    </div>
    <div class="field">
        <label class="label">Genre</label>
        <div class="select">
            <select v-model="movie.genre.id">
                <option v-for="genre in genres" :value="genre.id" :key="genre.id">
                    {{genre.genre}}
                </option>
            </select>
        </div>
    </div>
     <div class="field">
        <label class="label">Rating</label>
        <span class="control" v-for="rating in ratings" :key="rating.id">
            <label :for="'rating-' + rating.id" class="radio">
                <input type="radio" :id="'rating-' + rating.id" :value="rating.id" v-model="movie.rating.id" class="radio"/>
                {{rating.rating}}
            </label>
        </span>
    </div>
    <div class="field">
        <label class="label">Actors</label>
        <div class="control" v-for="actor in actors" :key="actor.id">
            <label :for="'actor-' + actor.id" class="checkbox">
                <input type="checkbox" :id="'actor-' + actor.id" :value="actor" v-model="movie.actors" class="checkbox"/>
                {{actor.firstName}}{{actor.lastName}}
            </label>
        </div>
    </div>
     <div class="field is-grouped">
        <div class="control">
            <button @click="cancel" class="button">Cancel</button>
        </div>
        <div class="control">
            <button @click="cancel" class="button is-primary">Save</button>
        </div>
    </div>
   
</div>
    
</template>
<script>

export default {
    data: () => ({
        movie: {
            movieTitle: null,
            movieLength: null,
            releaseDate: null,
            trailerUrl: null,
            director: {},
            genre: {},
            rating:{},
            actors: []
        },
        directors: [],
        genres: [],
        ratings: [],
        actors: []
    }),
    methods: {
        async save() {
            console.log('AddMovie.save() movie=', this.movie)
            const response = await this.$http.post('http://localhost:8080/api/movies/', this.movie)
            console.log('AddMovie.save() response=', response);
        },
        cancel () {
            this.$router.push({path: '/movies'});
        },
        async getDirectors() {
            const {data} = await this.$http.get('http://localhost:8080/api/directors');
            console.log('getDirectors() data', data)
            return data;
        },
        async getGenres() {
            const {data} = await this.$http.get('http://localhost:8080/api/genres');
            console.log('getGenres() data', data)
            return data;
        },
        async getRatings() {
            const {data} = await this.$http.get('http://localhost:8080/api/ratings');
            console.log('getRatings() data', data)
            return data;
        },
        async getActors() {
            const {data} = await this.$http.get('http://localhost:8080/api/actors');
            console.log('getActors() data', data)
            return data;
        }
    },
    async mounted() {
        this.directors = await this.getDirectors();
        this.genres = await this.getGenres();
        this.ratings = await this.getRatings();
        this.actors = await this.getActors();
    }
}
</script>

<style scoped>
label.radio {
    margin-right: 1rem;
}
</style>