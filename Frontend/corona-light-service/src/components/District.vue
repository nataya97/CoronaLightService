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
                {{ item.lightStatus }}
            </v-chip>
        </template>
    </v-data-table>
</template>

<script>
    import DistrictCasesService from "../services/DistrictCasesService";
    import DistrictService from "../services/DistrictService";
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
                        /*this.items[i].gkz = console.log("undef ",  this.getGkz(response.data[i].district));*/
                        this.items[i].lightStatus = response.data[i].numberOfCasesLastSevenDays;
                    }
                    this.getGkz("Eisenstadt(Stadt)")
                    console.log("the responseeee...", response.data[0])

                }).catch(error => console.log(error.response));
            },

            getColor(val) {
                  if (val > 200) return "#EF0404"
                  else if (val >100) return "#FF8300"
                  else return "#1B8B14"

            },

            getGkz(name) {
                DistrictService.getByName(name).then(response => {
                    console.log(response.data)
                })
            }
        },

        mounted() {
            this.getDistricts();
        }
    }

</script>

<style lang="scss" scoped>

</style>
