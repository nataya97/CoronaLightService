package at.coronalightservice.CoronaLightService.service;

import at.coronalightservice.CoronaLightService.dao.StateDao;
import at.coronalightservice.CoronaLightService.entity.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {

    @Autowired
    StateDao stateDao;

    public State getStateById(Long id) {
        return stateDao.findStateByStateId(id);
    }

    public List<State> getStateByName(String name) {
        return stateDao.findStateByState(name);
    }

    public State addState(State state) { return stateDao.save(state);}

    public List<State> getAllStates() { return stateDao.getAllByStateIdIsNotNull(); }
}
