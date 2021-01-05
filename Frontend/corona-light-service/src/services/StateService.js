import api from "../api";

class StateService {

    getByGkz(id) {
        return api.get(`/state/${id}`);
    }

    getByState(name) {
        return api.get(`/state?name=${name}`);
    }

    getAllStates() {
        return api.get(`/state?name=`);
    }

}

export default new StateService();
