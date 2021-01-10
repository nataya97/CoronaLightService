package at.coronalightservice.CoronaLightService.model;

import at.coronalightservice.CoronaLightService.entity.District;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

@ApiModel(value = "DistrictModel")
public class DistrictModel {

    @NotNull
    @ApiModelProperty(value = "Generated ID",
            dataType = "Long")
    private Long id;

    @NotNull
    @ApiModelProperty(value = "district",
            dataType = "String")
    private String district;

    @NotNull
    @ApiModelProperty(value = "gkz",
            dataType = "Long")
    private Long gkz;

    @NotNull
    @ApiModelProperty(value = "state",
            dataType = "State")
    private String state;

    @ApiModelProperty(value = "List of districts",
            dataType = "List<CovidCases_District>")
    private List<District> covidCases_district = new ArrayList<>();

    public DistrictModel(){

    }

    public DistrictModel(Long id, String district, Long gkz, String state, List<District> covidCases_district) {
        this.id = id;
        this.district = district;
        this.gkz = gkz;
        this.state = state;
        this.covidCases_district = covidCases_district;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Long getGkz() {
        return gkz;
    }

    public void setGkz(Long gkz) {
        this.gkz = gkz;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<District> getCovidCases_district() {
        return covidCases_district;
    }

    public void setCovidCases_district(List<District> covidCases_district) {
        this.covidCases_district = covidCases_district;
    }
}
