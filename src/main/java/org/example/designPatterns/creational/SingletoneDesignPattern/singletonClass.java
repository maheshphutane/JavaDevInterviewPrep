package org.example.designPatterns.creational.SingletoneDesignPattern;

public class singletonClass {
    //Singleton Design Pattern - With Performance over head
    //Def :- Singleton class means there will be only one object of that class, we cannot create multiple objects of it
    //Create a singleton class
    //Steps
    //make the constructor private so that we cannon create multiple object
    //Create a private static object variable to hold the object of that class
    //Create a static methode inside the same class to create a single object from it
    //use synchronized keyword to make this methode thread safe
        private static singletonClass obj=null;
        private String tmp;

        private singletonClass() {
        tmp = "Mahesh";
    }
        public static synchronized singletonClass getObject(){ // synchronized keyword is used to make this methode thread safe
                                                              // but this will cause perforce overhead as each thread have to wait
                                                              // to get the instance as we have used class level lock here
            if(obj==null){
                obj = new singletonClass(); // Lazy initialization
            }
            return obj;
        }

        // Optimal way to create singleton class
        public static singletonClass getObjectWithoutPerforceOverhead(){
            if(obj==null){
                synchronized (singletonClass.class){
                    if(obj==null){                       // Double-checking
                        obj = new singletonClass();
                    }
                }
            }
            return obj;
        }

}

