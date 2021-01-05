package at.coronalightservice.CoronaLightService.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "DISTRICT", uniqueConstraints = @UniqueConstraint(columnNames = {"gkz", "district",}))
public class District {

    @Column(name = "district", nullable = false)
    private String district;

    @Id
    private Long gkz;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.MERGE)
    private State state;

    @Column(name = "light_Status", length = 36)
    private String lightStatus;

    @JsonIgnore
    @OneToMany(mappedBy = "district", cascade = CascadeType.ALL)
    private List<CovidCases_District> covidCases_district = new ArrayList<>();

    public District(String district, Long gkz, State state) {
        this.district = district;
        this.gkz = gkz;
        this.state = state;
    }

    public District() { }

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

    public String getLightStatus() {
        return lightStatus;
    }

    public void setLightStatus(String lightStatus) {
        this.lightStatus = lightStatus;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {

        this.state = state;
    }

    public List<CovidCases_District> getCovidCases_district() {
        return covidCases_district;
    }

    public void setCovidCases_district(List<CovidCases_District> covidCases_district) {
        this.covidCases_district = covidCases_district;
    }
}
