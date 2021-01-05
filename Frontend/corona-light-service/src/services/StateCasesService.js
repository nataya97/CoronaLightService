import api from "../api";

class StateCasesService {

    getAllCases() {
        return api.get(`/covidCasesState?state=`)
    }

    getCasesByName(name) {
        return api.get(`/covidCasesState?state=${name}`)
    }
}

export default new StateCasesService();
