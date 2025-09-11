import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import PrimeVue from 'primevue/config';
import Aura from "@primevue/themes/aura";       //theme
import "primeicons/primeicons.css";                 //icons

// const router = createRouter({
//   history: createWebHistory(),
//   routes: [
//     { path: '/', redirect: '/library' },
//     { path: '/library', component: GetBooks },
//     { path: '/manage', component: ManageBook }
//   ]
// })

const app = createApp(App);
app.use(PrimeVue, {
    theme: {
        preset: Aura
    }
});

app.use(Aura);
// app.use(router);
app.mount('#app')
