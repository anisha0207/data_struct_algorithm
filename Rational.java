public class Rational extends Number {
    private int numerator;
    private int denominator;

    public Rational(){
        this(0,1);
    }
    /**
     * @param n
     * @param d
     */
    public Rational(int n, int d){
        this.numerator = n;
        this.denominator = d;
        this.reduce();
    }
    public int getNumerator(){//getter method for numerator
        return this.numerator;
    }
    public int getDenominator(){//getter method for denominator
        return this.denominator;
    }
    public void setNumerator(int n){//setter method for numerator
        this.numerator = n;
    }
    public void setDenominator(int d){//setter method for denominator
        this.denominator = d;
    }
    @Override
    public String toString(){//string method that will format the print system of the fractions with conditionals
        if (denominator == 1){//if fraction has 1 as the denominator
            return String.valueOf(numerator);
        }else if (numerator == 0){//if numerator is 0
            return "0";
        }else if (denominator < 0){//if denominator is less than 0, format it where negative value is in numerator
            return String.format("-" + numerator+ "/"+denominator);
        }else if (numerator == denominator){//if numerator and denominator is equal
            return "1";
        }
        return String.format(numerator+"/"+denominator);
    }
    public Rational add(Rational r){//add fractions where we find the common factor by first multiplying denominators and multiplying its factor with numerator to match the fractions
        int d = this.denominator * r.denominator;
        int n = (this.numerator * r.denominator) + (this.denominator * r.numerator);
        Rational sum = new Rational(n,d);
        sum.reduce();
        return sum; 
    }
    public Rational sub(Rational r){//same method as the addition, but this time you subtract at the end
        int d = this.denominator * r.denominator;
        int n = (this.numerator * r.denominator) - (this.denominator * r.numerator);
        Rational difference = new Rational(n,d);
        difference.reduce();
        return difference;
    }
    public Rational mult(Rational r){//multiply the fractions as is with denominator to denominator and numerator to numerator
        int d = this.denominator * r.denominator;
        int n = this.numerator * r.numerator;
        Rational product = new Rational(n,d);
        product.reduce();
        return product;
    }
    public Rational div(Rational r){//divide using denominator of one fraction multiplying with numerator of another fractions, and then interchange vice-versa
        int d = this.denominator * r.numerator;
        int n = this.numerator * r.denominator;
        if ( d == 0){
            return new Rational (0,1);
        }
        Rational quotient = new Rational(n,d);
        quotient.reduce();
        return quotient;
    }
    private int gcd(int m, int n){//Euclid’s GCD Recursive Algorithm (the oldest known GCD algorithm)
            //Time(n) = logn *const = O(log n)
        if (m%n == 0){
            return n;
        }else{
            return gcd(n, m %n);
        }
    }
    private void reduce(){//reduce the fraction in it's simplified form by using gcd method to divide with the numerator and denominator
        int g = gcd(numerator, denominator);
        denominator /= g;
        numerator /= g;

    }
    @Override
    public int intValue(){//stores int value
        return (int) numerator / denominator;
    }
    @Override
    public long longValue(){//stores long value
        return (long) numerator / denominator;
    }
    @Override
    public float floatValue(){//stores float value
        return (float) numerator / denominator;
    }
    @Override
    public double doubleValue(){//stores double value
        return (double) numerator / denominator;
    }
    public boolean equals(Object o){//object comapres using cmoparison to find equal within numerator and denominator of one fraction to the other
        if (o instanceof Rational){
            Rational r = (Rational) o;
            return this.numerator == r.numerator && this.denominator == r.denominator;
        }
        return false;
    }
}