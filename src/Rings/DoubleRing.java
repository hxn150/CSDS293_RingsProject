package Rings;

public class DoubleRing implements Ring<Double> {

    @Override
    public Double zero() {
      return 0.0;
    }

    @Override
    public Double identity() {
        return 1.0;
    }
    @Override
    public Double sum(Double x, Double y) {
        if(x == null || y == null){
            throw new IllegalArgumentException("Inputs are null");
        }
        return x + y;
    }

    @Override
    public Double product(Double x, Double y) {
        if(x == null || y == null){
            throw new IllegalArgumentException("Inputs are null");
        }
        return x * y;
    }
}
