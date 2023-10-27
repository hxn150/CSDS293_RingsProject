package Rings;

import java.util.List;
import java.util.Objects;
import java.util.function.BinaryOperator;

public final class Rings {
    public static <T> T reduce(List<T> args, T zero, BinaryOperator<T> accumulator) {
        return Objects. requireNonNull(args) .stream ()
                .reduce(Objects. requireNonNull (accumulator) ::apply)
                .orElse(Objects. requireNonNull(zero));
    }
    public static final <T> T sum(List<T> args, Ring<T> ring) {
        Objects.requireNonNull(args);
        Objects.requireNonNull(ring);

        return args.stream().reduce(ring.zero(), ring :: sum);
    }
    public static final <T> T product(List<T> args, Ring<T> ring) {
        Objects.requireNonNull(args);
        Objects.requireNonNull(ring);

        return args.stream().reduce(ring.identity(), ring :: product);
    }
//
//    public static final <T> List<T> negate(List<T> args, Ring<T> ring) {
//        Objects.requireNonNull(args);
//        Objects.requireNonNull(ring);
//
//        return args.stream()
//                .map(ring::negate) // Negate each element using the ring's negate method
//                .collect(Collectors.toList());
//    }
}


