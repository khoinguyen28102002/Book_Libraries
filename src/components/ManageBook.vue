<template>
    <app-header></app-header>
    <!-- <div class="action-tabs"> 

    </div> -->
    <nav class="action-tabs">
        <ul>
            <li v-for="(item, index) in actionTabs" 
                :key="index"
                :class="{ active: activeIndex === index }"
                @click="setDisplayTab(index)">
                {{ item }}
            </li>
        </ul>
    </nav>
    <div class="table-wrapper" v-show="currentDisplay === actionTabs[0]">
        <div class="table-container">
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Author</th>
                        <th>Price</th>
                        <th style="text-align: right;">Number in stock</th>
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

    <div class="add-book" v-show="currentDisplay === actionTabs[1]">
        <form @submit.prevent="addNewBook">
            <label for="title">Title</label>
            <input type="text" id="title" name="title" v-model="addBookInfo.title" placeholder="Title of this book..">

            <label for="author">Author</label>
            <input type="text" id="author" name="author" v-model="addBookInfo.author" placeholder="Author of this book..">


            <label for="price">Price</label>
            <input type="text" id="price" name="price" v-model="addBookInfo.price" placeholder="Price of this book..">

            <label for="quantity"></label>
            <input type="text" id="quantity" name="quantity" v-model="addBookInfo.quantity" placeholder="Number of this book..">

            <label for="imageurl"></label>
            <input type="text" id="imageurl" name="imageurl" v-model="addBookInfo.image_url" placeholder="Image url of this book..">
            <input type="submit" value="Submit">
        </form>
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

<style>
.action-tabs{
    height: 100%;
    display: flex;
    justify-content: flex-start;
}
.action-tabs ul {
    width: 80%;
    list-style-type: none;
    margin: 20px auto;
    padding: 0;
    height: 100%;
    display: flex;
    gap: 30px;
}
.action-tabs li {
    height: 50px;
    width: 170px;
    text-align: center;
    align-content: center;
    /* border: 1px solid transparent;
    border-radius: 40px; */
}
.action-tabs li {
    padding: 14px 16px;
    text-decoration: none;
    color: black;
    font-size: 18px;
    transition: all 0.3s ease;
}

.action-tabs li:hover {
    background-color: #ececec;
    border-color: #9a9a9a;
    cursor: pointer;
    /* transform: scale(1.1);; */
}
.action-tabs .active{
    font-weight: bolder;
    border-bottom: 2px solid black ;
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
  /* &:last-of-type {
    text-align: right;
  } */
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
    display: flex;
    justify-content: center;
    gap: 10px;
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