package info.sanaulla;

import java.util.Map;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class IllegalLocalVarInferenceDemo{
    //Not permitted in class fields
    //var someProperty;

    //Not allowed as parameter for constructor
    // public LocalVarInferenceDemo(var param1){

    // }

    public static void main(String[] args){

        //Not allowed in catch parameter
        // try{
        //     //some operations
        // }catch(var ex){

        // }
    }

    //Not permitted below
    //public static void someMethod(var param1, var param2){
    //   System.out.println("Some method called");
    //}

    //Not permitted in method return type
    // public static var someAnotherMethod2(){
    //     System.out.println("someAnotherMethod called");
    //     var returnObj = 12;
    //     return returnObj;
    // }
}