import http from "../http-common";

class CityService {
    constructor() {
        let self = this;
        self.cityRestUrl = "/cities";
    }

    addCity(city) {
        return http.post(this.cityRestUrl, city);
    }

    updateCity(city) {
        return http.put(`${this.cityRestUrl}`, city);
    }

    removeCity(id) {
        return http.delete(`${this.cityRestUrl}/${id}`);
    }

    getAllCities() {
        return http.get(this.cityRestUrl);
    }

    getCitiesByFilter(filterParams) {
        return http.put(`${this.cityRestUrl}/filter`, filterParams);
    }

    getCity(id) {
        return http.get(`${this.cityRestUrl}/${id}`);
    }
}

export default new CityService();