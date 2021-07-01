<template>
  <div class="submitform">
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
        
        <button v-on:click="saveBook" class="btn btn-success">Aceptar
        </button>
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
  methods: {
    /* eslint-disable no-console */
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
    /* eslint-enable no-console */
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
</style>
