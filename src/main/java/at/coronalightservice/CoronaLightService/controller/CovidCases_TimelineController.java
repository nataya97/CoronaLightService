package at.coronalightservice.CoronaLightService.controller;

import at.coronalightservice.CoronaLightService.service.CovidCases_TimelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/covidCasesTimeline")
@CrossOrigin(origins = "http://localhost:8080")
public class CovidCases_TimelineController {

    @Autowired
    CovidCases_TimelineService covidCases_TimelineService;

}
