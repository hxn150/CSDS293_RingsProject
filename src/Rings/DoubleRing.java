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
            throw new NullPointerException();
        }
        return x + y;
    }

    @Override
    public Double product(Double x, Double y) {
        if(x == null || y == null){
            throw new NullPointerException();
        }
        return x * y;
    }

    @Override
    public Double negate(Double x) {
        return x * -1.0;
    }
}
