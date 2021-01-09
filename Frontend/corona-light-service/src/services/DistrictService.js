import api from "../api";

class DistrictService {

    getByGkz(gkz) {
        return api.getById(`/district/${gkz}`);
    }

    getByName(name) {
        return api.get(`/district?district=${name}`);
    }

    getAllDistricts() {
        return api.get(`/district?state=`);
    }
}

export default new DistrictService();
