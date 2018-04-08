package eu.rm.knn.car;

import eu.rm.knn.structure.Sample;

import java.math.BigDecimal;

public class CarsSample implements Sample<CarsSample, CarsClass> {

    private BigDecimal buying;
    private BigDecimal maint;
    private BigDecimal doors;
    private BigDecimal persons;
    private BigDecimal lug_boot;
    private BigDecimal safety;
    
    private CarsClass sampleClass;


    @Override
    public CarsClass getClassByName(String className) {
        switch (className) {
            case "unacc": return CarsClass.UNACC;
            case "acc": return CarsClass.ACC;
            case "good": return CarsClass.GOOD;
            case "vgood": return CarsClass.VGOOD;
        }
        return null;
    }

    @Override
    public BigDecimal[] getNumericFeatureValues() {
        return new BigDecimal[]{
                getBuying(),
                getMaint(),
                getDoors(),
                getPersons(),
                getLug_boot(),
                getSafety()
        };
    }

    public BigDecimal getBuying() {
        return buying;
    }

    public void setBuying(BigDecimal buying) {
        this.buying = buying;
    }

    public BigDecimal getMaint() {
        return maint;
    }

    public void setMaint(BigDecimal maint) {
        this.maint = maint;
    }

    public BigDecimal getDoors() {
        return doors;
    }

    public void setDoors(BigDecimal doors) {
        this.doors = doors;
    }

    public BigDecimal getPersons() {
        return persons;
    }

    public void setPersons(BigDecimal persons) {
        this.persons = persons;
    }

    public BigDecimal getLug_boot() {
        return lug_boot;
    }

    public void setLug_boot(BigDecimal lug_boot) {
        this.lug_boot = lug_boot;
    }

    public BigDecimal getSafety() {
        return safety;
    }

    public void setSafety(BigDecimal safety) {
        this.safety = safety;
    }

    @Override
    public CarsClass getSampleClass() {
        return sampleClass;
    }

    public void setSampleClass(CarsClass sampleClass) {
        this.sampleClass = sampleClass;
    }

    @Override
    public String toString() {
        return "CarsSample{" + "buying=" + buying + ", maint=" + maint + ", doors=" + doors + ", persons=" + persons +
               ", lug_boot=" + lug_boot + ", safety=" + safety + ", sampleClass=" + sampleClass + '}';
    }
}
