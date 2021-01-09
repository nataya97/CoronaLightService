package at.coronalightservice.CoronaLightService.dao;

import at.coronalightservice.CoronaLightService.entity.District;
import at.coronalightservice.CoronaLightService.entity.State;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictDao extends CrudRepository<District, Long> {

    District findAllByGkz(Long gkz);

    District getByGkz(Long gkz);

    List<District> findAllByStateState(String state);

    List<District> getAllByGkzIsNotNull();

    District getDistrictByDistrict(String name);


}
