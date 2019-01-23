package Chapter1.Section2;

import edu.princeton.cs.algs4.StdOut;

public final class Rational {

    public long numerator;   // 分子
    public long denominator;  // 分母

    public Rational(long numerator, long denominator) {
        this.numerator = numerator/gcd(numerator, denominator);
        this.denominator = denominator/gcd(numerator, denominator);
    }

    long gcd(long a, long b) {
        long tmp = a%b;
        if (tmp == 0) {
            return b;
        } else {
            a = b;
            b = tmp;
            return gcd(a, b);
        }
    }

    Rational plus(Rational b) {
        return new Rational(this.numerator*b.denominator+b.numerator*this.denominator, this.denominator*b.denominator);
    }

    Rational minus(Rational b) {
        return new Rational(this.numerator*b.denominator-b.numerator*this.denominator, this.denominator*b.denominator);
    }

    Rational times(Rational b) {
        return new Rational(this.numerator*b.numerator, this.denominator*b.denominator);
    }

    Rational divides(Rational b) {
        return new Rational(this.numerator*b.denominator, this.denominator*b.numerator);
    }

    boolean equals(Rational that) {
        if (this.numerator == that.numerator && this.denominator == that.denominator) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Rational{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }

    public static void main(String[] args) {
        Rational r = new Rational(3, 8);
        Rational x = new Rational(4, 8);
        StdOut.println(r);
        StdOut.println(x);
        StdOut.println(r.plus(x));
        StdOut.println(r.minus(x));
        StdOut.println(r.times(x));
        StdOut.println(r.divides(x));
    }
}
