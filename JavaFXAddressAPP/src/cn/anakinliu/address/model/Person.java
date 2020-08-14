package cn.anakinliu.address.model;

import javafx.beans.property.*;

import java.time.LocalDate;

/*
* 在JavaFX中,对一个模型类的所有属性使用 Properties是很常见的.
* 一个 Property 允许我们, 打个比方,
* 当 lastName 或其他属性被改变时自动收到通知,
* 这有助于我们保持视图与数据的同步，
* 阅读 Using JavaFX Properties and Binding 学习更多
* 关于 Properties 的内容。
* */
public class Person {

    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty street;
    private final StringProperty city;
    private final IntegerProperty postalCode;
    private final ObjectProperty<LocalDate> birthday;

    public Person() {
        this(null, null);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getStreet() {
        return street.get();
    }

    public StringProperty streetProperty() {
        return street;
    }

    public void setStreet(String street) {
        this.street.set(street);
    }

    public String getCity() {
        return city.get();
    }

    public StringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public int getPostalCode() {
        return postalCode.get();
    }

    public IntegerProperty postalCodeProperty() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode.set(postalCode);
    }

    public LocalDate getBirthday() {
        return birthday.get();
    }

    public ObjectProperty<LocalDate> birthdayProperty() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday.set(birthday);
    }

    public Person(String firstName, String lastName) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);

        // 懒
        this.street = new SimpleStringProperty("伯乐大街");
        this.postalCode = new SimpleIntegerProperty(274200);
        this.city = new SimpleStringProperty("成武");
        this.birthday = new SimpleObjectProperty<>(LocalDate.of(1970, 1,1 ));
    }


}
