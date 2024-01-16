package org.example.designPatterns.creational.SingletoneDesignPattern;

class Main {
    static public void main(String[] args) {
        System.out.println("Singleton Class Example\n");

        singletonClass obj2 = singletonClass.getObject();
        singletonClass obj3 = singletonClass.getObject();

        System.out.println("HashCode of Obj2:- " + obj2.hashCode());
        System.out.println("HashCode of Obj3:- " + obj3.hashCode());

        System.out.println("Singleton class without performance overhead:- ");
        singletonClass obj4 = singletonClass.getObjectWithoutPerforceOverhead();
        singletonClass obj5 = singletonClass.getObjectWithoutPerforceOverhead();

        System.out.println("HashCode of Obj3:- " + obj4.hashCode() + "\n" +"HashCode of Obj5:- " + obj5.hashCode());

        System.out.println("Singleton Design pattern using enum:- ");

        SingletonEnum singletonEnum = SingletonEnum.SINGLETON_ENUM;

        SingletonEnum singletonEnum1 = SingletonEnum.SINGLETON_ENUM;

        System.out.println("HashCode of singletonEnum:- "+ singletonEnum.hashCode()
                            +"\n"+ "HashCode of singletonEnum1:- "+singletonEnum1.hashCode());


    }

}
