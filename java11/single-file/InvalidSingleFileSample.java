
class Maths{

    public static double simpleInterest(int principal, int rate, int period){
        return ( principal * rate * period * 1.0 ) / 100;
    }
}
public class InvalidSingleFileSample{
    public static void main(String[] args){
        if ( args == null || args.length < 3 ){
            System.err.println("Three arguments required: principal, rate, period");
            System.exit(1);
        }
        int principal = Integer.parseInt(args[0]);
        int rate = Integer.parseInt(args[1]);
        int period = Integer.parseInt(args[2]);
        double interest = Maths.simpleInterest(principal, rate, period);
        System.out.print("Simple Interest is: " + interest);
    }
}
