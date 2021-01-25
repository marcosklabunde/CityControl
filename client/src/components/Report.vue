<template>
    <v-row class="list px-3 mx-auto">
        <v-col cols="6" sm="6">
            <v-card class="mx-auto" tile>
                <v-card-title>
                    Regiões
                    <v-card-subtitle>
                        (cidades)
                    </v-card-subtitle>
                </v-card-title>


                <v-card-text v-for="region in regionList" :key="region">
                    {{ region[0] }}: {{ region[1] }}
                </v-card-text>
            </v-card>
        </v-col>
        <v-col cols="6" sm="6">
            <v-card class="mx-auto" tile>
                <v-card-title>
                    UFs
                    <v-card-subtitle>
                        (cidades)
                    </v-card-subtitle>
                </v-card-title>

                <v-card-text v-for="uf in ufList" :key="uf">
                    {{ uf[0] }}: {{ uf[1] }}
                </v-card-text>
            </v-card>
        </v-col>
    </v-row>
</template>

<script>
    import ReportService from "../services/ReportService";
    export default {
        name: "Report",
        data() {
            return {
                ufList: [],
                regionList: []
            }
        },
        methods: {
            countUfs() {
                ReportService.countCitiesByGroup("uf")
                    .then((response) => {
                        this.ufList = response.data;
                    }).catch((e) => {
                        console.log(e);
                    });
            },

            countRegions() {
                ReportService.countCitiesByGroup("region")
                    .then((response) => {
                        this.regionList = response.data;
                    }).catch((e) => {
                    console.log(e);
                });
            }
        },

        mounted() {
            this.countUfs();
            this.countRegions();
        }
    }
</script>

<style scoped>
    .report-card {
        display: inline-block;
    }
</style>