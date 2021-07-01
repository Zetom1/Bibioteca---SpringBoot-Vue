<template>
  <div class="searchform">
    <h4 class= "searchtitle">Buscar por sala</h4>
    <div class="form-group">
      <input type="text" class="form-control" id="sala" required v-model="sala" name="sala">
    </div>
 
    <div class="btn-group">
      <button v-on:click="searchBooks" class="btn btn-success">Buscar</button>
    </div>

    <ul class="search-result">
      <li v-for="(book, index) in books" :key="index">
        <h6>{{book.titulo}} Sala:{{book.sala}}, Estante:{{book.estante}}, Librero:{{book.librero}}, Posición:{{book.posicion}}, Existencia:{{book.existencia}}</h6>
      </li>
    </ul>
  </div>
</template>

<script>
import http from "../http-common";

export default {
  name: "search-custombooker",
  data() {
    return {
      volumen: 0,
      books: []
    };
  },
  methods: {
    /* eslint-disable no-console */
    searchBooks() {
      http
        .get("/sala/" + this.sala)
        .then(response => {
          this.books = response.data; // JSON are parsed automatically.
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    }
    /* eslint-enable no-console */
  }
};
</script>

<style>
.searchtitle{
  color: black;
}
.searchform {
  max-width: 300px;
  margin: auto;
}
.search-result {
  margin-top: 20px;
  text-align: left;
}
</style>