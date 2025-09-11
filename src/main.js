import { createApp } from 'vue'
import { createRouter, createWebHistory } from 'vue-router'
import { createPinia } from 'pinia'

import App from './App.vue'
import AddNew from './components/AddNew.vue'
import ManageBook from './components/ManageBook.vue'
import { useBooksStore } from './store/index.js'

import PrimeVue from 'primevue/config'
import Aura from '@primevue/themes/aura'
import 'primeicons/primeicons.css'


const router = createRouter({
  history: createWebHistory(),
  routes: [
    { path: '/', redirect: '/manage' },
    { path: '/addnew', name: 'add-new-book', component: AddNew },
    { path: '/manage', name: 'manage-book', component: ManageBook }
  ]
})


const app = createApp(App)

app.use(PrimeVue, {
    theme: {
        preset: Aura
    }
});

const pinia = createPinia()

app.use(pinia)
app.use(router)
app.mount('#app')

export const bookStore = useBooksStore()
bookStore.fetchBooks()

