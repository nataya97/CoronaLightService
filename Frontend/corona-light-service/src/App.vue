<template>
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
