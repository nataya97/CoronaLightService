<!--<template>
    <div class="v-app-bar">
        <HeaderBar/>
        <Home/>
        <router-view></router-view>
    </div>
</template>

<script>
    import HeaderBar from "./components/HeaderBar";
    import Home from "./components/Home";

    export default {
        name: 'App',

        components: {Home, HeaderBar},

        data: () => ({
            //
        }),
    };
</script>

<style lang="scss">

</style>
-->
<template>
    <div class="v-app-bar">
        <v-toolbar
                class="v-app-bar"
                dense
                flat
                dark
        >
            <v-toolbar-title>Corona Light Service</v-toolbar-title>
            <v-icon>{{ mdiTrafficLight }}</v-icon>
            <v-spacer></v-spacer>
            <v-btn elevation="0" to="/district">Bezirke</v-btn>
            <div class="vl"></div>
            <v-btn elevation="0" to="/state">Bundesländer</v-btn>
        </v-toolbar>
        <router-view></router-view>
    </div>
</template>

<script>
    import {mdiTrafficLight} from '@mdi/js';

    export default {
        name: 'App',

        components: {},

        data: () => ({
            //
            mdiTrafficLight
        }),
    };
</script>

<style lang="scss" scoped>
    .vl {
        border-left: 2px solid whitesmoke;
        height: 20px;
        margin-right: 5px;
        margin-left: 5px;
    }
</style>
