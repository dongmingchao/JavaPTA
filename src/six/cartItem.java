package six;

import javafx.beans.property.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.math.BigDecimal;

public abstract class cartItem {
    private StringProperty name = new SimpleStringProperty();
    private IntegerProperty number = new SimpleIntegerProperty();
    private DoubleProperty price = new SimpleDoubleProperty();
    private DoubleProperty singlePrice = new SimpleDoubleProperty();
    private ObjectProperty<VBox> numberTF;
    private Label theNumber;
    private Button subNumber;


    public Label getTheNumber() {
        return theNumber;
    }

    public Button getSubNumber() {
        return subNumber;
    }

    public void setSubNumber(Button subNumber) {
        this.subNumber = subNumber;
    }

    public Button getAddNumber() {
        return addNumber;
    }

    public void setAddNumber(Button addNumber) {
        this.addNumber = addNumber;
    }

    private Button addNumber;


    public void setPrice(double price) {
        this.price.set(price);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getNumber() {
        return number.get();
    }

    public IntegerProperty numberProperty() {
        return number;
    }

    public void setNumber(int number) {
        this.number.set(number);
        if (theNumber!=null) theNumber.setText(String.valueOf(number));
        this.setPrice(BigDecimal.valueOf(singlePrice.get()).multiply(BigDecimal.valueOf(number)).doubleValue());
    }

    public double getPrice() {
        return price.get();
    }

    public DoubleProperty priceProperty() {
        return price;
    }

    public Object getNumberTF() {
        return numberTF.get();
    }

    public ObjectProperty numberTFProperty() {
        return numberTF;
    }

    public double getSinglePrice() {
        return singlePrice.get();
    }

    public DoubleProperty singlePriceProperty() {
        return singlePrice;
    }

    public void setSinglePrice(double singlePrice) {
        this.singlePrice.set(singlePrice);
    }


    public cartItem(String name, Integer number, double singlePrice) {
        this.setName(name);
        this.setSinglePrice(singlePrice);
        this.setNumber(number);
        addNumber = new Button("+");
        subNumber = new Button("-");
        theNumber = new Label(number.toString());
        theNumber.setStyle("-fx-font-size: 20px");
        numberTF = new SimpleObjectProperty<>(new VBox(addNumber,theNumber,subNumber));
        subNumber.setOnAction(event -> calcButton(this.getNumber() - 1));
        addNumber.setOnAction(event -> calcButton(this.getNumber() + 1));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;

        cartItem cartItem = (cartItem) o;

        return name.getValue().equals(cartItem.name.getValue());
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    abstract void calcButton(int number);
}
