<template>
    <app-header></app-header>

    <div class="add-book">
        
    <Form @submit="addNewBook">
        <h1> Book Information Form </h1>
      <InputGroup>
        <InputGroupAddon>Title</InputGroupAddon>
        <InputText v-model="addBookInfo.title" placeholder="Title of this book.." />
      </InputGroup>
      <InputGroup>
        <InputGroupAddon>Author</InputGroupAddon>
        <InputText v-model="addBookInfo.author" placeholder="Author of this book.." />
      </InputGroup>
      <InputGroup>
        <InputGroupAddon>Price</InputGroupAddon>
        <InputText v-model="addBookInfo.price" placeholder="Price of this book.." />
      </InputGroup>
      <InputGroup>
        <InputGroupAddon>Quantity</InputGroupAddon>
        <InputNumber v-model="addBookInfo.quantity" placeholder="Number of this book.." />
      </InputGroup>
      <InputGroup>
        <InputGroupAddon>Image URL</InputGroupAddon>
        <InputText v-model="addBookInfo.image_url" placeholder="Image url of this book.." />
      </InputGroup>
      <Button type="submit" label="Submit" />
    </Form>
  </div>

</template>

<script setup>
  import { ref } from 'vue';
  import AppHeader from './AppHeader.vue';
  import { bookStore } from '../main.js';
  import { Form } from '@primevue/forms';
  import InputGroup from 'primevue/inputgroup';
  import InputGroupAddon from 'primevue/inputgroupaddon';
  import Button from 'primevue/button';
  import InputText from 'primevue/inputtext';
  import InputNumber from 'primevue/inputnumber';
//   import { FileUpload } from 'primevue/file';

  const addBookInfo = ref({
    title: '',
    author: '',
    price: '',
    quantity: 0,
    image_url: ''
  });

  function addNewBook() {
    bookStore.addBook(addBookInfo.value);
  }
</script>

<style scoped>
.add-book{
    width: 50%;
    margin: auto;
    text-align: center;
    position: relative;
}

form{
    background-color: rgb(255, 255, 255);
    border-radius: 20px;
    color: rgb(0, 0, 0);
}


.p-inputgroup {
  width: 90%;
  height: 50px;
  margin: 20px auto;
}

.p-inputgroup .p-inputgroupaddon{
    width: 15% ;
    background-color: #f2f2f2;
}


label {display: block;}

input[type=text], select {
  padding: 12px;
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
  position: absolute;
  
}

input[type=submit]:hover {
  background-color: #45a049;
}

</style>