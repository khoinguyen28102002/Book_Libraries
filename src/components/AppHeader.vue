<template>
    <div class="container">
        <div class="logo-section">
            <img src="../../public/library.png" width="70px" style="margin-bottom: 5px;" />
            <router-link to="/" exact>BOOKS</router-link>
        </div>
        <nav class="topnav">
            <ul>
                <li v-for="(item, index) in menu" 
                    :key="index"
                    :class="{ active: activeIndex === index }"
                    @click="setActive(index)">
                      <!-- <router-link :to="item.url">{{ item.name }}</router-link> -->
                       <RouterLink :to="item.url">{{ item.name }}</RouterLink>
                       <!-- {{ item.name }} -->
                </li>
            </ul>
        </nav>
        <div class="user-section">
            <div class="dropdown">
                <img src="../../Logo_N.png" />
                <button class="dropdown-btn" @click="toggleDropdown">
                User
                </button>

                <div class="dropdown-content" v-if="isOpen">
                <a href="#">Trang chủ</a>
                <a href="#">Giới thiệu</a>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
    import {ref} from "vue"

    const menu = ref([
        { name: 'Library', url: '/library'},
        { name: 'Manage', url: '/manage'}
    ]);
    const activeIndex = ref(0);
    const isOpen = ref(0);

    function setActive(index){
        activeIndex.value = index;
    }
</script>

<style scoped>
*{
    box-sizing: border-box;
    justify-content: center;
    align-items: center;
    /* font-family: "Lucida Console", "Courier New", monospace; */
}
.container {
    width: 100vw;
    height: 100px;
    margin-top:0px;
    background-color: white;
    display: flex;
    border-radius: 0px 0px 40px 40px;
}

.logo-section{
    flex-basis: 20%;
    height: 100%;
    display: flex;
    gap: 10px;
}
.logo-section > a {
    font-size: xx-large;
    font-weight: bold;
    color: black;
    text-decoration: none;
    /* font-family:'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif; */
}
.logo-section > a :hover {
    cursor: pointer;
}
.topnav{
    flex-basis: 60%;
    height: 100%;
    display: flex;
    justify-content: flex-start;
}
.topnav ul {
    width: 80%;
    list-style-type: none;
    margin: auto;
    padding: 0;
    height: 100%;
    display: flex;
    gap: 30px;
}
.topnav li {
    height: 50px;
    width: 170px;
    text-align: center;
    align-content: center;
    border: 1px solid transparent;
    border-radius: 40px;
}
.topnav li a{
    padding: 14px 16px;
    text-decoration: none;
    color: black;
    font-size: 18px;
    transition: all 0.3s ease;
}

.topnav li:hover {
    background-color: #ececec;
    border-color: #9a9a9a;
    cursor: pointer;
    transform: scale(1.1);;
}
.router-link-active{
    font-weight: bolder;
}

.user-section{
    flex-basis: 20%;
}
.user-section .dropdown{
    display: flex;
    gap: 10px;
}
.user-section .dropdown > img{
    width: 50px;
    height: 50px;
    border-radius: 90px;
}
.user-section .dropdown-btn {
    padding: 10px 20px;
    font-size: 17px;
    width: 130px;
    height: 40px;
    border: 2px solid rgb(112, 109, 109);
    cursor: pointer;
    border-radius: 40px;
    font-family: initial;
}


</style>