import http from "../http-common";

class ReportService {
    constructor() {
        let self = this;
        self.reportRestUrl = "/report";
    }

    countCitiesByGroup(propName) {
        return http.get(`${this.reportRestUrl}/${propName}`);
    }
}

export default new ReportService();