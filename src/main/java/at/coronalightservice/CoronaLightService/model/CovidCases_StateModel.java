package at.coronalightservice.CoronaLightService.model;

import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;

@ApiModel(value = "CovidCases_StateModel")
public class CovidCases_StateModel {

    @NotNull
    @ApiModelProperty(value = "Generated ID",
            dataType = "Long", example = "1")
    private Long id;

    @NotNull
    @ApiModelProperty(value = "state",
            dataType = "State")
    private String state;

    @NotNull
    @ApiModelProperty(value = "report_Date",
            dataType = "LocalDate")
    private LocalDate reportDate;

    @NotNull
    @ApiModelProperty(value = "test_Sum",
            dataType = "Long", example = "1")
    private Long testSum;

    @NotNull
    @ApiModelProperty(value = "fz_Hosp",
            dataType = "Long", example = "1")
    private Long fzHosp;

    @NotNull
    @ApiModelProperty(value = "fzICU",
            dataType = "Long", example = "1")
    private Long fzICU;

    @NotNull
    @ApiModelProperty(value = "fz_Hosp_Free",
            dataType = "Long", example = "1")
    private Long fzHospFree;

    @NotNull
    @ApiModelProperty(value = "fzICUFree",
            dataType = "Long", example = "1")
    private Long fzICUFree;

    public CovidCases_StateModel(Long id, String state, LocalDate reportDate, Long testSum, Long fzHosp, Long fzICU, Long fzHospFree, Long fzICUFree) {
        this.id = id;
        this.state = state;
        this.reportDate = reportDate;
        this.testSum = testSum;
        this.fzHosp = fzHosp;
        this.fzICU = fzICU;
        this.fzHospFree = fzHospFree;
        this.fzICUFree = fzICUFree;
    }

    public CovidCases_StateModel(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
}
