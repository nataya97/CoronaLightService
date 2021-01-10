import api from "../api";

class DistrictCasesService {

    getAllCases() {
        return api.get(`/covidCasesDistricts?district=`);
    }

    getCasesByStateID(id) {
        return api.get(`/covidCasesDistricts/${id}`);
    }
}

export default new DistrictCasesService();
