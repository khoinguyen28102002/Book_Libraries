<template>
    <app-header></app-header>
    <div id="search">
        <div id="search-box">
            <i class="fas fa-search"></i>
            <input type="text" v-model="findName" placeholder="Search book..." />
        </div>
    </div>
    <div class="table-wrapper" v-show="currentDisplay === 'search'">
        <div class="table-container">
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Author</th>
                        <th>Price</th>
                        <th>Number in stock</th>
                    </tr>
                </thead>
                <tbody>
                    <tr  v-for="book in searchResult" :key="book.id">
                        <td>{{ book.id }}</td>
                        <td id="title-search"> 
                            <img :src="`http://localhost:9090/images/${book.image_url}`" width="40px" height="50px"/>
                            {{ book.title }} 
                        </td>
                        <td>{{ book.author }}</td>
                        <td>{{ book.price }}</td>
                        <td>{{ book.quantity }}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div class="not-found-class" v-show="currentDisplay === 'not-found'">
        <p>Sorry, <span> {{ findName }} </span> is not found</p>
        <p>Please clear input to return book gallery</p>
    </div>
    <div id="display-wrapper" v-show="currentDisplay === 'all'">
        <div v-for="book in bookStore.listOfBooks" :key="book.id">
            <img :src="`${BASE_URL}/images/${book.image_url}`" />
            <h3> {{ book.title }} </h3>
            <p> Author: {{ book.author }}</p>
            <p> Price: {{ book.price }}</p>
        </div>
    </div>
</template>


<script setup>
    import { ref, watch} from 'vue';
    import AppHeader from './AppHeader.vue';
    import axios from 'axios';
    import { BASE_URL } from '../store/index.js';
    import { bookStore } from '../main.js';

    // const bookStore = useBooksStore()
    const currentDisplay = ref('all');
    const findName = ref('');
    const searchResult = ref([]);

    watch(findName, (newVal, oldVal) => {
        if (newVal === '') {
            currentDisplay.value = 'all';
        } else {
            if (newVal !== oldVal) {
                findBook();
            }
        }
    });

    watch(searchResult, (newVal) =>{
        if (newVal.length !== 0) {
            currentDisplay.value = 'search'
        } else {
            currentDisplay.value = 'not-found'
        }
    })
    async function findBook(bookTitle) {
        await axios.get(`${BASE_URL}/find`, {
            params:{title: bookTitle}
        }).then(response => {
            searchResult.value = response.data
        }).catch(error => {
            console.log("Error fetching book: ", error)
        })
    }
</script>

<style scoped>
#search{
    width: 100vw;
    height: 80px;
    display: flex;
    justify-content: center;
    align-items: center;
}

#search-box {
  position: relative;
}

#search-box i {
  position: absolute;
  left: 15px;
  top: 50%;
  transform: translateY(-50%);
  color: #888;
  pointer-events: none; 
}
#search-box > input{
    width: 400px;
    height: 40px;
    border: 1px solid rgb(181, 173, 173);
    border-radius: 25px;
    display: flex;
    justify-content: center;
    align-items: center;
    padding-left: 45px;
    box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
    font-size: 16px;
}
#search-box > input:focus{
    outline: none;
    border: 1px solid rgb(181, 173, 173);
    box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.2);
}


#display-wrapper {
    display: grid;
    grid-template-columns: repeat(5, 15%);
    justify-content: space-evenly; 
}

#display-wrapper > div {
    display: grid;
    gap: 10px;
    margin: 15px;
    padding: 10px;
    width: 200px;
    height: 400px;
    background-color: rgb(255, 255, 255);
    border-radius: 15px;
    text-align: left;
}

#display-wrapper > div:hover{
    box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.2);
    cursor: pointer;
    transform: translateY(-5px);
    transition: all 0.3s ease;
}

#display-wrapper > div > h3, p{
    margin: 0;
}

#display-wrapper div > img{
    width: calc(100% + 20px);
    height: 250px;
    border-radius: 15px 15px 0px 0px;
    margin: -10px -10px 0px -10px;;
}

#display-wrapper div > h3{
    height: 50px;
    font-size: 18px;
}

.table-wrapper {
  position: relative;
  border-radius: 0.5rem;
  overflow: hidden;
  margin-bottom: 30px;
}

.table-container {
    width: 80%;
    max-height: 24rem;
    overflow-y: auto;
    height: 100%;
    scrollbar-width: none;
    margin: auto;
    border-bottom: 2px solid #15928a;
    border-radius: 0.5rem;
}

table {
  width: 100%;
  border-collapse: separate;  
}
th,
td {
  border: none;
  padding: 1rem 2rem;
  text-align: left;
  &:last-of-type {
    text-align: right;
  }
}

th {
  background-color: #d0f0ee;
  color: #15928a;
  font-weight: bold;
  position: sticky;
  top: 0;
  border-bottom: 2px solid #15928a;
  border-radius: 15px 15px 0 0;
}
#title-search{
    display: flex;
    align-items: center;
    gap: 10px;
}

tbody {
  tr:nth-of-type(even) {
    background-color: hsl(0 0 95);
  }
}


</style>