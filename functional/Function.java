package sample.functional;

public class Function {
    public static double func(double x, double A) {
        if (x<=0) return func1(x);
        if (x>0 && x<=A) return func2(x);
        if (x>A) return func3(x);
        return 0;
    }
    private static double func1(double x) {
        return Math.pow(x, 5) * (1/Math.tan(2*Math.pow(x,3))); //ctan = 1/tan
    }
    private static double func2(double x) {
        return Math.pow((Math.pow(x,4)+3),1.0/5.0);
    }
    private static double func3(double x) {
        return Math.pow(Math.abs(Math.pow(Math.sin(x), 2) + 1), 2 * x);
    }
}
