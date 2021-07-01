<template>
  <!--div :style="{backgroundImage:'url(https://www.tekcrispy.com/wp-content/uploads/2018/09/Libro-antiguo-640x360.jpg)'}"-->
    
    <div id="app" class="container-fluid">
      <div class="site-info">
        <h1>Biblioteca de Babel</h1>
        <h3>Bienvenido(a) al sistema de libros</h3>
      </div>
      <nav>
        <router-link class="btn btn-primary" to="/">Libros</router-link>
        <router-link class="btn btn-primary" to="/add">Añadir</router-link>
        <router-link class="btn btn-primary" to="/search">Buscar por titulo</router-link>
        <router-link class="btn btn-primary" to="/search-room">Buscar por sala</router-link>
      </nav>
      <br/> 
      <router-view/>
    </div>
</template>

<script>
export default {
  name: "app"
};
</script>

<style>
.site-info {
  color: blue;
  margin-bottom: 20px;
}

.btn-primary {
  margin-right: 5px;
}

.container-fluid {
  text-align: center;
}
</style>
