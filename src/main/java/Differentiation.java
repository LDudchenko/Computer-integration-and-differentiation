public class Differentiation {
    private double epsilon;

    Differentiation(double e){
        this.epsilon = e;
    }

    public double function(double x){
        return Math.pow(x,3)+x;
    }

    public double methodSequenceOfIncrements(double x){
        int k=0;
        double d=0, dPrev,h;
        do{
            h=0.5/Math.pow(5,k);
            dPrev = d;
            d=(function(x+h)-function(x))/h;
            k++;
            if(Math.abs(d-dPrev)<epsilon){
                break;
            }
        }while(true);
        System.out.println("Количество итераций: "+k+'.');
        return d;
    }

    public double methodCentralDiffences(double x){
        int k=0;
        double d=0, dPrev,h;
        do{
            h=0.5/Math.pow(5,k);
            dPrev = d;
            d=(function(x+h)-function(x-h))/(2*h);
            k++;
            if(Math.abs(d-dPrev)<epsilon){
                break;
            }
        }while(true);
        System.out.println("Количество итераций: "+k+'.');
        return d;
    }

    public double methodQuadraticInterpolation(double[] x, double[] y, double xValue){
        double h = x[1]-x[0];
        double deltaYfirstOrder = finalDifferences(y,1);
        double deltaYSecondOrder = finalDifferences(y,2);
        double q = (xValue-x[0])/h;
        return 1/h*(deltaYfirstOrder+(2*q-1)/2*deltaYSecondOrder);

    }

    public static double finalDifferences(double[] arr, int rate){
        if(rate == 0){
            return arr[0];
        }
        else{
            double[] finalDifferences = new double[rate];
            for(int i=0; i<rate; i++){
                finalDifferences[i] = arr[i+1] - arr[i];
            }
            return finalDifferences(finalDifferences, rate -1);
        }
    }

    public void print(String str, double x, double val){
        System.out.printf("Производная в точке %.4f, найденная с помощью %s равна %.4f.\n", x, str, val);
    }
}
