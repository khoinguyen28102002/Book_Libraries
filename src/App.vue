<script setup>
import { ref } from "vue";
import HelloWorld from './components/HelloWorld.vue'
import Button from "primevue/button";
// import Menu from 'primevue/menu';
import Menubar from 'primevue/menubar';
// import { useRouter } from 'vue-router';
const items = ref([
    { label: 'New', icon: 'pi pi-plus' },
    { label: 'Search', icon: 'pi pi-search' }
]);
const menuItems = [
    {
        label: 'Library',
        icon: 'pi pi-book',
        command: () => router.push('/library')
    },
    {
        label: 'Manage',
        icon: 'pi pi-cog',
        command: () => router.push('/manage')
    }
];
</script>

<template>
  <div>
    <a href="https://vite.dev" target="_blank">
      <img src="/vite.svg" class="logo" alt="Vite logo" />
    </a>
    <a href="https://vuejs.org/" target="_blank">
      <img src="./assets/vue.svg" class="logo vue" alt="Vue logo" />
    </a>
  </div>
  <div class="card flex justify-center">
        <Button label="Verify" />
        <Menubar :model="items" />
    </div>
  <HelloWorld msg="Vite + Vue" />
</template>

<style scoped>
.logo {
  height: 6em;
  padding: 1.5em;
  will-change: filter;
  transition: filter 300ms;
}
.logo:hover {
  filter: drop-shadow(0 0 2em #646cffaa);
}
.logo.vue:hover {
  filter: drop-shadow(0 0 2em #42b883aa);
}
</style>
