package at.coronalightservice.CoronaLightService.dao;

import at.coronalightservice.CoronaLightService.entity.CovidCases_Timeline;
import at.coronalightservice.CoronaLightService.entity.State;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CovidCases_TimelineDao extends CrudRepository<CovidCases_Timeline, Long> {

    List<CovidCases_Timeline> findAllByState(State state);

}
