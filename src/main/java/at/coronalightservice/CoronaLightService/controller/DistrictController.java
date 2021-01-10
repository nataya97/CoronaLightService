package at.coronalightservice.CoronaLightService.controller;

import at.coronalightservice.CoronaLightService.entity.District;
import at.coronalightservice.CoronaLightService.model.DistrictModel;
import at.coronalightservice.CoronaLightService.service.DistrictService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "District Endpoint")
@SwaggerDefinition(tags = {
        @Tag(name = "District Endpoint", description = "Der Enpoint, um die District Daten abzufragen")
})
@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/district")
public class DistrictController {

    @Autowired
    DistrictService districtService;

    @PutMapping
    @ApiOperation(value = "Update existing District", response = DistrictModel.class)
    @ApiResponses({
            @ApiResponse(code = 201, message = "Creation Successful"),
            @ApiResponse(code = 400, message = "Bad Request"),
    })
    public ResponseEntity<District> updateDistrict(@ApiParam(value = "District to save", required = true) @RequestBody District district) {
        if(StringUtils.isEmpty(district.getDistrict())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(districtService.addDistrict(district), HttpStatus.CREATED);
    }

    @PostMapping
    @ApiOperation(value = "Add a District", response = DistrictModel.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Creation Successful"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    public ResponseEntity<District> addDistrict(@ApiParam(value = "District to save", required = true) @RequestBody District district) {
        if(StringUtils.isEmpty(district.getDistrict())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(districtService.addDistrict(district), HttpStatus.CREATED);
    }

    @GetMapping
    @ApiOperation(value = "Get a District by State", response = DistrictModel.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Request Successful"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    public ResponseEntity<List<District>> getDistrictByState(@ApiParam(value = "District to get by State, if no State specified, get all Districts", required = true) @RequestParam(value = "state", required = false) String state) {
        List<District> districtList = new ArrayList<>();

        if(StringUtils.isEmpty(state)) {
            districtList.addAll(districtService.getAllDistricts());
        } else
            districtList.addAll(districtService.getAllByState(state));

        if(districtList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(districtList, HttpStatus.OK);
    }

    @GetMapping(value = "/{gkz}")
    @ApiOperation(value = "Get a District by GKZ", response = DistrictModel.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Request Successful"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    public ResponseEntity<District> getDistrictByGkz(@ApiParam(value = "District to get by GKZ", required = true) @PathVariable("gkz") Long gkz) {
        if(StringUtils.isEmpty(gkz.toString())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else
            if(StringUtils.isEmpty(districtService.getByGkz(gkz).getDistrict())) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        return new ResponseEntity<>(districtService.getByGkz(gkz), HttpStatus.OK);
    }

    @GetMapping(params = "name")
    @ApiOperation(value = "Get a District by Name", response = DistrictModel.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Request Successful"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found"),
    })
    public ResponseEntity<District> getDistrictByName(@ApiParam(value = "District to get by Name", required = true) @RequestParam("name") String name) {
        if(StringUtils.isEmpty(name)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else
            if(StringUtils.isEmpty(districtService.getByDistrictName(name).getDistrict())) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        return new ResponseEntity<>(districtService.getByDistrictName(name), HttpStatus.OK);
    }
}
