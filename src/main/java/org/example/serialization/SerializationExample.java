package org.example.serialization;

import java.io.*;

public class SerializationExample implements Serializable {
    int id;
    String name;
    transient String password;

    public SerializationExample(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "SerializationExample{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static void main(String[] args) {
        SerializationExample sr = new SerializationExample(1,"Mahesh","Mahesh@1810");

        //Serialization
        try{
            FileOutputStream fOut = new FileOutputStream("C:/SpringBoot/StreamAPI/src/main/java/org/example/serialization/serialize.txt");
            ObjectOutputStream oOut = new ObjectOutputStream(fOut);
            oOut.writeObject(sr);
            oOut.close();
            fOut.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Deserialization
        try {
            FileInputStream fileIn = new FileInputStream("C:/SpringBoot/StreamAPI/src/main/java/org/example/serialization/serialize.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            SerializationExample deserializedObj = (SerializationExample) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Object deserialized: " + deserializedObj);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
