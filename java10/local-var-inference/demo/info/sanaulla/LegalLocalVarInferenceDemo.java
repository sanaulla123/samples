package info.sanaulla;

import java.util.Map;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class LegalLocalVarInferenceDemo{

    //in a static/instance initialization block
    static {
        var anotherName = "Sanaulla";
        System.out.println("Hello, " + anotherName);
    }


    public static void main(String[] args){

        //as a local variable
        var name = "Mohamed Sanualla";
        System.out.println("Hello " + name);

        var data = new ArrayList<Map<String, String>>();
        data.add(Map.of("key1", "value1", "key2", "value2"));
        data.add(Map.of("key11", "value11", "key22", "value22"));
        
        System.out.println(data);

        System.out.println("********** As iteration variable in enhanced for-loop ***************");
        for ( var object : data){
            System.out.println(String.format("%s of type %s", object, object.getClass().getName()));
        }

        System.out.println("********** As looping index in for-loop ***************");
        for ( var i = 0 ; i < data.size(); i++ ){
            var object = data.get(i);
            System.out.println(String.format("%s of type %s", object, object.getClass().getName()));
        }

        System.out.println("********** As a return value from another method ***************");
        var anInteger = someAnotherMethod();
        System.out.println("someAnotherMethod returned " + anInteger);

    }

    //As a return value in a method
    public static Integer someAnotherMethod(){
        System.out.println("someAnotherMethod called");
        var returnObj = 12;
        return returnObj;
    }

}