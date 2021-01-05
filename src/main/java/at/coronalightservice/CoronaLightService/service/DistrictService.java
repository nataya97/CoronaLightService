package at.coronalightservice.CoronaLightService.service;

import at.coronalightservice.CoronaLightService.dao.DistrictDao;
import at.coronalightservice.CoronaLightService.entity.District;
import at.coronalightservice.CoronaLightService.entity.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService {

    @Autowired
    DistrictDao districtDao;

    public District getByGkz(Long gkz) {
        return districtDao.getByGkz(gkz);
    }

    public List<District> getAllByState(String state) {
        return districtDao.findAllByStateState(state);
    }

    public District addDistrict(District district) {return districtDao.save(district); }

    public List<District> getAllDistricts() { return districtDao.getAllByGkzIsNotNull(); }
}
