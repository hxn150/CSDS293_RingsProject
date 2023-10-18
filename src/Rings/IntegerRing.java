package Rings;

public class IntegerRing implements Ring<Integer> {

    @Override
    public Integer zero() {
        return 0;
    }

    @Override
    public Integer identity() {
        return 1;
    }

    @Override
    public Integer sum(Integer x, Integer y) {
        if(x == null || y == null){
            throw new NullPointerException();
        }
        return x + y;
    }

    @Override
    public Integer product(Integer x, Integer y) {
        if(x == null || y == null) {
            throw new NullPointerException();
        }
        return x * y;
    }

    @Override
    public Integer negate(Integer x) {
        return x * -1;
    }
}
