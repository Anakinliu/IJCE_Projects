package cn.anakinliu.address.view;

import cn.anakinliu.address.MainApp;
import cn.anakinliu.address.model.Person;
import cn.anakinliu.address.util.DateUtil;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/*
* 控制器java类需要放在和PersonOverview.fxml相同的包下,
* 不然SceneBuilder会找不到它 - 至少在当前的版本).
* */
public class PersonOverviewController {
    /*
     * 增加一些实例变量来访问表格和在视图中的标签.
     * 这些属性和一些方法有一个特殊的 @FXML 注解.
     * 这对于fxml文件访问私有属性和私有方法来说是必需的.
     *
     * 当将一切都在fxml文件中设置好之后,
     * 应用程序会在fxml文件被载入时自动地填充这些变量.
     * */
    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label postalCodeLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label birthdayLabel;

    // 指向main 的引用
    private MainApp mainApp;

    // 在initialize（）方法前被调用
    public PersonOverviewController() {
        System.out.println(
                "PersonOverviewController 构造器，先于initialize"
        );
    }

    /*
    * 初始化控制器类，此方法在 fxml文件被load后
    * 自动调用
    * */
    @FXML
    private void initialize() {
        // 确实，加载后自动初始化
        System.out.println("PersonOverviewController initialize()");
        // 初始化 person table
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());

        // 清空 Person details
        showPersonDetails(null);

        // 监听选择哪一行的变化，调用showPersonDetail更新
        personTable.getSelectionModel()
                .selectedItemProperty()
                .addListener(
                        (observable, oldValue, newValue) -> showPersonDetails(newValue));
    }

    /*
     * 由主应用程序调用以提供对自身的引用。
     * */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // 给左侧的 Name 表添加数据
        personTable.setItems(mainApp.getPersonData());
    }

    /*
     * 根据Person参数填充 右侧的详细信息 GridPane
     * 如果为null，则所有Label清空
     * */
    private void showPersonDetails(Person person) {
        if (person == null) {
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            streetLabel.setText("");
            postalCodeLabel.setText("");
            cityLabel.setText("");
            birthdayLabel.setText("");
        } else {
            firstNameLabel.setText(person.getFirstName());
            lastNameLabel.setText(person.getLastName());
            streetLabel.setText(person.getStreet());
            postalCodeLabel.setText(Integer.toString(person.getPostalCode()));
            cityLabel.setText(person.getCity());
            //
            birthdayLabel.setText(person.getBirthday().toString());
//            birthdayLabel.setText(DateUtil.format(person.getBirthday()));
        }
    }

    public static void alert() {
        // 最新版JavaFX已经包含了Dialogs，不再由controlsfx这个第三方库提供
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("井盖");
        alert.setHeaderText("注意");
        alert.setContentText("选择一项后才能执行");
        alert.showAndWait();
    }

    /*
    * 当用户点击 删除按钮 时调用
    * */
    @FXML
    private void handleDeletePerson() {
        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            personTable.getItems().remove(selectedIndex);
        } else {
            alert();
        }

    }

    /*
    * 用户点击新增按钮时调用,打开 dialog
    * */
    @FXML
    private void handleNewPerson() throws Exception{
        Person tempPerson = new Person();
        boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
        if (okClicked) {
            mainApp.getPersonData().add(tempPerson);
            showPersonDetails(tempPerson);
        }
    }

    /*
    * 点击编辑时，打开 dialog，包含选定的 person 的信息
    * */
    @FXML
    private void handleEditPerson() throws Exception{
        Person selectedPerson = personTable
                .getSelectionModel()
                .getSelectedItem();
        if (selectedPerson != null) {
            boolean okClicked = mainApp.showPersonEditDialog(
                    selectedPerson
            );
            // 显示刚刚编辑好的新信息
            if (okClicked) {
                showPersonDetails(selectedPerson);
            }
        } else {
            alert();
        }
    }
}
