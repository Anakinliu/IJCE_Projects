package Serializable;

import java.io.*;

/**
 * 喵星人
 * @author 286
 *
 */

//http://286.iteye.com/blog/2227942
public class Cat implements Serializable {

    private String name;
    private double weight;
    private String color;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
//    public int getAge() {
//        return age;
//    }
//    public void setAge(int age) {
//        this.age = age;
//    }


    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public static void main(String[] args) {
        Cat cat=new Cat();
        cat.setName("喵星人");
        //cat.setAge(3);
        cat.setWeight(20.0);
        cat.setColor("白色");
//定义文件输出流，准备将数据写入文件中
        OutputStream os= null;
        try {
            os = new FileOutputStream("G:\\cat.txt");
            ObjectOutputStream oos=new ObjectOutputStream(os);

            //写入实例数据
            oos.writeObject(cat);
            oos.close();
            os.close();


            InputStream is=new FileInputStream("G:\\cat.txt");
            ObjectInputStream ois=new ObjectInputStream(is);
//读取序列化实例内容
            Cat cat2 = (Cat)ois.readObject();
            System.out.println(cat2.getName());
            System.out.println(cat2.getWeight());
            System.out.println(cat2.getColor());
            ois.close();
            is.close();
        } catch (Exception io) {
            io.printStackTrace();
        }





    }
}
