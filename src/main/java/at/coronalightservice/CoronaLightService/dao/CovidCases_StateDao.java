package at.coronalightservice.CoronaLightService.dao;

import at.coronalightservice.CoronaLightService.entity.CovidCases_State;
import at.coronalightservice.CoronaLightService.entity.State;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CovidCases_StateDao extends CrudRepository<CovidCases_State, Long> {

    List<CovidCases_State> findAllByStateState(String name);

    List<CovidCases_State> findAllByState_StateId(Long id);

    List<CovidCases_State> getTop10ByReportDateOrderByReportDateAsc(LocalDate reportDate);

}
