package programmers.level2;

import java.math.BigInteger;

public class P2004_멀쩡한사각형 {
    public long solution(int w, int h) {
        int gcd = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).intValue();
        long totalSize = (long) w * (long) h;
        return (totalSize) - (((w / gcd) + (h / gcd) - 1) * gcd);
    }
}
