package at.coronalightservice.CoronaLightService.misc;

import at.coronalightservice.CoronaLightService.controller.CovidCases_DistrictController;
import at.coronalightservice.CoronaLightService.controller.CovidCases_StateController;
import at.coronalightservice.CoronaLightService.controller.DistrictController;
import at.coronalightservice.CoronaLightService.controller.StateController;
import at.coronalightservice.CoronaLightService.entity.CovidCases_District;
import at.coronalightservice.CoronaLightService.entity.CovidCases_State;
import at.coronalightservice.CoronaLightService.entity.District;
import at.coronalightservice.CoronaLightService.entity.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class CSVReader {

    /*CSV has to conform to a scpecific outline to be read...*/

    @Autowired
    DistrictController districtController;


    @Bean
    private void readCovidFallzahlen() throws IOException {
        BufferedInputStream inputStream = new BufferedInputStream(new URL("https://covid19-dashboard.ages.at/data/CovidFallzahlen.csv").openStream());
        FileOutputStream fileOutputStream = new FileOutputStream("CovidFallzahlen.csv");

        int i;

        while ((i = inputStream.read()) != -1) {
            fileOutputStream.write(i);
        }
    }

    @Autowired
    StateController stateController;

    @Autowired
    CovidCases_StateController covidCases_stateController;

    @Bean
    private void getStates() throws IOException {
        com.opencsv.CSVReader reader = new com.opencsv.CSVReader(new FileReader("CovidFallzahlen.csv"));
        reader.skip(1);

        String[] entries;
        String[] splitEntries;
        int i = 0;
        int j = 0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");


        while ((entries = reader.readNext()) != null) {
            splitEntries = entries[i].split(";");
            State state = new State(Long.parseLong(splitEntries[7]), splitEntries[8]);
            if(stateController.getStateByName(state.getState()).getStatusCode().value() != 200) { // Response OK
                stateController.addState(state);
            }

            if(j >= 2500) {  //only persist the newer data
                covidCases_stateController.addCovidCase(new CovidCases_State(stateController.getStateById(state.getStateId()).getBody(), LocalDate.parse(splitEntries[0], formatter), Long.parseLong(splitEntries[1]),
                        Long.parseLong(splitEntries[3]), Long.parseLong(splitEntries[4]), Long.parseLong(splitEntries[5]), Long.parseLong(splitEntries[6])));
            }
            j++;
        }

    }

    @Bean
    private void readCovidFaelle_District() throws IOException {
        BufferedInputStream inputStream = new BufferedInputStream(new URL("https://covid19-dashboard.ages.at/data/CovidFaelle_GKZ.csv").openStream());
        FileOutputStream fileOutputStream = new FileOutputStream("CovidFaelle_GKZ.csv");

        int i;

        while ((i = inputStream.read()) != -1) {
            fileOutputStream.write(i);
        }

        this.getDistricts();
    }

    @Autowired
    CovidCases_DistrictController covidCases_districtController;

    private void getDistricts() throws IOException {
        com.opencsv.CSVReader reader = new com.opencsv.CSVReader(new FileReader("CovidFaelle_GKZ.csv"));
        reader.skip(1);

        String[] entries;
        String[] splitEntries;
        int i = 0;

        while ((entries = reader.readNext()) != null) {
            splitEntries = entries[i].split(";");
            State state = stateController.getStateById(Long.parseLong(String.valueOf(splitEntries[1].charAt(0)))).getBody();
            District district = new District(splitEntries[0], Long.parseLong(splitEntries[1]), state);
            if(districtController.getDistrictByState(district.getDistrict()).getStatusCode().value() != 200) {
                districtController.addDistrict(district);
            }
            covidCases_districtController.addCovidCase(new CovidCases_District(districtController.getDistrictByGkz(Long.parseLong(splitEntries[1])).getBody(), Long.parseLong(splitEntries[2]), Long.parseLong(splitEntries[3]),
                    Long.parseLong(splitEntries[4]), Long.parseLong(splitEntries[5])));
        }
    }
}
