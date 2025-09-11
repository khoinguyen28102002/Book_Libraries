<template>
    <app-header></app-header>
    <div class="table-wrapper">
        <div class="table-container">
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Author</th>
                        <th>Price</th>
                        <th style="text-align: right;">Number in stock</th>
                        <th style="text-align: center;"> Actions </th>
                    </tr>
                </thead>
                <tbody>
                    <tr  v-for="book in bookStore.listOfBooks" :key="book.id">
                        <td>{{ book.id }}</td>
                        <td id="title-search"> 
                            <img :src="`${BASE_URL}/images/${book.image_url}`" width="40px" height="50px"/>
                            {{ book.title }} 
                        </td>
                        <td>{{ book.author }}</td>
                        <td>{{ book.price }}</td>
                        <td style="text-align: right;">{{ book.quantity }}</td>
                        <td id="actions"> 
                            <button> <i class="fas fa-edit"></i>  </button>
                            <button @click="bookStore.deleteBook(book.id)"> <i class="fa-solid fa-trash"></i> </button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>

</template>

<script setup>
    import { ref } from 'vue';
    import AppHeader from './AppHeader.vue';
    import { BASE_URL } from '../store/index.js'
    import { bookStore } from '../main.js';
    // import axios from 'axios';

    const actionTabs = ref(['Mange Book', 'Add new Book'])
    const activeIndex = ref(0)
    const currentDisplay = ref(actionTabs.value[0])
    const addBookInfo = ref({
        title: '',
        author: '',
        price: '',
        quantity: 0,
        image_url: ''
    })
    

    function setDisplayTab(index){
        activeIndex.value = index
        currentDisplay.value = actionTabs.value[index]
    }

    
    function addNewBook() {
        bookStore.addBook(addBookInfo.value)        
    }
</script>

<style scoped>

.table-wrapper {
  position: relative;
  border-radius: 0.5rem;
  margin-bottom: 30px;
}

.table-container {
    width: 80%;
    height: 100%;
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
  vertical-align: middle;
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

#actions{
    text-align: center;
    align-items: center;
    padding: 1rem 2rem ;
}
#actions button{
    margin: 5px;
    width: 40px;
    height: 40px;
    border: #ccc 1px solid;
    border-radius: 15px;
}
.add-book{
    width: 80%;
    margin: auto;
    text-align: left;
}
form {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}

label {display: block;}

input[type=text], select {
  width: 100%;
  padding: 12px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}
</style>