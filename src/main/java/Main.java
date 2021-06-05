import org.apache.commons.math3.analysis.integration.SimpsonIntegrator;
import org.apache.commons.math3.analysis.integration.TrapezoidIntegrator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание №1");
        Differentiation ob1 = new Differentiation(0.001);
        double val;
        double exactValue = 13;
        val = ob1.methodSequenceOfIncrements(2);
        ob1.print("последовательности приростов", 2, val);
        compareValues(val,exactValue);
        System.out.println();
        val = ob1.methodCentralDiffences(2);
        ob1.print("центрованой разности", 2, val);
        compareValues(val, exactValue);
        System.out.println();

        System.out.println("Задание №2");
        val = ob1.methodQuadraticInterpolation(new double[]{1,2.5,4}, new double[]{2,18.125, 68}, 2);
        ob1.print("квадратичной интерполяции", 2, val);
        compareValues(val, exactValue);
        System.out.println();

        System.out.println("Задание №3");
        exactValue = 71.25;
        DefiniteIntegral ob3 = new DefiniteIntegral(1,4, 0.001);
        double res = ob3.methodLeftRectanges(0.5);
        ob3.print("метода левых прямоугольников", res);
        compareValues(res, exactValue);
        double res1 = ob3.trapeziumMethod(0.5);
        ob3.print("метода трапеций", res1);
        compareValues(res1, exactValue);
        double res2 = ob3.methodSimpson(0.5);
        ob3.print("метода Симпсона", res2);
        compareValues(res2, exactValue);
    }

    public static void compareValues(double val1, double val2){
        System.out.printf("Разница значений равна %.4f.\n",Math.abs(val1 -val2));
    }
}
