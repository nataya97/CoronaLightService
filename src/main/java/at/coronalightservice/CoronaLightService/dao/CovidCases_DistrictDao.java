package at.coronalightservice.CoronaLightService.dao;

import at.coronalightservice.CoronaLightService.entity.CovidCases_District;
import at.coronalightservice.CoronaLightService.entity.District;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CovidCases_DistrictDao extends CrudRepository<CovidCases_District, Long> {

    List<CovidCases_District> findAllByDistrictGkz(Long gkz);

    List<CovidCases_District> findAllByDistrictDistrict(String district);

    List<CovidCases_District> getAllByDistrictIsNotNull();

}
