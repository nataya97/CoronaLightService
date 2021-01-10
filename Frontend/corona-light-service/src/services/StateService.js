import api from "../api";

class StateService {

    getByState(name) {
        return api.get(`/state?name=${name}`);
    }

}

export default new StateService();
