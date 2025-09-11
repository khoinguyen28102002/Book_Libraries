import { defineStore } from 'pinia'
import axios from 'axios'
export const BASE_URL = 'http://localhost:9090/books'
export const useBooksStore = defineStore('books', {
    state: () => ({
        listOfBooks: [],
    }),
    actions:{
        async fetchBooks(){
            await axios.get(`http://localhost:9090/books/all`)
                .then(response =>{
                    this.listOfBooks = response.data
                })
                .catch(error =>{
                    alert('Error fetching books:', error)
                })
        },
        async addBook(book){
            await axios.post(`${BASE_URL}/add`, book, {
                    headers:{
                        "Content-Type": "application/json"
                    }
                })
                .then(response =>{
                    if (response.status === 200 && response.data && response.data.id) {
                        alert('Add new book successfully!');
                    }
                })
                .catch(error =>{
                    console.log('Error adding books:', error)
                    alert('Add new book failed!');
                })
            this.fetchBooks()
        },
        async updateBook(book, id){
            await axios.put(`${BASE_URL}/update/${id}`, book, {
                    headers:{
                        "Content-Type": "application/json"
                    }
                })
                .then(response =>{
                    console.log(response);
                })
                .catch(error =>{
                    console.log('Error updating books:', error)
                })
            this.fetchBooks()
        },
        async deleteBook(id){
            await axios.delete(`${BASE_URL}/del/${id}`)
                .then(response =>{
                    console.log(response);
                })
                .catch(error =>{
                    console.log('Error deleting books:', error)
                })
            this.fetchBooks()
        }
    }

})