package at.coronalightservice.CoronaLightService.controller;

import at.coronalightservice.CoronaLightService.entity.State;
import at.coronalightservice.CoronaLightService.service.StateService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//https://entwickler.de/online/web/openapi-swagger-579827368.html
//https://pro.ideaportriga.com/techlife/document
//https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc
//TODO: Überlegen ob nicht Response zurückggegeben werden soll, statt Entity

@Api(tags = "State Endpoint")
@SwaggerDefinition(tags = {
        @Tag(name = "State Endpoint", description = "State Endpoint")
})
@RestController
@RequestMapping("/state")
@CrossOrigin(origins = "http://localhost:8080")
public class StateController {

    @Autowired
    StateService stateService;

    @PutMapping
    @ApiOperation(value = "Update an existing State", response = State.class) //or model class?
    @ApiResponses({
            @ApiResponse(code = 200, message = "Creation Successful"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    public State updateState(@ApiParam(value = "State to save", required = true) @RequestBody State state) {
        return stateService.addState(state);
    }

    @PostMapping
    @ApiOperation(value = "Create a State", response = State.class) //TODO: or model class?
    @ApiResponses({
            @ApiResponse(code = 200, message = "Creation Successful"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    public State addState(@ApiParam(value = "State to save", required = true) @RequestBody State state) {
        return stateService.addState(state);
    }

    @GetMapping
    @ApiOperation(value = "Get a state by name", response = State.class) //or model class?
    @ApiResponses({
            @ApiResponse(code = 200, message = "Request Successful"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    public List<State> getStateByName(@ApiParam(value = "State to get by Name", required = true) @RequestParam(value = "name", required = false) String name) {
        if (name.isEmpty()) {
            return stateService.getAllStates();
        }
        return stateService.getStateByName(name);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Get a State by ID", response = State.class) //or model class?
    @ApiResponses({
            @ApiResponse(code = 200, message = "Request Successful"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    public State getStateById(@ApiParam(value = "State to get by ID", required = true) @PathVariable Long id) {
        return stateService.getStateById(id);
    }
}
