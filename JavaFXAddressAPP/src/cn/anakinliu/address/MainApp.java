package cn.anakinliu.address;

import cn.anakinliu.address.model.Person;
import cn.anakinliu.address.view.PersonOverviewController;
import cn.anakinliu.address.view.PersonEditDialogController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    private ObservableList<Person> personData =
            FXCollections.observableArrayList();

    public MainApp() {
//        System.out.println("MainApp 构造器");
        // Add some sample data
        personData.add(new Person("Hans", "Muster"));
        personData.add(new Person("Ruth", "Mueller"));
        personData.add(new Person("Heinz", "Kurz"));
        personData.add(new Person("Cornelia", "Meier"));
        personData.add(new Person("Werner", "Meyer"));
        personData.add(new Person("Lydia", "Kunz"));
        personData.add(new Person("Anna", "Best"));
        personData.add(new Person("Stefan", "Meier"));
        personData.add(new Person("Martin", "Mueller"));
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
//        System.out.println(personData.size());
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("通讯录");

        // rootLayout.fxml： 一个BorderPane，上面是一个Menu Bar
        initRootLayout();

        // personOverview.fxml
        showPersonOverview();
    }

    /*
     * Initializes the root layout.
     */
    private void initRootLayout() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
        rootLayout = loader.load();

        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    /*
    Shows the person overview inside the root layout.
    * */
    private void showPersonOverview() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(
                getClass()
                        .getResource("view/PersonOverview.fxml")
        );
        AnchorPane personOverview = loader.load();

        // 设置Person overview 作为 root layout - border layout的中心
        rootLayout.setCenter(personOverview);

        // 关联 MainApp 和 PersonOverviewController
        PersonOverviewController controller =
                loader.getController();
        controller.setMainApp(this);
    }

    public ObservableList<Person> getPersonData() {
        return personData;
    }

    /*
     * 打开 编辑人详细信息的dialog
     * 如果用户单击“确定”，则更改将保存到提供的person对象中，并返回true。
     * 如果用户单击“确定”，返回false
     * */
    public boolean showPersonEditDialog(Person person) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(
                "view/PersonEditDialog.fxml"
        ));
        AnchorPane page = loader.load();

        // 创建舞台
        Stage dialogStage = new Stage();
        dialogStage.setTitle("编辑信息");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // 设置person到 控制器
        PersonEditDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setPerson(person);

        // 显示 dialog 等待直到用户关闭它
        dialogStage.showAndWait();

        return controller.isOkClicked();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
