package at.coronalightservice.CoronaLightService.entity;

import javax.persistence.*;

@Entity
@Table(name = "COVIDCASES_DISTRICT")
public class CovidCases_District {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private District district;

    @Column(name = "number_Of_Residents")
    private Long numberOfResidents;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "number_Of_Deaths")
    private Long numberOfDeaths;

    @Column(name = "number_Of_Cases_Last_Seven_Days")
    private Long numberOfCasesLastSevenDays;

    public CovidCases_District(District district, Long numberOfResidents, Long amount, Long numberOfDeaths, Long numberOfCasesLastSevenDays) {
        this.district = district;
        this.numberOfResidents = numberOfResidents;
        this.amount = amount;
        this.numberOfDeaths = numberOfDeaths;
        this.numberOfCasesLastSevenDays = numberOfCasesLastSevenDays;
    }

    public CovidCases_District() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
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

    public Long getNumberOfCasesLastSevenDays() {
        return numberOfCasesLastSevenDays;
    }

    public void setNumberOfCasesLastSevenDays(Long numberOfCasesLastSevenDays) {
        this.numberOfCasesLastSevenDays = numberOfCasesLastSevenDays;
    }
}
