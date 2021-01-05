package at.coronalightservice.CoronaLightService.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "COVIDCASES_STATE")
public class CovidCases_State implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private State state;

    @Column(name = "report_Date")
    private LocalDate reportDate;

    @Column(name = "test_Sum")
    private Long testSum;

    @Column(name = "fz_Hosp")
    private Long fzHosp;

    @Column(name = "fzICU")
    private Long fzICU;

    @Column(name = "fz_Hosp_Free")
    private Long fzHospFree;

    @Column(name = "fzICUFree")
    private Long fzICUFree;

    public CovidCases_State(State state, LocalDate reportDate, Long testSum, Long fzHosp, Long fzICU, Long fzHospFree, Long fzICUFree) {
        this.state = state;
        this.reportDate = reportDate;
        this.testSum = testSum;
        this.fzHosp = fzHosp;
        this.fzICU = fzICU;
        this.fzHospFree = fzHospFree;
        this.fzICUFree = fzICUFree;
    }

    public CovidCases_State() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDate reportDate) {
        this.reportDate = reportDate;
    }

    public Long getTestSum() {
        return testSum;
    }

    public void setTestSum(Long testSum) {
        this.testSum = testSum;
    }

    public Long getFzHosp() {
        return fzHosp;
    }

    public void setFzHosp(Long fzHosp) {
        this.fzHosp = fzHosp;
    }

    public Long getFzICU() {
        return fzICU;
    }

    public void setFzICU(Long fzICU) {
        this.fzICU = fzICU;
    }

    public Long getFzHospFree() {
        return fzHospFree;
    }

    public void setFzHospFree(Long fzHospFree) {
        this.fzHospFree = fzHospFree;
    }

    public Long getFzICUFree() {
        return fzICUFree;
    }

    public void setFzICUFree(Long fzICUFree) {
        this.fzICUFree = fzICUFree;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
