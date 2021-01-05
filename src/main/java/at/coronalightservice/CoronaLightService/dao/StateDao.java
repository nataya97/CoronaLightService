package at.coronalightservice.CoronaLightService.dao;

import at.coronalightservice.CoronaLightService.entity.State;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateDao extends CrudRepository<State, Long> {

    State findStateByStateId(Long stateId);

    List<State> findStateByState(String state);

    List<State> getAllByStateIdIsNotNull();

}
