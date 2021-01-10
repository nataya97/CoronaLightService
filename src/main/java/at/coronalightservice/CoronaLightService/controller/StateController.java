package at.coronalightservice.CoronaLightService.controller;

import at.coronalightservice.CoronaLightService.entity.State;
import at.coronalightservice.CoronaLightService.model.StateModel;
import at.coronalightservice.CoronaLightService.service.StateService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "State Endpoint")
@SwaggerDefinition(tags = {
        @Tag(name = "State Endpoint", description = "Der Enpoint, um die State Daten abzufragen")
})
@RestController
@RequestMapping("/state")
@CrossOrigin(origins = "http://localhost:8080")
public class StateController {

    @Autowired
    StateService stateService;

    @PutMapping
    @ApiOperation(value = "Update an existing State", response = StateModel.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Creation Successful"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    public ResponseEntity<State> updateState(@ApiParam(value = "State to save", required = true) @RequestBody State state) {
        if(state == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        State state1 = stateService.addState(state);
        return new ResponseEntity<>(state1, HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation(value = "Create a State", response = StateModel.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Creation Successful"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    public ResponseEntity<State> addState(@ApiParam(value = "State to save", required = true) @RequestBody State state) {
        if(state == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        State state1 = stateService.addState(state);
        return new ResponseEntity<>(state1, HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation(value = "Get a state by name", response = StateModel.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Request Successful"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    public ResponseEntity<List<State>> getStateByName(@ApiParam(value = "State to get by Name", required = true) @RequestParam(value = "name", required = false) String name) {
        List<State> stateList = new ArrayList<>();

        if (StringUtils.isEmpty(name)) {
            stateList.addAll(stateService.getAllStates());
        } else
            stateList.addAll(stateService.getStateByName(name));

        if (stateList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(stateList, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Get a State by ID", response = StateModel.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Request Successful"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    public ResponseEntity<State> getStateById(@ApiParam(value = "State to get by ID", required = true) @PathVariable Long id) {
        if(StringUtils.isEmpty(id.toString())) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(stateService.getStateById(id), HttpStatus.OK);
    }
}
