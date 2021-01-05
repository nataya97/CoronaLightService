package at.coronalightservice.CoronaLightService.service;

import at.coronalightservice.CoronaLightService.dao.CovidCases_TimelineDao;
import at.coronalightservice.CoronaLightService.entity.CovidCases_Timeline;
import at.coronalightservice.CoronaLightService.entity.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CovidCases_TimelineService {

    @Autowired
    CovidCases_TimelineDao covidCasesTimelineDao;

    public List<CovidCases_Timeline> getAllByState(State state) {
        return covidCasesTimelineDao.findAllByState(state);
    }
}
