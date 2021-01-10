package at.coronalightservice.CoronaLightService.service;

import at.coronalightservice.CoronaLightService.dao.CovidCases_DistrictDao;
import at.coronalightservice.CoronaLightService.entity.CovidCases_District;
import at.coronalightservice.CoronaLightService.entity.District;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CovidCases_DistrictService {

    @Autowired
    CovidCases_DistrictDao covidCases_districtDao;

    public List<CovidCases_District> getAllByGkz(Long gkz) {
        return covidCases_districtDao.findAllByDistrictGkz(gkz);
    }

    public List<CovidCases_District> getAllByDistrictName(String name) {
        return covidCases_districtDao.findAllByDistrictDistrict(name);
    }

    public CovidCases_District addCovidCase(CovidCases_District covidCases_district) {
        return covidCases_districtDao.save(covidCases_district);
    }

    public List<CovidCases_District> getAllCases() {
        return covidCases_districtDao.getAllByDistrictIsNotNull();
    }


    /*public List<CovidCases_District> getAllCasesByDistrict(Long gkz) {
        return covidCases_districtDao.getAllByDistrictGkz(gkz);
    }*/

}
