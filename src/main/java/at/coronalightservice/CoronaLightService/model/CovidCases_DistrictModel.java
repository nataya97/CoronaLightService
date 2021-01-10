package at.coronalightservice.CoronaLightService.model;

import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "CovidCases_DistrictModel")
public class CovidCases_DistrictModel {

    @NotNull
    @ApiModelProperty(value = "Generated ID",
            dataType = "Long")
    private Long id;

    @NotNull
    @ApiModelProperty(value = "district",
            dataType = "District")
    private String district;

    @NotNull
    @ApiModelProperty(value = "number_Of_Residents",
            dataType = "Long")
    private Long numberOfResidents;

    @NotNull
    @ApiModelProperty(value = "amount",
            dataType = "Long")
    private Long amount;

    @NotNull
    @ApiModelProperty(value = "number_Of_Deaths",
            dataType = "Long")
    private Long numberOfDeaths;

    @NotNull
    @ApiModelProperty(value = "number_Of_Cases_Last_Seven_Days",
            dataType = "Long")
    private Long numberOfCasesLastSevenDays;

    public CovidCases_DistrictModel(){

    }
    public CovidCases_DistrictModel(Long id, String district, Long numberOfResidents, Long amount, Long numberOfDeaths, Long numberOfCasesLastSevenDays) {
        this.id = id;
        this.district = district;
        this.numberOfResidents = numberOfResidents;
        this.amount = amount;
        this.numberOfDeaths = numberOfDeaths;
        this.numberOfCasesLastSevenDays = numberOfCasesLastSevenDays;
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

    public Long getNumberOfResidents() {
        return numberOfResidents;
    }

    public void setNumberOfResidents(Long numberOfResidents) {
        this.numberOfResidents = numberOfResidents;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getNumberOfDeaths() {
        return numberOfDeaths;
    }

    public void setNumberOfDeaths(Long numberOfDeaths) {
        this.numberOfDeaths = numberOfDeaths;
    }

    public Long numberOfCasesLastSevenDays() {
        return numberOfCasesLastSevenDays;
    }

    public void numberOfCasesLastSevenDays(Long numberOfCasesLastSevenDays) {
        this.numberOfCasesLastSevenDays = numberOfCasesLastSevenDays;
    }
}
