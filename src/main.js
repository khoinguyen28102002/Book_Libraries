import { createApp } from 'vue'
import { createRouter, createWebHistory } from 'vue-router'
import { createPinia } from 'pinia'

import App from './App.vue'
import GetBooks from './components/GetBooks.vue'
import ManageBook from './components/ManageBook.vue'
import { useBooksStore } from './store/index.js'



const router = createRouter({
  history: createWebHistory(),
  routes: [
    { path: '/', redirect: '/library' },
    { path: '/library', component: GetBooks },
    { path: '/manage', component: ManageBook }
  ]
})

const app = createApp(App)
const pinia = createPinia()

app.use(pinia)
app.use(router)
app.mount('#app')

export const bookStore = useBooksStore()
bookStore.fetchBooks()

