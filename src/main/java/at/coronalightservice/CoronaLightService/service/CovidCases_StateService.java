package at.coronalightservice.CoronaLightService.service;

import at.coronalightservice.CoronaLightService.dao.CovidCases_StateDao;
import at.coronalightservice.CoronaLightService.entity.CovidCases_State;
import at.coronalightservice.CoronaLightService.entity.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CovidCases_StateService {

    @Autowired
    CovidCases_StateDao covidCases_stateDao;

    public List<CovidCases_State> getAllByStateName(String name) {
        return covidCases_stateDao.findAllByStateState(name);
    }

    public List<CovidCases_State> getAllByStateId(Long id) {
        return covidCases_stateDao.findAllByState_StateId(id);
    }

    public CovidCases_State addCovidCase(CovidCases_State covidCases_state) {
        return covidCases_stateDao.save(covidCases_state);
    }

    public List<CovidCases_State> getAllRecentCases(LocalDate date) {
        return covidCases_stateDao.getTop10ByReportDateOrderByReportDateAsc(date);
    }

}
