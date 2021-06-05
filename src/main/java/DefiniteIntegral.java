public class DefiniteIntegral {
    private double a;
    private double b;
    private double epsilon;

    public DefiniteIntegral(double a, double b, double e){
        this.a=a;
        this.b=b;
        this.epsilon=e;
    }

    public double function(double x){
        return Math.pow(x,3)+x;
    }

    public double methodLeftRectanges(double h){
        double x,n, Ih, IhDividedBy2=0;
        do{
            Ih = IhDividedBy2;
            IhDividedBy2 =0;
            n=(b-a)/h;
            for(int i=0; i<n; i++){
                x = a+i*h;
                IhDividedBy2 +=function(x);
            }
            IhDividedBy2*=h;
            h/=2;
            if(Math.abs(IhDividedBy2-Ih)<epsilon){
                break;
            }
        }while(true);
        return IhDividedBy2;
    }

    public double trapeziumMethod(double h){
        double n,x,Ih, IhDividedBy2=0;
        do{
            Ih = IhDividedBy2;
            IhDividedBy2 =0;
            n=(b-a)/h;
            for(int i=1; i<n; i++){
                x = a+i*h;
                IhDividedBy2 +=function(x);
            }
            IhDividedBy2 += (function(a)+function(b))/2;
            IhDividedBy2*=h;
            h/=2;
            if(Math.abs(IhDividedBy2-Ih)<epsilon){
                break;
            }
        }while(true);
        return IhDividedBy2;
    }

    public double methodSimpson(double h){
        double n,  Ih, IhDividedBy2=0;
        do{
            Ih = IhDividedBy2;
            IhDividedBy2 =0;
            n=(b-a)/h;
            for(int i=1; i<n; i++){
                if(i%2==0){
                    IhDividedBy2 += 2*function(a+i*h);
                }else{
                    IhDividedBy2 += 4*function(a+i*h);
                }
            }
            IhDividedBy2+=function(a)+function(b);
            IhDividedBy2*=h/3;
            h/=2;
            if(Math.abs(IhDividedBy2-Ih)<epsilon){
                break;
            }
        }while(true);
        return IhDividedBy2;
    }

    public void print(String str, double val){
        System.out.printf("Определённый интеграл, найденный с помощью %s равен %.4f.\n", str, val);
    }
}
