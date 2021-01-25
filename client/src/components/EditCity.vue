<template>
  <div class="submit-form mt-3 mx-auto">
    <p class="headline">{{ this.city.id ? 'Editar' : 'Criar' }} Cidade</p>

    <div id="form-container" v-if="!submitted">
      <v-form id="form" ref="form" lazy-validation>

        <v-text-field
            v-model="city.ibge"
            :rules="[(v) => !!v || 'IBGE é obrigatório']"
            label="IBGE"
            type="number"
            required>
        </v-text-field>

        <v-text-field
            v-model="city.uf"
            :rules="[(v) => !!v || 'UF é obrogatória']"
            label="UF"
            required>
        </v-text-field>
        
        <v-text-field
            v-model="city.name"
            :rules="[(v) => !!v || 'Nome é obrogatório']"
            label="Nome"
            required>
        </v-text-field>

        <v-text-field
                v-model="city.longitude"
                :rules="[(v) => !!v || 'Longitude é obrigatória']"
                label="Longitude"
                type="number"
                required>
        </v-text-field>

        <v-text-field
                v-model="city.latitude"
                :rules="[(v) => !!v || 'Latitude é obrigatória']"
                label="Latitude"
                type="number"
                required>
        </v-text-field>

        <v-text-field
                v-model="city.region"
                :rules="[(v) => !!v || 'Região é obrogatório']"
                label="Região"
                required>
        </v-text-field>
      </v-form>

      <label v-if="errorMessage" class="error-message">{{ errorMessage }}</label>

      <v-btn color="primary" class="mt-3" @click="saveCity">Salvar</v-btn>
      <v-btn color="light" class="mt-3" @click="returnScreen">Cancelar</v-btn>
    </div>

    <div v-else>
      <v-card class="mx-auto">
        <v-card-title>
          Salvo com sucesso!
        </v-card-title>

        <v-card-actions>
          <v-btn color="primary" @click="returnScreen">Voltar</v-btn>
        </v-card-actions>
      </v-card>
    </div>
  </div>
</template>

<script>
import CityService from "../services/CityService";

export default {
  name: "EditCity",
  data() {
    return {
      city: {},
      errorMessage: "",
      submitted: false
    };
  },

  methods: {
    saveCity() {
      let form = document.getElementById('form');
      if(form.checkValidity()) {
        this.errorMessage = "";
        if (this.city.id) {
          CityService.updateCity(this.city)
                  .then(() => this.submitted = true)
                  .catch(e => {
                    console.log(e);
                  });
        } else {
          CityService.addCity(this.city)
                  .then(() => this.submitted = true)
                  .catch(e => {
                    console.log(e);
                  });
        }
      } else {
        this.errorMessage = "Campos obrigatórios não preenchidos."
      }
    },

    returnScreen() {
      if (this.city.id) {
        this.$router.push({ name: "city", id: this.city.id});
      } else {
        this.$router.push({ name: "cities" });
      }
    }
  },

  mounted() {
    this.city.id = this.$route.params.id;
    if (this.city.id) {
      CityService.getCity(this.city.id)
          .then(response => {
            this.city = response.data;
          }).catch(e => {
        console.log(e);
      });
    }
  }
};
</script>

<style>
  .submit-form {
    max-width: 300px;
    margin: auto;
  }

  div#form-container button.btn {
    margin-right: 20px;
  }

  label.error-message {
    color: red;
  }
</style>
