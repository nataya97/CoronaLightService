<template>
    <div>
        <v-text-field
                v-model="search"
                append-icon="mdi-magnify"
                label="Search"
                single-line
                hide-details
        ></v-text-field>
        <v-data-table
                :headers="headers"
                :items="items"
                :search="search"
                :items-per-page="10"
        >
            <template v-slot:item.lightStatus="{ item }">
                <v-chip
                        :color="getColor(item.lightStatus)"
                        dark
                >
                    {{ item.lightStatus }}
                </v-chip>
            </template>
        </v-data-table>
    </div>

</template>

<script>
    import StateCasesService from "../services/StateCasesService";
    import authentication from '../wrapper'
    export default {
        name: "State",
        computed: {
            isAuthenticated() {
                return authentication.isAuthenticated();
            }
        },
        data() {
            return {
                search: '',
                headers: [
                    {text: 'Bundesland', value: 'state'},
                    {text: 'Intensiv', value: 'icu'},
                    {text: 'Krankenhaus', value: 'hospital'},
                    {text: 'Ampelfarbe', value: 'lightStatus'}
                ],
                items: [],
            }
        },

        methods: {
            getAllStates() {
                StateCasesService.getAllCases()
                    .then(response => {
                        for (var i = 0; i < response.data.length; i++) {
                            this.items = response.data
                            this.items[i].state = response.data[i].state.state
                            this.items[i].icu = response.data[i].fzICU
                            this.items[i].hospital = response.data[i].fzHosp
                            this.items[i].lightStatus = response.data[i].icu + response.data[i].fzHosp
                        }
                    })
                    .catch(e => {
                        console.log(e);
                    });
            },

            getColor(val) {
                if (val > 200) return "#EF0404"
                else if (val > 150) return "#ff8300"
                else if (val > 100) return "#ffdd00"
                else return "#1B8B14"
            },
            logOut() {
                authentication.signOut();
            }
        },

        mounted() {
            this.getAllStates();
        }
    }

</script>

<style lang="scss" scoped>

</style>
