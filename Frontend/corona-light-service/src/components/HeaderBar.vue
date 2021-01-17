<template>
    <v-toolbar
            class="v-app-bar"
            dense
            flat
            dark
    >
        <v-toolbar-title>Corona Light Service</v-toolbar-title>
        <v-icon>{{ mdiTrafficLight }}</v-icon>
        <v-spacer></v-spacer>

        <!-- hide this if a user is logged in -->

        <v-btn elevation="0"
               v-if="!account"
               @click="signIn"
        >Login
        </v-btn>

        <!-- show this if a user is logged in -->
        <v-btn elevation="0"
               v-else
               @click="signOut"
        >Logout
        </v-btn>

        <div v-if="account">{{account.name}}</div>

        <v-btn elevation="0" to="/district">Bezirke</v-btn>
        <div class="vl"></div>
        <v-btn elevation="0" to="/state">Bundesländer</v-btn>

    </v-toolbar>
</template>

<script>
    import {mdiTrafficLight} from '@mdi/js';
    import {PublicClientApplication} from '@azure/msal-browser'

    export default {
        name: "HeaderBar",

        data() {
            return {
                mdiTrafficLight,
                account: undefined,
                signInTo: 'https://microsoft.com',
            }
        },
        async created() {
            this.$msalInstance = new PublicClientApplication(
                this.$store.state.msalConfig,
            );
        },
        mounted() {
            const accounts = this.$msalInstance.getAllAccounts();
            if(accounts.length === 0) {
                return;
            }
            this.account = accounts[0];
            this.$emitter.emit('login', this.account);
        },
        methods: {
            async signIn() {
                console.log('logging')
                await this.$msalInstance
                .loginPopup({})
                .then(() => {
                    const myAccounts = this.$msalInstance.getAllAccounts();
                    this.account = myAccounts[0];
                    this.$emitter.emit('login', this.account);
                })
                .catch(error => {
                    console.error(`error during authentication: ${error}`);
                });
            },
            async signOut() {
                await this.$msalInstance
                .logout({})
                .then(() => {
                    this.$emitter.emit('logout', 'logging out');
                })
                .catch(error => {
                    console.error("error in signOut ", error);
                });
            },
        }
    }
</script>

<style lang="scss">
    .vl {
        border-left: 2px solid whitesmoke;
        height: 20px;
        margin-right: 5px;
        margin-left: 5px;
    }
</style>
