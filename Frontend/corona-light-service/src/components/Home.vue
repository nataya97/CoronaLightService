<template>
   <div></div>
</template>

<script>
    import { mapMutations } from 'vuex';

    export default {
        name: "Home",

        data() {
            return {
                account: undefined,
            }
        },

        async created() {
            this.$emitter.on(
                'login',
                async function (account) {
                    this.account = account;
                    console.log('get this account', this.account)

                }.bind(this)
            )
            this.$emitter.on('logout', () => {
                console.log('logging out');
                this.account = undefined;
            });
        },

        methods: {
            ...mapMutations(['setAccessToken']),

        },

    }
</script>

<style scoped>

</style>
