package at.coronalightservice.CoronaLightService.controller;

import at.coronalightservice.CoronaLightService.entity.CovidCases_District;
import at.coronalightservice.CoronaLightService.service.CovidCases_DistrictService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/covidCasesDistricts")
@CrossOrigin(origins = "http://localhost:8080")
public class CovidCases_DistrictController {

    @Autowired
    CovidCases_DistrictService covidCases_districtService;

    @PutMapping
    @ApiOperation(value = "Update existing Covid Case", response = CovidCases_District.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Creation Successful"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    public CovidCases_District updateCovidCase(@ApiParam(value = "Covid Case to save", required = true) @RequestBody CovidCases_District covidCases_district) {
        return covidCases_districtService.addCovidCase(covidCases_district);
    }

    @PostMapping
    @ApiOperation(value = "Add a Covid Case", response = CovidCases_District.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Creation Successful"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    public CovidCases_District addCovidCase(@ApiParam(value = "Covid Case to save", required = true) @RequestBody CovidCases_District covidCases_district) {
        return covidCases_districtService.addCovidCase(covidCases_district);
    }

    @GetMapping(value = "/{gkz}")
    @ApiOperation(value = "Get Covid Cases by a District Gkz", response = CovidCases_District.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Request Successful"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    public List<CovidCases_District> getCovidCasesByGkz(@ApiParam(value = "Covid Cases to get by District Gkz", required = true) @PathVariable Long gkz) {
        return covidCases_districtService.getAllByGkz(gkz);
    }

    @GetMapping
    @ApiOperation(value = "Get Covid Cases by a District Name", response = CovidCases_District.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Request Successful"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    public List<CovidCases_District> getCovidCasesByName(@ApiParam(value = "Covid Cases to get by District Name", required = true) @RequestParam(value = "district", required = false) String district) {
        if(district.isEmpty()) {
            return covidCases_districtService.getAllCases();
        }
        return covidCases_districtService.getAllByDistrictName(district);
    }
}
