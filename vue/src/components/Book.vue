<template>
  <div v-if="this.book">
    <h4>Libro</h4>
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

    <span class="button is-small btn-primary" v-on:click="updateBook()">Actualizar</span>
   
    <span class="button is-small btn-danger" v-on:click="deleteBook()">Borrar</span>
    
  </div>
  <div v-else>
    <br/>
    <p>Selecciona un libro</p>
  </div>
</template>

<script>
import http from "../http-common";

export default {
  name: "book",
  props: ["book"],
  methods: {
    /* eslint-disable no-console */
    updateBook() {
      var data = {
        id: this.book.id,
        titulo: this.book.titulo,
        volumen: this.book.volumen,
        estante: this.book.estante,
        sala: this.book.sala,
        librero: this.book.librero,
        posicion: this.book.posicion
      };

      http
        .put("/book/" + this.book.id, data)
        .then(response => {
          this.book.existencia = response.data.active;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    deleteBook() {
      http
        .delete("/book/" + this.book.id)
        .then(response => {
          console.log(response.data);
          this.$emit("refreshData");
          this.$router.push('/');
        })
        .catch(e => {
          console.log(e);
        });
    }
    /* eslint-enable no-console */
  }
};
</script>