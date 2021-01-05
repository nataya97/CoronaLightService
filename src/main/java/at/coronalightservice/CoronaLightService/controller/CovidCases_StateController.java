package at.coronalightservice.CoronaLightService.controller;

import at.coronalightservice.CoronaLightService.entity.CovidCases_State;
import at.coronalightservice.CoronaLightService.service.CovidCases_StateService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/covidCasesState")
@CrossOrigin(origins = "http://localhost:8080")
public class CovidCases_StateController {

    @Autowired
    CovidCases_StateService covidCases_stateService;

    @PutMapping
    @ApiOperation(value = "Update existing Covid Case", response = CovidCases_State.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Creation Successful"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    public CovidCases_State updateCovidCase(@ApiParam(value = "Covid Case to update", required = true) @RequestBody CovidCases_State covidCases_state) {
        return covidCases_stateService.addCovidCase(covidCases_state);
    }

    @PostMapping
    @ApiOperation(value = "Add a new Covid Case", response = CovidCases_State.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Creation Successful"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    public CovidCases_State addCovidCase(@ApiParam(value = "Covid Case to save", required = true) @RequestBody CovidCases_State covidCases_state) {
        return covidCases_stateService.addCovidCase(covidCases_state);
    }

    @GetMapping(value = "/{state_Id}")
    @ApiOperation(value = "Get Covid Cases by State Id ", response = CovidCases_State.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Request Successful"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    public List<CovidCases_State> getCovidCasesByStateId(@ApiParam(value = "Covid Cases to get by State Id", required = true) @PathVariable Long state_Id) {
        return covidCases_stateService.getAllByStateId(state_Id);
    }

    @GetMapping
    @ApiOperation(value = "Get all cases by state ", response = CovidCases_State.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Request Successful"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    public List<CovidCases_State> getCovidCasesByStateName(@ApiParam(value = "Covid Cases to get by State Name", required = true) @RequestParam(value = "state", required = false)  String state) {
        if(state.isEmpty()) {
            return covidCases_stateService.getAllRecentCases();
        }
        return covidCases_stateService.getAllByStateName(state);
    }



}
