package at.coronalightservice.CoronaLightService.model;

import at.coronalightservice.CoronaLightService.entity.CovidCases_State;
import at.coronalightservice.CoronaLightService.entity.District;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

@ApiModel(value = "StateModel")
public class StateModel {

    @NotNull
    @ApiModelProperty(value = "Generated ID",
    dataType = "Long")
    private Long id;

    @NotNull
    @ApiModelProperty(value = "State_Id",
    dataType = "Long")
    private Long stateId;

    @NotNull
    @ApiModelProperty(value = "State",
    dataType = "String")
    private String state;

    @ApiModelProperty(value = "List of districts",
    dataType = "List<District>")
    private List<District> district = new ArrayList<>();

    @ApiModelProperty(value = "List of Covid Cases",
    dataType = "List<CovidCases_State>")
    private List<CovidCases_State> covidCases_State = new ArrayList<>();

    public StateModel() {
    }

    public StateModel(Long stateId, String state, List<District> district,
                      List<CovidCases_State> covidCases_State) {
        this.stateId = stateId;
        this.state = state;
        this.district = district;
        this.covidCases_State = covidCases_State;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<District> getDistrict() {
        return district;
    }

    public void setDistrict(List<District> district) {
        this.district = district;
    }

    public List<CovidCases_State> getCovidCases_State() {
        return covidCases_State;
    }

    public void setCovidCases_State(List<CovidCases_State> covidCases_State) {
        this.covidCases_State = covidCases_State;
    }
}
