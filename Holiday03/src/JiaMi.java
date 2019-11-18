import java.io.*;

/*
    AUTHOR: linux
    TIME: 2019/2/9
    GOOD LUCK AND NO BUG.
*/
public class JiaMi {
    private static int mi = 233;

    public static void Jia(String inputPath) {
        try (BufferedInputStream bufferedInputStream =
                new BufferedInputStream(new FileInputStream(
                        inputPath + "huaji.jpg"));
             BufferedOutputStream bufferedOutputStream =
                new BufferedOutputStream(new FileOutputStream("" +
                        inputPath + "jiami_huaji.jpg"))) {
            int temp;
            while ((temp = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(temp ^ mi);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // 系统把项目的根目录作为相对路径的起点
    public static void Jie(String inputPath) {
        try (BufferedInputStream bufferedInputStream =
                     new BufferedInputStream(new FileInputStream(
                             inputPath + "jiami_huaji.jpg"));
             BufferedOutputStream bufferedOutputStream =
                     new BufferedOutputStream(new FileOutputStream("" +
                             inputPath + "jiemi_huaji.jpg"))) {
            int temp;
            while ((temp = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(temp ^ mi);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Jia("");
        Jie("");
    }
}
