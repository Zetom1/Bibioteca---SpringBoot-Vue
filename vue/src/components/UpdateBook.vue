<template>
  <div class="searchform">
    <h4 class= "searchtitle">Buscar por titulo</h4>
    <div class="form-group">
      <input type="text" class="form-control" id="titulo" required v-model="titulo" name="titulo">
    </div>
 
    <div class="btn-group">
      <button v-on:click="searchBooks" class="btn btn-success">Buscar</button>    <ul class="search-result">
      <li v-for="(book, index) in books" :key="index">
        <h6>{{book.titulo}} Sala:{{book.sala}}, Estante:{{book.estante}}, Librero:{{book.librero}}, Posición:{{book.posicion}}, Existencia:{{book.existencia}}</h6>
      </li>
    </ul>
    </div>
      <div v-if="!submitted">
            <div class="form-group">
          <label for="titulo">Titulo </label>
          <input type="text" class="form-control" id="titulo" required v-model="book.titulo" name="titulo">
        </div>
    
        <div class="form-group">
          <label for="volumen">Volumen </label>
          <input type="number" class="form-control" id="volumen" required v-model="book.volumen" name="volumen">
        </div>
    
        <div class="form-group">
          <label for="estante">Estante </label>
          <input type="text" class="form-control" id="estante" required v-model="book.estante" name="estante">
        </div>

        <div class="form-group">
          <label for="sala">Sala </label>
          <input type="text" class="form-control" id="sala" required v-model="book.sala" name="sala">
        </div>

        <div class="form-group">
          <label for="librero">Librero </label>
          <input type="text" class="form-control" id="librero" required v-model="book.librero" name="librero">
        </div>
        
        <div class="form-group">
          <label for="posicion">Posición </label>
          <input type="text" class="form-control" id="posicion" required v-model="book.posicion" name="posicion">
        </div>
        
        <button v-on:click="saveBook" class="btn btn-success">Aceptar</button>
    </div>
    
    <div v-else>
      <h4>Confirmar</h4>
      <button class="btn btn-success" v-on:click="newBook">Añadir</button>
    </div>
    
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
        .get("/books/titulo/" + this.titulo)
        .then(response => {
          this.books = response.data; // JSON are parsed automatically.
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
  name: "add-book",
  data() {
    return {
      book: {
        id: 0,
        titulo: "",
        volumen: 0,
        estante: "",
        sala: "",
        librero: "",
        posicion: "",
      },
      submitted: false
    };
  },
    saveBook() {
      var data = {
        titulo: this.book.titulo,
        volumen: this.book.volumen,
        estante: this.book.estante,
        sala: this.book.sala,
        librero: this.book.librero,
        posicion: this.book.posicion
        
      };

      http
        .post("/book", data)
        .then(response => {
          this.book.id = response.data.id;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });

      this.submitted = true;
    },
    newBook() {
      this.submitted = false;
      this.book = {};
    }
  }
};

</script>

<style>
.submitform {
  max-width: 300px;
  margin: auto;
}
.form-group{
  color: black;
}
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