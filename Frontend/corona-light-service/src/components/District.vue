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
                :items-per-page="30"
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
    import DistrictCasesService from "../services/DistrictCasesService";

    export default {
        name: "District",

        data() {
            return {
                search: '',
                headers: [
                    {text: 'Bezirk', value: 'district'},
                    {text: 'Einwohner', value: 'numberOfResidents'},
                    {text: 'Tode', value: 'numberOfDeaths'},
                    {text: 'Fälle', value: 'amount'},
                    {text: 'Fälle 7 Tage', value: 'numberOfCasesLastSevenDays'},
                    {text: 'Ampelfarbe', value: 'lightStatus'}
                ],
                items: [],
            }
        },

        methods: {
            getDistricts() {
                DistrictCasesService.getAllCases().then(response => {
                    for (var i = 0; i < response.data.length; i++) {
                        this.items = response.data;
                        this.items[i].district = response.data[i].district.district;
                        this.items[i].lightStatus = response.data[i].numberOfCasesLastSevenDays;
                    }
                }).catch(error => console.log(error.response));
            },

            getColor(val) {
                if (val > 200) return "#EF0404"
                else if (val > 150) return "#FF8300"
                else if (val > 100) return "#ffdd00"
                else return "#1B8B14"
            },
        },

        mounted() {
            this.getDistricts();
        }
    }

</script>

<style lang="scss" scoped>
    .v-data-table > tr {
        margin-left: 50px !important;
        display: block;
    }
</style>
