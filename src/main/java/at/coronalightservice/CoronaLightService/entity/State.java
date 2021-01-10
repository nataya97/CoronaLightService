package at.coronalightservice.CoronaLightService.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "STATE", uniqueConstraints = @UniqueConstraint(columnNames = {"state_Id", "state"}))
public class State {

    @Id
    @Column(name = "state_Id", nullable = false)
    private Long stateId;

    @Column(name = "state", nullable = false)
    private String state;

    @JsonIgnore
    @OneToMany(mappedBy = "state", cascade = CascadeType.MERGE)
    private List<District> district = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "state", cascade = CascadeType.ALL)
    private List<CovidCases_State> covidCases_State = new ArrayList<>();

    public State(Long stateId, String state) {
        this.stateId = stateId;
        this.state = state;
    }

    public State(Long stateId, String state, List<District> district) {
        this.stateId = stateId;
        this.state = state;
        this.district = district;
    }

    public State() { }

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
