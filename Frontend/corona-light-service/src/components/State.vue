<template>
    <v-data-table
            :headers="headers"
            :items="items"
            :items-per-page="15"
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
</template>

<script>
    import StateCasesService from "../services/StateCasesService";

    export default {
        name: "State",

        data() {
            return {
                headers: [
                    {text: 'Bundesland', value: 'state'},
                    {text: '#Intensiv', value: 'icu'},
                    {text: '#Krankenhaus', value: 'hospital'},
                    {text: 'Ampelfarbe', value: 'lightStatus'}
                ],
                items: [],
            }
        },

        methods: {
            getAllStates() {
                StateCasesService.getAllCases()
                    .then(response => {
                        for(var i = 0; i < response.data.length; i++) {
                            this.items = response.data
                            this.items[i].state = response.data[i].state.state
                            this.items[i].icu = response.data[i].fzICU
                            this.items[i].hospital = response.data[i].fzHosp
                            this.items[i].lightStatus = response.data[i].fzICU + response.data[i].fzHosp
                        }
                    })
                    .catch(e => {
                        console.log(e);
                });
            },

            getColor(val) {
               if (val > 200) return "#EF0404"
               else if (val >100) return "#FF8300"
               else return "#1B8B14"
            },
        },

        mounted() {
            this.getAllStates();
        }
    }

</script>

<style lang="scss" scoped>

</style>
