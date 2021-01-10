package at.coronalightservice.CoronaLightService.controller;

import at.coronalightservice.CoronaLightService.entity.CovidCases_District;
import at.coronalightservice.CoronaLightService.model.CovidCases_DistrictModel;
import at.coronalightservice.CoronaLightService.service.CovidCases_DistrictService;
import at.coronalightservice.CoronaLightService.service.DistrictService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "CovidCases_District Endpoint")
@SwaggerDefinition(tags = {
        @Tag(name = "CovidCases_District Endpoint", description = "Der Enpoint, um die Covid-Faelle für die Bezirke abzufragen")
})
@RestController
@RequestMapping(value = "/covidCasesDistricts")
@CrossOrigin(origins = "http://localhost:8080")
public class CovidCases_DistrictController {

    @Autowired
    CovidCases_DistrictService covidCases_districtService;

    @Autowired
    DistrictService districtService;

    @PutMapping
    @ApiOperation(value = "Update existing Covid Case", response = CovidCases_DistrictModel.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Creation Successful"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    public ResponseEntity<CovidCases_District> updateCovidCase(@ApiParam(value = "Covid Case to save", required = true) @RequestBody CovidCases_District covidCases_district) {
        if(StringUtils.isEmpty(covidCases_district.getDistrict())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else
            if(StringUtils.isEmpty(districtService.getByDistrictName(covidCases_district.getDistrict().getDistrict()))) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        CovidCases_District covidCasesDistrict = covidCases_districtService.addCovidCase(covidCases_district);
        return new ResponseEntity<>(covidCasesDistrict, HttpStatus.CREATED);
    }

    @PostMapping
    @ApiOperation(value = "Add a Covid Case", response = CovidCases_DistrictModel.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Creation Successful"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    public ResponseEntity<CovidCases_District> addCovidCase(@ApiParam(value = "Covid Case to save", required = true) @RequestBody CovidCases_District covidCases_district) {
        if(StringUtils.isEmpty(covidCases_district.getDistrict())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else
        if(StringUtils.isEmpty(districtService.getByDistrictName(covidCases_district.getDistrict().getDistrict()))) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        CovidCases_District covidCasesDistrict = covidCases_districtService.addCovidCase(covidCases_district);
        return new ResponseEntity<>(covidCasesDistrict, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{gkz}")
    @ApiOperation(value = "Get Covid Cases by a District Gkz", response = CovidCases_DistrictModel.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Request Successful"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    public ResponseEntity<List<CovidCases_District>> getCovidCasesByGkz(@ApiParam(value = "Covid Cases to get by District Gkz", required = true) @PathVariable Long gkz) {
        if(StringUtils.isEmpty(gkz.toString())) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        else if (covidCases_districtService.getAllByGkz(gkz).isEmpty()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(covidCases_districtService.getAllByGkz(gkz), HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation(value = "Get Covid Cases by a District Name", response = CovidCases_DistrictModel.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Request Successful"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    public ResponseEntity<List<CovidCases_District>> getCovidCasesByName(@ApiParam(value = "Covid Cases to get by District Name", required = true) @RequestParam(value = "district", required = false) String district) {
        List<CovidCases_District> covidCasesDistrictList = new ArrayList<>();

        if (StringUtils.isEmpty(district)) {
            covidCasesDistrictList.addAll(covidCases_districtService.getAllCases());
        } else
            covidCasesDistrictList.addAll(covidCases_districtService.getAllByDistrictName(district));

        if (covidCasesDistrictList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(covidCasesDistrictList, HttpStatus.OK);
    }
}
