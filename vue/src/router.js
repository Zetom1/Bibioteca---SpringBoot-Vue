import Vue from "vue";
import Router from "vue-router";
import BooksList from "./components/BooksList.vue";
import AddBook from "./components/AddBook.vue";
import SearchBooks from "./components/SearchBooks.vue";
import SearchRoom from "./components/SearchRoom.vue";
import Book from "./components/Book.vue";

Vue.use(Router);

export default new Router({
  mode: "history",
  routes: [
    {
      path: "/",
      name: "books",
      alias: "/book",
      component: BooksList,
      children: [
        {
          path: "/book/:id",
          name: "book-details",
          component: Book,
          props: true
        }
      ]
    },
    {
      path: "/add",
      name: "add",
      component: AddBook
    },
    {
      path: "/search",
      name: "search",
      component: SearchBooks
    },
    {
      path: "/search-room",
      name: "search-room",
      component: SearchRoom
    },
  ]
});