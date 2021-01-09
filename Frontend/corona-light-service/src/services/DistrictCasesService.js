import api from "../api";

class DistrictCasesService {

    getAllCases() {
        return api.get(`/covidCasesDistricts?district=`);
    }

    getCasesByName(name) {
        return api.get(`/covidCasesDistricts?district=${name}`);
    }
}

export default new DistrictCasesService();