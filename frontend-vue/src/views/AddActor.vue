<template>
    <div>
        <h1 class="title">Add Actor</h1>
      
        
        <div class="field">
            <label class="label">First Name</label>
            <div class="control">
                <input class="input" type="text" v-model="actor.firstName" placeholder="First Name"/>
            </div>
        </div>

        <div class="field">
            <label class="label">Last Name</label>
            <div class="control">
                <input class="input" type="text" v-model="actor.lastName" placeholder="First Name"/>
            </div>
        </div>

            <div class="field">
            <label class="label">Date of Birth</label>
            <div class="control">
                <input class="input" type="text" v-model="actor.dateOfBirth" placeholder="First Name"/>
            </div>
        </div>

        <div class="field is-grouped">
            <p class="control">
                <button v-on:click="cancel" class="button">Cancel</button>
            </p>

            <p class="control">
                <button v-on:click="save" class="button is-primary">Save</button>
            </p>
        </div>
        
    </div>
</template>

<script>
export default {
    name: 'AddActor',
    data: () => ({
        actor: {
            firstName: "",
            lastName: "",
            dateOfBirth: ""
        }
    }),
    methods:{
        cancel(){
            this.$router.push({path: '/actors'});
        },
        async save(){
            const response = await this.$http.post('http://localhost:8080/api/actors/',
            this.actor)
            console.log(response);
            if( response.status === 200){
                this.$router.push({path: '/actors'});
            }
        }
    }
}
</script>