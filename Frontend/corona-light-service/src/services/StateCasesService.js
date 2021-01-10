import api from "../api";

class StateCasesService {

    getAllCases() {
        return api.get(`/covidCasesState?state=`)
    }
}

export default new StateCasesService();
