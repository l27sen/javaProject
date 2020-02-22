package singleTon;

public class Single {


    public static void main(String [] args) throws Exception{

        Class c = null;
        try {
            c = Class.forName("singleTon.Single");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Object o = c.newInstance();

        if( o instanceof  Single){
            System.out.println(((Single)o).toString());
        }
        Single single = getInstance();
        System.out.print(single.toString()+"\n");

        Single single2 = getInstance();

        System.out.print(single2.toString());

    }

    // static variable single_instance of type Singleton
    private static Single single_instance = null;

    // variable of type String
    public String s;

    // private constructor restricted to this class itself
    private Single()
    {
        s = "Hello I am a string part of Singleton class";
    }

    // static method to create instance of Singleton class
    public static Single getInstance()
    {
        if (single_instance == null)
            single_instance = new Single();

        return single_instance;
    }
}
