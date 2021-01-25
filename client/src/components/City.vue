<template>
  <v-row align="center" class="list px-3 mx-auto">
    <v-col cols="12" sm="12">
      <v-card class="mx-auto" tile>
        <v-card-title>
          <v-icon small class="mr-2 icon-edit-city" @click="editCity()">mdi-pencil</v-icon>
          {{ selectedCity.name }} - {{ selectedCity.uf }}
        </v-card-title>
        <v-card-text>
          <label>IBGE: </label>
          <p>{{ selectedCity.ibge }}</p>
          <label>Longitude: </label>
          <p>{{ selectedCity.longitude }}</p>
          <label>Latitude: </label>
          <p>{{ selectedCity.latitude }}</p>
          <label>Região: </label>
          <p>{{ selectedCity.region }}</p>
        </v-card-text>
      </v-card>
    </v-col>
  </v-row>
</template>

<script>
import CityService from "@/services/CityService";

export default {
  name: "City",
  data() {
    return {
      selectedCity: {}
    }
  },
  methods: {
    refreshCity() {
      CityService.getCity(this.$route.params.id)
          .then(response => {
            this.selectedCity = response.data;
            console.log(this.selectedCity);
          }).catch(e => {
            console.log(e);
          });
    },

    editCity() {
      this.$router.push({ name: "editCity", params: { id: this.selectedCity.id } });
    },
  },

  mounted() {
    this.refreshCity();
  },
}
</script>

<style>
  .icon-edit-city {
    margin-right: 10px;
  }
</style>