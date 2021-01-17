import { createStore } from 'vuex'

const store = createStore ({
    state() {
        return {
            msalConfig: {
                auth: {
                    clientId: '90c88e9b-2f51-4323-b8ea-f85bcd525af8',
                    authority: 'https://login.microsoftonline.com/8d7391b6-6d66-4625-ada5-ff437c1a0e9c/',
                },
                cache: {
                    cacheLocation: 'localStorage',
                },
            },
            accessToken: ''
        };
    },

    mutations: {
        setAccessToken(state, token) {
            state.accessToken = token;
        }
    }
});

export default store;
