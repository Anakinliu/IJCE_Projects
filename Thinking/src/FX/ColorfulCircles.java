package FX;


import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.BoxBlur;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

/**
 * Created by Anakinliu on 2017/3/5.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class ColorfulCircles extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //使用了一个Group节点作为Scene的根节点
        Group root = new Group();

        Scene scene = new Scene(root, 800, 600, Color.BLACK);

        primaryStage.setScene(scene);

        /*
        通过在代码行promaryStage.show()之前添加例7-2中的代码来添加30个圆圈
         */
        Group circles = new Group();

        for (int i=0; i<30; i++) {
            //参数是颜色与不透明等级
            Circle circle = new Circle (150, Color.web("white", 0.05));

            //Stroke Type 是笔触类型, OUTSIDE表示圆圈的边会扩展到外部
            circle.setStrokeType(StrokeType.OUTSIDE);

            //笔触颜色,不透明等级大于圆圈,使得其比圆圈颜色更亮
            circle.setStroke(Color.web("white", 0.16));

            //扩展的宽度
            circle.setStrokeWidth(4.0);

            //向Group中添加圆圈.
            circles.getChildren().add(circle);
        }


        /*
            TODO: http://www.javafxchina.net/blog/2015/07/doc01_animal/
         */
        //创建线性渐变的矩形
        Rectangle colors = new Rectangle(scene.getWidth(), scene.getHeight(),
                new LinearGradient(0f, 1f, 1f, 0f, true, CycleMethod.NO_CYCLE, new Stop(0, Color.web("#f8bd55")),
                        new Stop(0.14, Color.web("#c0fe56")),
                        new Stop(0.28, Color.web("#5dfbc1")),
                        new Stop(0.43, Color.web("#64c2f8")),
                        new Stop(0.57, Color.web("#be4af7")),
                        new Stop(0.71, Color.web("#ed5fc2")),
                        new Stop(0.85, Color.web("#ef504c")),
                        new Stop(1, Color.web("#f2660f"))));

        // TODO: 《使用JavaFX属性和绑定(Using JavaFX Properties and Bindings)》教程将会更为详细地描述”绑定”的相关信息。
        //接下来的两行代码表示将scene和渐变矩形的大小绑定保持一致。
        colors.widthProperty().bind(scene.widthProperty());
        colors.heightProperty().bind(scene.heightProperty());
        //root.getChildren().add(colors);

        //root.getChildren().add(circles);

        /*
        新的蒙版混合Group

        blenModeGroup Group建立了蒙版混合模式的结构。
         在Group中包含了两个子节点。
         第一个子节点是新建的(匿名)Group，
         其中包含了一个黑色的(匿名)矩形以及之前创建的circles Group。
         第二个节点是之前创建的colors矩形。

         蒙版混合模式是图像处理应用程序中常见的一种效果。
         这种混合通过使用不同的颜色可以将一个图片变暗或为其增加高光，
         或者同时起到两种作用。在本例中线性渐变矩形被用作了蒙版。
         黑色矩形框用于保持背景是黑色，而近乎透明的圆圈则从渐变中获得了颜色，
         但是它们都并被变暗了。
         */
        Group blendModeGroup = new Group(new Group(new Rectangle(scene.getWidth(), scene.getHeight(),
                Color.WHITE), circles), colors);

        //setBlendMode()方法在colors矩形上应用了蒙版混合模式
        colors.setBlendMode(BlendMode.OVERLAY);

        root.getChildren().add(blendModeGroup);

        //圆圈的盒式模糊效果, 参数 : 模糊范围, 模糊迭代次数
        circles.setEffect(new BoxBlur(10, 10, 3));

        //添加动画
        Timeline timeline = new Timeline();

        /*
        动画由一个时间轴来驱动，因此这段代码创建了一个时间轴，
        然后使用一个for循环来为30个圆圈各增加了两个关键帧。
        第一个关键帧是在第0秒，
        通过使用translateXProperty和translateYProperty属性来为圆圈设置窗体中的一个随机位置。
        第二个在第40秒的关键帧也做了类似的事情。因此当时间轴被播放时，
        它会将所有的圆圈在40秒之内从一个随机位置移到另外一个随机位置。
         */
//        for (Node circle : circles.getChildren()) {
//            timeline.getKeyFrames().addAll(
//                    new KeyFrame(Duration.ZERO, //set start position) at 0
//                            new KeyValue(circle.translateXProperty(), Math.random() * 800),
//                            new KeyValue(circle.translateYProperty(), Math.random() * 600)
//
//            ),
//                    new KeyFrame(new Duration(40000), //set end position at 40s
//                            new KeyValue(circle.translateXProperty(), Math.random() * 800),
//                            new KeyValue(circle.translateYProperty(), Math.random() * 600)
//                    )
//            );
//
//
//        }
//
//        timeline.play();

        primaryStage.show();
    }
}
