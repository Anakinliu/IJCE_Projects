package cn.anakinliu.address.view;

import cn.anakinliu.address.model.Person;
import cn.anakinliu.address.util.DateUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class PersonEditDialogController {
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField streetField;
    @FXML
    private TextField postalCodeField;
    @FXML
    private TextField birthdayField;
    @FXML
    private TextField cityField;

    private Stage dialogStage;
    private Person person;
    private boolean okClicked = false;

    /*
    * 在fxml文件被加载后自动调用
    * */
    @FXML
    private void initialize() {

    }

    /*
     * 设置 dialog 的stage
     * */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /*
     * 编辑时，根据传入的 person初始化设置页面的dialog
     * */
    public void setPerson(Person person) {
        this.person = person;

        firstNameField.setText(person.getFirstName());
        lastNameField.setText(person.getLastName());
        streetField.setText(person.getStreet());
        cityField.setText(person.getCity());
        birthdayField.setText(DateUtil.format(person.getBirthday()));
//        birthdayField.setPromptText("yyyy.MM.dd");
    }

    /*
    * 如果用户点击确定，返回true,否则 false
    * */
    public boolean isOkClicked() {
        return okClicked;
    }

    /*
    * 用户点击 确定 时调用
    * */
    @FXML
    private void handleOk() {
        if (isImputValid()) {
            person.setFirstName(firstNameField.getText());
            person.setLastName(lastNameField.getText());
            person.setStreet(streetField.getText());
            person.setPostalCode(Integer.parseInt(postalCodeField.getText()));
            person.setCity(cityField.getText());
            person.setBirthday(DateUtil.parse(birthdayField.getText()));

            okClicked = true;
            // 关闭 窗口
            dialogStage.close();
        }

    }
    /*
     *
     * */
    @FXML
    private void handleCancel() {
        // 直接关闭窗口
        dialogStage.close();
    }

    /*
     * 验证用户输入
     * */
    private boolean isImputValid() {
        String errorMess = "";

        if (firstNameField.getText() == null
                || firstNameField.getText().length() == 0) {
            errorMess += "姓 不合法！\n";
        }
        if (lastNameField.getText() == null
                || lastNameField.getText().length() == 0) {
            errorMess += "名 不合法！\n";
        }
        if (streetField.getText() == null
                || streetField.getText().length() == 0) {
            errorMess += "街道 不合法！\n";
        }
        if (postalCodeField.getText() == null
                || postalCodeField.getText().length() == 0) {
            errorMess += "邮编 不合法！\n";
        } else {
            try {
                Integer.parseInt(postalCodeField.getText());
            } catch (NumberFormatException e) {
                errorMess += "邮编 不合法！\n";
            }
        }
        if (cityField.getText() == null
                || cityField.getText().length() == 0) {
            errorMess += "城市 不合法！\n";
        }
        if (birthdayField.getText() == null || birthdayField.getText().length() == 0) {
            errorMess += "No valid birthday!\n";
        } else {
            if (!DateUtil.validDate(birthdayField.getText())) {
                errorMess += "No valid birthday. Use the format dd.mm.yyyy!\n";
            }
        }

        if (errorMess.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("非法字段");
            alert.setHeaderText("信息：");
            alert.setContentText(errorMess);
            alert.showAndWait();
            return false;
        }
    }
}
