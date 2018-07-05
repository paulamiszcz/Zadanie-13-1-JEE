public class MetryCalculator {
    public double metryNaCenty(double metry){
        return metry*100;
    }

    public double metryNaMili(double metry){
        return metry*1000;
    }

    public double centyNaMetry(double centymetry) {
        return centymetry*0.01;
    }

    public double centyNaMili(double centymetry) {
        return centymetry*10;
    }

    public double miliNaMetry(double milimetry) {
        return milimetry*0.001;
    }

    public double miliNaCenty(double milimetry) {
        return milimetry*0.1;
    }
}
