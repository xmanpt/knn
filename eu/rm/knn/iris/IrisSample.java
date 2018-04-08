package eu.rm.knn.iris;

import eu.rm.knn.structure.Sample;

import java.math.BigDecimal;
import java.util.List;

public class IrisSample implements Sample<IrisSample, IrisClass> {

    private BigDecimal sepalLength;
    private BigDecimal sepalWidth;
    private BigDecimal petalLength;
    private BigDecimal petalWidth;
    private IrisClass sampleClass;

    @Override
    public IrisClass getClassByName(String className) {
        switch (className) {
            case "Iris-setosa": return IrisClass.SETOSA;
            case "Iris-versicolor": return IrisClass.VERSICOLOR;
            case "Iris-virginica": return IrisClass.VIRGINICA;
        }
        return null;
    }

    @Override
    public BigDecimal[] getNumericFeatureValues() {
        return new BigDecimal[]{
                getSepalLength(),
                getSepalWidth(),
                getPetalLength(),
                getPetalWidth()
        };
    }

    public BigDecimal getSepalLength() {
        return sepalLength;
    }

    public void setSepalLength(BigDecimal sepalLength) {
        this.sepalLength = sepalLength;
    }

    public BigDecimal getSepalWidth() {
        return sepalWidth;
    }

    public void setSepalWidth(BigDecimal sepalWidth) {
        this.sepalWidth = sepalWidth;
    }

    public BigDecimal getPetalLength() {
        return petalLength;
    }

    public void setPetalLength(BigDecimal petalLength) {
        this.petalLength = petalLength;
    }

    public BigDecimal getPetalWidth() {
        return petalWidth;
    }

    public void setPetalWidth(BigDecimal petalWidth) {
        this.petalWidth = petalWidth;
    }

    public IrisClass getSampleClass() {
        return sampleClass;
    }

    public void setSampleClass(IrisClass sampleClass) {
        this.sampleClass = sampleClass;
    }

    @Override
    public String toString() {
        return "IrisSample{" + "sepalLength=" + sepalLength + ", sepalWidth=" + sepalWidth + ", petalLength=" +
               petalLength + ", petalWidth=" + petalWidth + ", sampleClass=" + sampleClass + '}';
    }
}
