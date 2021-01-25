<template>
  <v-app>
    <v-app-bar app dark>
      <div class="d-flex align-center mr-2">
        CityControl
      </div>

      <v-btn to="/cities" text>
        Cidades
      </v-btn>

      <v-btn to="/report" text>
        Relatório
      </v-btn>
    </v-app-bar>

    <v-main>
      <router-view />
    </v-main>
  </v-app>
</template>

<script>
export default {
  name: 'App'
};
</script>

<style>
  .v-main {
    margin-top: 40px;
    margin-bottom: 40px;
  }
</style>