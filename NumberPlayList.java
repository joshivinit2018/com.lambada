package com.javapractice.javapractice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class NumberPlayList {
    public static <action> void main(String[] args){
        //create colletion
        List<Integer>myNumberList = new ArrayList<Integer>();
        for (int i=0;i<5;i++)myNumberList.add(i);
        //Method 1 :transverse itrator
        Iterator<Integer>it = myNumberList.iterator();
        while (it.hasNext()){
            Integer i =it.next();
            System.out.println("Math1 itrator value : :" +i);
        }
        //method 2 : transverse with explicit method
            class MyConsumer implements Consumer<Integer> {
                public void accept(Integer t) {
                    System.out.println("Math2 consumer value : :" + t);
                }
            }
            MyConsumer action = new MyConsumer();
                myNumberList.forEach(action);

        //method 3: transverse annomus interface implemention
        myNumberList.forEach(new Consumer<Integer>() {
            public void accept(Integer t) {
                System.out.println("Math3 for each annonomus class : :" + t);
            }
        } );

        //method 4 : Explicit Lambada function
        Consumer<Integer>myListaction = n -> {
                System.out.println("Math4 for Explicit Lambada function : :" + n);
        };
//        myListaction.forEach(myListaction);
        myNumberList.forEach(myListaction);


        //method 5 : implicit lambada function
        myNumberList.forEach(n ->{
                System.out.println("Math5 for Explicit Lambada function : :" + n);
        });

        //method 6 : implicit lambada function to double value

        Function<Integer,Double>toDoubleFunction =Integer :: doubleValue;
        Predicate<Integer>isEvenFunction = n -> n > 0 && n%2 ==0;
        List<Double>doubleList = new ArrayList<Double>();
        List<Integer> evenList = new ArrayList<>();
        myNumberList.forEach(n -> {
                    if (isEvenFunction.test(n.intValue()))
                        evenList.add(n);
                });
        System.out.println("evenlist" +evenList);

        //method 7 : implicit lambada function to even value
        Function<Integer,Double>toDoubleFunction = Integer ::doubleValue;
        Predicate<Integer> isEvenFunction = n -> n > 0 && n%2 ==0;
        myNumberList.forEach(n -> {
            System.out.println("Math7 for Each value of :" + n+
                    "check for even:" + isEvenFunction.test(n));
        });

        //method 8: processing the stream
        myNumberList.stream().forEach( n->{
            System.out.println("Math8 for processing stream : :" + n);
        });
        //method 9:process the stream and apply result
        List<Double>StreamList=myNumberList.stream()
                                .map(toDoubleFunction)
                                .collect(Collectors.toCollection());
        System.out.println("Math8 for processing stream : :" + n);
    }
}
