import { createStore } from 'vuex';
import VuexPersistence from 'vuex-persist';

const vuexLocal = new VuexPersistence({
    storage: localStorage
})

const store = createStore({
    state: {
        user: undefined,
    },
    getters: {

    },
    mutations: {

    },
    actions: {

    },
    plugns: [vuexLocal.plugin]
});

export default store;