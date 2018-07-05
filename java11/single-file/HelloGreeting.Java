public class Greeting{
    public static void main(String[] args){
        if ( args == null || args.length < 1 ){
            System.err.println("Name required");
            System.exit(1);
        }
        System.out.println(String.format("Hello %s!!", args[0]));
    }
}