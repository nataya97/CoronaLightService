package at.coronalightservice.CoronaLightService.entity;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "COVIDCASES_TIMELINE")
public class CovidCases_Timeline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private State state;

    @Column(name = "point_Of_Time")
    private LocalDateTime pointOfTime;

    @Column(name = "number_Of_Cases")
    private Long numberOfCases;

    @Column(name = "number_Of_Cases_Sum")
    private Long numberOfCasesSum;

    @Column(name = "number_Of_Cases_Last_Seven_Days")
    private Long numberOfCasesLastSevenDays;

    @Column(name = "number_Of_Cases_Daily")
    private Long numberOfCasesDaily;

    @Column(name = "number_Of_Cases_Dead_Sum")
    private Long numberOfCasesDeadSum;

    @Column(name = "number_Of_Cases_Cured_Daily")
    private Long numberOfCasesCuredDaily;

    @Column(name = "number_Of_Cases_Cured_Sum")
    private Long numberOfCasesCuredSum;

    public CovidCases_Timeline(State state, LocalDateTime pointOfTime, Long numberOfCases, Long numberOfCasesSum, Long numberOfCasesLastSevenDays,
                               Long numberOfCasesDaily, Long numberOfCasesDeadSum, Long numberOfCasesCuredDaily, Long numberOfCasesCuredSum) {
        this.state = state;
        this.pointOfTime = pointOfTime;
        this.numberOfCases = numberOfCases;
        this.numberOfCasesSum = numberOfCasesSum;
        this.numberOfCasesLastSevenDays = numberOfCasesLastSevenDays;
        this.numberOfCasesDaily = numberOfCasesDaily;
        this.numberOfCasesDeadSum = numberOfCasesDeadSum;
        this.numberOfCasesCuredDaily = numberOfCasesCuredDaily;
        this.numberOfCasesCuredSum = numberOfCasesCuredSum;
    }

    public CovidCases_Timeline() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getPointOfTime() {
        return pointOfTime;
    }

    public void setPointOfTime(LocalDateTime pointOfTime) {
        this.pointOfTime = pointOfTime;
    }

    public Long getNumberOfCases() {
        return numberOfCases;
    }

    public void setNumberOfCases(Long numberOfCases) {
        this.numberOfCases = numberOfCases;
    }

    public Long getNumberOfCasesSum() {
        return numberOfCasesSum;
    }

    public void setNumberOfCasesSum(Long numberOfCasesSum) {
        this.numberOfCasesSum = numberOfCasesSum;
    }

    public Long getNumberOfCasesLastSevenDays() {
        return numberOfCasesLastSevenDays;
    }

    public void setNumberOfCasesLastSevenDays(Long numberOfCasesLastSevenDays) {
        this.numberOfCasesLastSevenDays = numberOfCasesLastSevenDays;
    }

    public Long getNumberOfCasesDaily() {
        return numberOfCasesDaily;
    }

    public void setNumberOfCasesDaily(Long numberOfCasesDaily) {
        this.numberOfCasesDaily = numberOfCasesDaily;
    }

    public Long getNumberOfCasesDeadSum() {
        return numberOfCasesDeadSum;
    }

    public void setNumberOfCasesDeadSum(Long numberOfCasesDeadSum) {
        this.numberOfCasesDeadSum = numberOfCasesDeadSum;
    }

    public Long getNumberOfCasesCuredDaily() {
        return numberOfCasesCuredDaily;
    }

    public void setNumberOfCasesCuredDaily(Long numberOfCasesCuredDaily) {
        this.numberOfCasesCuredDaily = numberOfCasesCuredDaily;
    }

    public Long getNumberOfCasesCuredSum() {
        return numberOfCasesCuredSum;
    }

    public void setNumberOfCasesCuredSum(Long numberOfCasesCuredSum) {
        this.numberOfCasesCuredSum = numberOfCasesCuredSum;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
