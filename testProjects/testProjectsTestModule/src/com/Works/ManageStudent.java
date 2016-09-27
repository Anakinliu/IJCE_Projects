package com.Works;
import java.util.*;
/**
 * Created by liu_y.
 * On 2016/9/22.
 */
//案例描述：现有M位学生的姓名保存在一维String数组中，
// 有N门课程的名称保存在一维String数组中，另有M×N的二维数组保存这M位学生的每门课程的成绩。
//编写程序，使得用户可以通过输入如下控制台命令来查询学生的成绩：
class Class {
    //某一门学科
    String className;
    double score;
    //    Class(String cn, double s) {
//        className = cn;
//        score = s;
//    }
    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }
    public double getScore() {
        return score;
    }
    public void setScore(double score) {
        this.score = score;
    }
}
class StudentScoresPage {
    private  String name;
    private Class[] myClass;

    private int scoresCounts;
    private double sum;//所有学科的总分
    private double average;//所有学科的平均分

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class[] getMyClass() {
        return myClass;
    }

    public void setMyClass(Class[] myClass) {
        this.myClass = myClass;
    }

    public int getScoresCounts() {
        return scoresCounts;
    }

    public void setScoresCounts(int scoresCounts) {
        this.scoresCounts = scoresCounts;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    //每个成绩单对应一个名字，若干学科及其各自成绩
//    double[] scores;
    StudentScoresPage(String nam, Class[] a,  int counts, double s, double aver) {
        scoresCounts = counts;
        myClass = a;
        name = nam;
        sum = s;
        average = aver;
    }
}
public class ManageStudent {
    private int studentCounts;
    private int scoresCounts;

    StudentScoresPage[] ssp;
    public void setStudentCounts(int studentCounts) {
        this.studentCounts = studentCounts;
    }
    public void setScoresCounts(int scoresCounts) {
        this.scoresCounts = scoresCounts;
    }
    public void setSsp() {
        Scanner input = new Scanner(System.in);
//        scoresCounts = input.nextInt();
        ssp = new StudentScoresPage[studentCounts];
        String name;
        String className;
        Class[] d;
        d = new Class[scoresCounts];
        double x;
        double sum = 0;
        double average = 0;
        int i=0,j = 0;
        for (i=0; i<studentCounts; i++) {
            sum = 0;
            System.out.println("输入第" + (1+i) + "个学生名：");
            name = input.next();
//            x = new double[scoresCounts];

            for (j=0; j<scoresCounts; j++) {
                System.out.println("输入第" + (1+j) + "个科目名及科目成绩：");
                className = input.next();
                x = input.nextDouble();
                d[j] = new Class();//完成对Class[]的初始化并赋值给classname
                d[j].setClassName(className);
                d[j].setScore(x);
                sum+=d[j].getScore();
            }
//            for (j=0; j<scoresCounts; j++) {
//                x = input.nextDouble();
//                //d[j] = new Class();复制的后果：再次new会创建新的空间！！！
//                d[j].setScore(x);
//                sum+=d[j].getScore();
//            }
            average = sum/scoresCounts;
            ssp[i] = new StudentScoresPage(name,d,scoresCounts,sum,average);
            d = new Class[scoresCounts];//此处需要再次new,不然所有学生的成绩指向那一个Class[] d！！！
        }
    }
    public double aClassOrStudentAverage(String classNameOrStudentName) {//某门课程或者学生的平均分
        double sum = 0;
        int i = 0,j = 0;//下一个循环要用到，需要初始化
        //某门课程的平均分
//        for (j=0;j<scoresCounts; j++) {
//            if (classNameOrStudentName.equalsIgnoreCase(ssp[i].getMyClass()[j].getClassName())) {
//                break;//找出这个课程的下标位置
//            }
//        }
        j = getClassNameIndex(classNameOrStudentName);
        if (j < scoresCounts) {
            //有这门课程就返回，不再往下求学生平均分
            for (i=0; i<studentCounts; i++) {
                sum += ssp[i].getMyClass()[j].score;
            }
            return sum/studentCounts;
        }
        else {
            //求某学生的平均分
            for (i = 0; i < studentCounts; i++) {
                if (classNameOrStudentName.equalsIgnoreCase(ssp[i].getName())) {
                    return ssp[i].getSum() / scoresCounts;
                }
            }
            if (i >= studentCounts) {
                System.out.println("没有此科目或人名");
            }
            return 0.0;
        }
    }
    public double aStudentScoresSum(String studentName) {
        int j = 0,i = 0;
        double sum = 0;
//        for (i=0; i<studentCounts; i++) {
//            if (ssp[i].getName().equalsIgnoreCase(studentName)) {
//                sum = ssp[i].getSum();
//                break;
//            }
//        }
        i = getStudentNameIndex(studentName);
        if (i == studentCounts) {
            System.out.println("找不到此人");
            return 0.0;
        }
        sum = ssp[i].getSum();
        return sum;
    }
    public void sortAClassOrSum(String className) {
        //对不同学生的同一个学科排序
        //或者将每名学生的总成绩排序
        int i = 0,j = 0,k = 0,l = 0;
//        for (j=0;j<scoresCounts; j++) {
//            if (className.equalsIgnoreCase(ssp[i].getMyClass()[j].getClassName())) {
//                break;//找出这个课程的下标位置
//            }
//        }
        j = getClassNameIndex(className);
        //根据ssp[i].myClass[j].score排序ssp[]
        if (j < scoresCounts) {
            for(k=0; k<studentCounts-1; k++) {
                for(l=k+1; l>0; l--) {
                    if(ssp[l - 1].getMyClass()[j].score >= ssp[l].getMyClass()[j].score )
                        break;
                    StudentScoresPage sspTemp = new StudentScoresPage(null, null, 0, 0.0, 0.0);
                    sspTemp = ssp[l];
                    ssp[l] = ssp[l - 1];
                    ssp[l - 1] = sspTemp;
                }
            }
            for(k=0; k<studentCounts; k++) {
                System.out.println((k+1) + ".:" + ssp[k].getName() + "," + className + ": " + ssp[k].getMyClass()[j].score);
            }
        }
        else if (j >= scoresCounts) {//没有课程名，即排序总成绩
            for(k=0; k<studentCounts-1; k++) {
                for(l=k+1; l>0; l--) {
                    if(ssp[l - 1].getSum() >= ssp[l].getSum() )
                        break;
                    StudentScoresPage sspTemp = new StudentScoresPage(null, null, 0, 0.0, 0.0);
                    sspTemp = ssp[l];
                    ssp[l] = ssp[l - 1];
                    ssp[l - 1] = sspTemp;
                }
            }
            for(k=0; k<studentCounts; k++) {
                System.out.println((k+1) + ".:" + ssp[k].getName() + "," + "总分" + ssp[k].getSum());
            }
        }
    }
    public int getClassNameIndex(String className) {//得到科目的下标，不判断是否有此字符串
        int index;
        int  j;
        for (j=0;j<scoresCounts; j++) {
            if (className.equalsIgnoreCase(ssp[0].getMyClass()[j].getClassName())) {
                break;//找出这个课程的下标位置
            }
        }
        index = j;
        return index;
    }
    public int getStudentNameIndex(String studentName) {//不判断是否有此字符串
        int index;
        int i;
        for (i = 0; i < studentCounts; i++) {
            if (studentName.equalsIgnoreCase(ssp[i].getName())) {
                break;//找出这个学生的下标位置
            }
        }
        index = i;
        return index;
    }
    public double getAStudentClassScore(String studentName, String className) {
        int i = getStudentNameIndex(studentName);
        int j = getClassNameIndex(className);
        if (i>=studentCounts||j>=scoresCounts) {
            System.out.println("课程名或者学生名不存在");
            return 0.0;
        }
        return ssp[i].getMyClass()[j].score;
    }
    public void printSsp() {//输出ssp[]
        int i = 0,j = 0;
        for (i=0; i<studentCounts; i++) {
            System.out.println((i+1) + ":");
            System.out.println("姓名：" + ssp[i].getName());
            for (j=0; j<ssp[i].getScoresCounts(); j++) {
                System.out.println("科目：" + ssp[i].getMyClass()[j].className);
                System.out.println("科目成绩：" + ssp[i].getMyClass()[j].score);
            }
        }
        System.out.println();
    }
    public void shellControl() {
        Scanner sca = new Scanner(System.in);
        while (true) {
            System.out.println("输入命令：");
            String comm = sca.next();
            if (comm.equalsIgnoreCase("avg")) {
                System.out.println("输入课程名或者学生名");
                String course = sca.next();//输入课程名或者学生名
                double avg = aClassOrStudentAverage(course);
                System.out.println(course + "的平均分是：" + avg);
                System.out.println();
            }
            else if (comm.equalsIgnoreCase("sum")) {
                System.out.println("输入学生名");
                String studentName = sca.next();//输入学生名
                double sum = aStudentScoresSum(studentName);
                System.out.println(studentName + "的总分是：" + sum);

            }
            else if (comm.equalsIgnoreCase("exit")) {
                System.exit(0);
            }
            else if (comm.equalsIgnoreCase("sort")) {
                System.out.println("输入课程名或者\"总分\"查询排名");
                String className = sca.next();//输入课程名或者学生名
                sortAClassOrSum(className);

            }
            else if (comm.equalsIgnoreCase("get")) {
                System.out.println("依次输入学生姓名，科目名：");
                String sN = sca.next();
                String cN = sca.next();

                double x = getAStudentClassScore(sN,cN);
                System.out.print(sN + "的" + cN + "成绩是:" + x);
                System.out.println();
                //System.out.println(getAStudentClassScore(studentName,className));
            }
        }
    }
    public void inputBothCounts() {
        Scanner input = new Scanner(System.in);
        System.out.println("输入学生和科目数：");
        int stuC = input.nextInt();
        int scoC = input.nextInt();
        setStudentCounts(stuC);
        setScoresCounts(scoC);
    }
    public static void main(String[] args) {

        //System.out.println(s);
        ManageStudent ms = new ManageStudent();
        ms.inputBothCounts();
        //ms.setScoresCounts(3);
        //ms.setStudentCounts(2);
        ms.setSsp();
        ms.shellControl();
        //System.out.println(ms.getClassNameIndex("hua"));
        //System.out.println(ms.getStudentNameIndex("aaa"));
        //ms.printSsp();

        //ms.sortAClassOrSum("yuwen");
        //ms.sortAClassOrSum("shuxue");
        //System.out.println(ms.aStudentScoresSum("liu"));
        //System.out.println(ms.getAStudentClassScore("liu", "shuxue"));
        //s = new String("shuxue");
        //System.out.println("aver" + ms.aClassOrStudentAverage(studentname));
        //System.out.println(ms.aStudentScoresSum(studentname));
    }
}
//1.public static double avg(String cName)：该方法用来求课程平均分
//2.public static double sum(String uName)：该方法用来求学员成绩总分
//3.public static void sort(String name)：该方法用来对成绩排序
//4.public static double get(String uName,String cName)：该方法用来得到某位学员某门课程的成绩