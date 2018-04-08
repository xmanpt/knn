package eu.rm.knn.structure;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public interface Dataset<T extends Sample> {

    String getDatasetPath();

    List<T> getDataset();

    T createSampleFromString(String sampleData);

    default void loadDataset() throws IOException{
        try (Stream<String> stream = Files.lines(Paths.get(getDatasetPath()))) {
            stream.forEach( line -> getDataset().add(createSampleFromString(line)) );
        }
    };



}
