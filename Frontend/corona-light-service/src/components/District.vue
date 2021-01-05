<template>
    <v-data-table
            :headers="headers"
            :items="items"
            :items-per-page="30"
    >
        <template v-slot:item.lightStatus="{ item }">
            <v-chip
                :color="getColor(item.lightStatus)"
                dark

            >
                <strong>{{ item.lightStatus }}</strong>&nbsp;
            </v-chip>
        </template>
    </v-data-table>
</template>

<script>
    import DistrictCasesService from "../services/DistrictCasesService";
    export default {
        name: "District",

        data() {
            return {
                headers: [
                    {text: 'Bezirk', value: 'district'},
                    {text: 'GKZ', value: 'gkz'},
                    {text: 'Einwohner', value: 'numberOfResidents'},
                    {text: '#Tode', value: 'numberOfDeaths'},
                    {text: '#Fälle', value: 'amount'},
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
                        this.items[i].gkz = response.data[i].id;
                        this.items[i].lightStatus = response.data[i].numberOfCasesLastSevenDays;
                    }
                    console.log("the response...", response.data[1], this.items)
                }).catch(error => console.log(error.response));
            },

            getColor(val) {
                  console.log("value: ", val)
                  if (val > 200) return "#EF0404"
                  else if (val >100) return "#FF8300"
                  else return "#1B8B14"

            },
        },

        mounted() {
            this.getDistricts();
        }
    }

</script>

<style lang="scss" scoped>

</style>
