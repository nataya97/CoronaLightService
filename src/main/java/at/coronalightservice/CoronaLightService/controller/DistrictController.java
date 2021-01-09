package at.coronalightservice.CoronaLightService.controller;

import at.coronalightservice.CoronaLightService.entity.District;
import at.coronalightservice.CoronaLightService.service.DistrictService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/district")
public class DistrictController {

    @Autowired
    DistrictService districtService;

    @PutMapping
    @ApiOperation(value = "Update existing District", response = District.class) //or model class?
    @ApiResponses({
            @ApiResponse(code = 200, message = "Creation Successful"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    public District updateDistrict(@ApiParam(value = "District to save", required = true) @RequestBody District district) {
        return districtService.addDistrict(district);
    }

    @PostMapping
    @ApiOperation(value = "Add a District", response = District.class) //or model class?
    @ApiResponses({
            @ApiResponse(code = 200, message = "Creation Successful"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    public District addDistrict(@ApiParam(value = "District to save", required = true) @RequestBody District district) {
        return districtService.addDistrict(district);
    }

    @GetMapping
    @ApiOperation(value = "Get a District by State", response = District.class) //or model class?
    @ApiResponses({
            @ApiResponse(code = 200, message = "Request Successful"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    public List<District> getDistrictByState(@ApiParam(value = "District to get by State, if no State specified, get all Districts", required = true) @RequestParam(value = "state", required = false) String state) {
        if(state.isEmpty()) {
            return districtService.getAllDistricts();
        }
        return districtService.getAllByState(state);
    }

    @GetMapping("{/gkz}")
    @ApiOperation(value = "Get a District by GKZ", response = District.class) //or model class?
    @ApiResponses({
            @ApiResponse(code = 200, message = "Request Successful"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    public District getDistrictByGkz(@ApiParam(value = "District to get by GKZ", required = true) @PathVariable("gkz") Long gkz) {
        System.out.println("In Controller " + gkz + " " + districtService.getByGkz(gkz));
        return districtService.getByGkz(gkz);
    }

    /*@GetMapping("name")
    @ApiOperation(value = "Get a District by Name", response = District.class) //or model class?
    @ApiResponses({
            @ApiResponse(code = 200, message = "Request Successful"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    public District getDistrictByName(@ApiParam(value = "District to get by Name", required = true) @RequestParam("name") String name) {
        return districtService.getByDistrictName(name);
    }*/

}
