package eu.rm.knn.structure;

import com.google.common.collect.Streams;
import javafx.util.Pair;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Stream;

public interface Sample<T extends Sample, U extends Enum<U>>
{
    U getClassByName(String className);

    U getSampleClass();

    BigDecimal[] getNumericFeatureValues();

    default BigDecimal getDistance(T t){

        Stream<BigDecimal> streamA = Arrays.stream(getNumericFeatureValues());
        Stream<BigDecimal> streamB = Arrays.stream(t.getNumericFeatureValues());
        return Streams.zip(
                streamA,streamB,
                (a, b) -> a.subtract(b).abs()).reduce(BigDecimal.ZERO, (a, b) -> a.add(b))
                ;
    };



    default U classifySample(List<T> trainData, int knnSize){

        List<Pair<BigDecimal, U>> distances = new ArrayList<>(trainData.size());

        for(T t : trainData){
            distances.add(new Pair(this.getDistance(t), t.getSampleClass()));
        }
        distances.sort(Comparator.comparing(Pair::getKey));

        // count neirest
        Map<U, Integer> nearestNeighborsClassCounter = new HashMap<>();
        for(int i = 0; i<knnSize; i++){
            U neighborClass = distances.get(i).getValue();
            Integer neighborClassSize = nearestNeighborsClassCounter.get(neighborClass);
            if(neighborClassSize==null){
                neighborClassSize = 0;
            }
            nearestNeighborsClassCounter.put(neighborClass, neighborClassSize+1);
        }

        // extract max
        U higherClass = null;
        int max = -1;
        for(U currClass : nearestNeighborsClassCounter.keySet()){
            Integer currClassSize = nearestNeighborsClassCounter.get(currClass);
            if(currClassSize>max || higherClass==null ){
                higherClass = currClass;
                max = currClassSize;
            }
        }
        return higherClass;

    };

}