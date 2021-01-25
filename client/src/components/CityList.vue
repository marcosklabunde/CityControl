<template>
  <v-row align="center" class="list px-1 mx-auto">
    <v-col cols="12" sm="12">
      <v-card class="mx-auto" tile>
        <v-card-title>
          Cidades
          <v-btn small id="btn-add-city" @click="addCity">+NOVO</v-btn>
        </v-card-title>

        <v-card-actions>
          <v-text-field
                  class="filter-field"
                  v-model="filterParams.ibge"
                  label="IBGE"
                  type="number">
          </v-text-field>

          <v-text-field
                  class="filter-field"
                  v-model="filterParams.uf"
                  label="UF">
          </v-text-field>

          <v-text-field
                  class="filter-field"
                  v-model="filterParams.nameLike"
                  label="Nome">
          </v-text-field>

          <v-text-field
                  class="filter-field"
                  v-model="filterParams.region"
                  label="Região">
          </v-text-field>

          <v-icon id="icon-filter-cities" @click="filterCities">mdi-magnify</v-icon>
        </v-card-actions>

        <v-data-table
            :headers="headers"
            :items="cities"
            disable-pagination
            :hide-default-footer="true"
        >
          <template v-slot:[`item.actions`]="{ item }">
            <v-icon small class="mr-2" @click="viewCity(item.id)">mdi-eye</v-icon>
            <v-icon small class="mr-2" @click="editCity(item.id)">mdi-pencil</v-icon>
            <v-icon small @click="removeCity(item.id)">mdi-delete</v-icon>
          </template>
        </v-data-table>

      </v-card>
    </v-col>
  </v-row>
</template>

<script>
import CityService from "@/services/CityService";
export default {
  name: "CityList",
  data() {
    return {
      cities: [],
      filterParams: {},
      headers: [
        { text: "IBGE", value: "ibge", align: "start", sortable: true },
        { text: "UF", value: "uf", align: "start", sortable: true },
        { text: "Nome", value: "name", align: "start", sortable: true },
        { text: "Longitude", value: "longitude", align: "start", sortable: true },
        { text: "Latitude", value: "latitude", align: "start", sortable: true },
        { text: "Região", value: "region", align: "start", sortable: true },
        { text: "",value: "actions", align: "end", sortable: true }
      ],
    };
  },
  methods: {
    retrieveCities() {
      CityService.getAllCities()
          .then((response) => {
            this.cities = response.data.map(this.getDisplayCity);
            console.log(response.data);
          })
          .catch((e) => {
            console.log(e);
          });
    },

    filterCities() {
      CityService.getCitiesByFilter(this.filterParams)
              .then((response) => {
                this.cities = response.data.map(this.getDisplayCity);
                console.log(response.data);
              })
              .catch((e) => {
                console.log(e);
              });
    },

    refreshList() {
      this.retrieveCities();
    },

    viewCity(id) {
      this.$router.push({ name: "city", params: { id: id } });
    },

    editCity(id) {
      this.$router.push({ name: "editCity", params: { id: id } });
    },

    addCity() {
      this.$router.push({ name: "addCity" });
    },

    removeCity(id) {
      CityService.removeCity(id)
          .then(() => {
            this.refreshList();
          })
          .catch((e) => {
            console.log(e);
          });
    },

    getDisplayCity(city) {
      return {
        id: city.id,
        ibge: this.parseStringValue(city.ibge),
        uf: city.uf,
        name: this.parseStringValue(city.name),
        longitude: this.parseStringValue(city.longitude),
        latitude: this.parseStringValue(city.latitude),
        region: this.parseStringValue(city.region)
      };
    },

    parseStringValue(value) {
      if (value) {
        return value.toString().length > 9 ? value.toString().substr(0, 9) + "..." : value;
      }
      return '';
    }
  },

  mounted() {
    this.retrieveCities();
  },
};
</script>

<style >
  .list {
    max-width: 750px;
  }

  #btn-add-city {
    margin-left: 20px;
  }

  .filter-field {
    margin-right: 10px;
  }
</style>