package com.scotiabank.riskmanagement.testcdoe.interviewsample.filewrite;


import java.io.*;

/**
 *  Externalizable, it's the programmer who should take care of the whole serialization and also deserialization process
 */
public class CountryExternalizable implements Externalizable {

    private static final long serialVersionUID = 1L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    private String name;
    private int code;

    // getters, setters
//writeExternal() method, we're adding the object's properties to the ObjectOutput stream
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(name);
        out.writeInt(code);
    }

    @Override
    public void readExternal(ObjectInput in)
            throws IOException, ClassNotFoundException {
        this.name = in.readUTF();
        this.code = in.readInt();
    }

    public static void main(String[] a) throws Exception{
        CountryExternalizable c = new CountryExternalizable();
        c.setCode(374);
        c.setName("Armenia");

        FileOutputStream fileOutputStream
                = new FileOutputStream("testCountry");
        ObjectOutputStream objectOutputStream
                = new ObjectOutputStream(fileOutputStream);
        c.writeExternal(objectOutputStream);

        objectOutputStream.flush();
        objectOutputStream.close();
        fileOutputStream.close();

        FileInputStream fileInputStream
                = new FileInputStream("testCountry");
        ObjectInputStream objectInputStream
                = new ObjectInputStream(fileInputStream);

        CountryExternalizable c2 = new CountryExternalizable();
        c2.readExternal(objectInputStream);

        objectInputStream.close();
        fileInputStream.close();

     }
}
