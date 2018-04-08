package eu.rm.knn.car;


import eu.rm.knn.structure.Dataset;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CarsDataset implements Dataset<CarsSample> {

    private static final String DATASET_PATH = System.getProperty("user.dir") + "/src/main" + "/resources/cardata.txt";

    private List<CarsSample> dataset = new ArrayList<>();

    public List<CarsSample> getDataset() {
        return dataset;
    }


    @Override
    public CarsSample createSampleFromString(String sampleData) {
        String[] split = sampleData.split(",");
        CarsSample sample = new CarsSample();

        //buying       v-high, high, med, low
        switch (split[0]) {
            case "vhigh" : sample.setBuying(new BigDecimal(3)); break;
            case "high" : sample.setBuying(new BigDecimal(2));break;
            case "med" : sample.setBuying(BigDecimal.ONE);break;
            case "low" : sample.setBuying(BigDecimal.ZERO);break;
        }

        // maint        v-high, high, med, low
        switch (split[1]) {
            case "vhigh" : sample.setMaint(new BigDecimal(3));break;
            case "high" : sample.setMaint(new BigDecimal(2));break;
            case "med" : sample.setMaint(BigDecimal.ONE);break;
            case "low" : sample.setMaint(BigDecimal.ZERO);break;
        }

        //doors        2, 3, 4, 5-more
        switch (split[2]) {
            case "2" : sample.setDoors(new BigDecimal(3));break;
            case "3" : sample.setDoors(new BigDecimal(2));break;
            case "4" : sample.setDoors(BigDecimal.ONE);break;
            case "5more" : sample.setDoors(BigDecimal.ZERO);break;
        }

        //persons      2, 4, more
        switch (split[3]) {
            case "2" : sample.setPersons(new BigDecimal(2));break;
            case "4" : sample.setPersons(BigDecimal.ONE);break;
            case "more" : sample.setPersons(BigDecimal.ZERO);break;
        }

        //lug_boot     small, med, big
        switch (split[4]) {
            case "small" : sample.setLug_boot(new BigDecimal(2));break;
            case "med" : sample.setLug_boot(BigDecimal.ONE);break;
            case "big" : sample.setLug_boot(BigDecimal.ZERO);break;
        }

        //safety       low, med, high
        switch (split[5]) {
            case "low" : sample.setSafety(new BigDecimal(2));break;
            case "med" : sample.setSafety(BigDecimal.ONE);break;
            case "high" : sample.setSafety(BigDecimal.ZERO);break;
        }

        sample.setSampleClass(sample.getClassByName(split[6]));

        if (sample.getBuying() == null || sample.getMaint() == null || sample.getDoors() == null ||
            sample.getPersons() == null || sample.getLug_boot() == null || sample.getSafety() == null ||
            sample.getSampleClass() == null) {
            throw new RuntimeException("Car not read " + sample);
        }


        return sample;
    }


    @Override
    public String getDatasetPath() {
        return DATASET_PATH;
    }

}
