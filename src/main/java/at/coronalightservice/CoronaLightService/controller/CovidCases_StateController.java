package at.coronalightservice.CoronaLightService.controller;

import at.coronalightservice.CoronaLightService.entity.CovidCases_State;
import at.coronalightservice.CoronaLightService.model.CovidCases_StateModel;
import at.coronalightservice.CoronaLightService.service.CovidCases_StateService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Api(tags = "CovidCases_State Endpoint")
@SwaggerDefinition(tags = {
        @Tag(name = "CovidCases_State Endpoint", description = "Der Enpoint, um die Covid-Faelle für die Bundeslaender abzufragen")
})
@RestController
@RequestMapping("/covidCasesState")
@CrossOrigin(origins = "http://localhost:8080")
public class CovidCases_StateController {

    @Autowired
    CovidCases_StateService covidCases_stateService;

    @PutMapping
    @ApiOperation(value = "Update existing Covid Case", response = CovidCases_StateModel.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Creation Successful"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    public ResponseEntity<CovidCases_State> updateCovidCase(@ApiParam(value = "Covid Case to update", required = true) @RequestBody CovidCases_State covidCases_state) {
        if(covidCases_state == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        CovidCases_State covidCasesState = covidCases_stateService.addCovidCase(covidCases_state);
        return new ResponseEntity<>(covidCasesState, HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation(value = "Add a new Covid Case", response = CovidCases_StateModel.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Creation Successful"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    public ResponseEntity<CovidCases_State> addCovidCase(@ApiParam(value = "Covid Case to save", required = true) @RequestBody CovidCases_State covidCases_state) {
        if(covidCases_state == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        CovidCases_State covidCasesState = covidCases_stateService.addCovidCase(covidCases_state);
        return new ResponseEntity<>(covidCasesState, HttpStatus.OK);
    }

    @GetMapping(value = "/{state_Id}")
    @ApiOperation(value = "Get Covid Cases by State Id ", response = CovidCases_StateModel.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Request Successful"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    public ResponseEntity<List<CovidCases_State>> getCovidCasesByStateId(@ApiParam(value = "Covid Cases to get by State Id", required = true) @PathVariable Long state_Id) {
        List<CovidCases_State> covidCasesStateList = covidCases_stateService.getAllByStateId(state_Id);
        if(covidCasesStateList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation(value = "Get the most recent Cases ", response = CovidCases_StateModel.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Request Successful"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    public ResponseEntity<List<CovidCases_State>> getCovidCasesByStateName(@ApiParam(value = "Covid Cases to get by State Name", required = true) @RequestParam(value = "state", required = false)  String state) {
        List<CovidCases_State> covidCasesStateList = new ArrayList<>();
        LocalDate date = LocalDate.now();

        if (StringUtils.isEmpty(state)) {
            covidCasesStateList.addAll(covidCases_stateService.getAllRecentCases(date));
            if(covidCasesStateList.isEmpty()) { //possibility of a day with no data
                covidCasesStateList.addAll(covidCases_stateService.getAllRecentCases(date.minusDays(2)));
            }
        } else
            covidCasesStateList.addAll(covidCases_stateService.getAllByStateName(state));

        if (covidCasesStateList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(covidCasesStateList, HttpStatus.OK);
    }

}
