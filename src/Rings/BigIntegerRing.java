package Rings;

//import Matrix.MatrixMap;

import java.math.BigInteger;
import java.util.function.Function;

public class BigIntegerRing implements Ring<BigInteger> {

    @Override
    public BigInteger zero() {
        return new BigInteger("0");
    }

    @Override
    public BigInteger identity() {
        return new BigInteger("1");
    }

    @Override
    public BigInteger sum(BigInteger x, BigInteger y) {
        if(x == null || y == null){
            throw new IllegalArgumentException("Inputs are null");
        }
        return x.add(y);
    }

    @Override
    public BigInteger product(BigInteger x, BigInteger y) {
        if(x == null || y == null){
            throw new IllegalArgumentException("Inputs are null");
        }
        return x.multiply(y);
    }

    @Override
    public BigInteger negate(BigInteger x) {
        return x.negate();
    }


}
