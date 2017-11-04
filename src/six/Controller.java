package six;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigDecimal;

public class Controller {

    @FXML
    public Button buy;
    @FXML
    public Button watch;
    @FXML
    public Button exit;
    @FXML
    public Label sum;
    @FXML
    public TableView<cartItem> showList;

    private ShoppingCartDemo2 app;

    public void backTo() throws IOException {
        VBox buyGood = FXMLLoader.load(getClass().getResource("good.fxml"));
        Stage main = new Stage();
        main.setScene(new Scene(buyGood));
        main.setTitle("商品列表");
        main.show();
        TableView<cartItem> goodList = (TableView<cartItem>) buyGood.lookup("#goodList");

        ObservableList<cartItem> goodItems = FXCollections.observableArrayList();
        goodItems.add(new goods("面包",0,5));
        goodItems.add(new goods("土豆",0,999));
        goodItems.add(new goods("苹果",0,1.2));
        goodItems.add(new goods("香蕉",0,3));
        goodItems.add(new goods("西瓜",0,8));
        goodItems.add(new goods("绝境求生",0,98));
        goodItems.add(new goods("怀旧莓",0,0.24));
        goodList.setItems(goodItems);
        goodList.getColumns().forEach(each -> each.setStyle("-fx-alignment: center"));
        goodList.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("name"));
        goodList.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("singlePrice"));
        goodList.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("numberTF"));
    }

    class goods extends cartItem{

        public goods(String name, Integer number, double singlePrice) {
            super(name, number, singlePrice);
        }


        @Override
        void calcButton(int number) {
            if (number < 0) return;
            else {
                if (app.cartItems.contains(this)) {
                    cartItem each = app.cartItems.get(app.cartItems.indexOf(this));
                    if (number==0) app.cartItems.remove(each);
                    else each.setNumber(number);
                }
                else app.cartItems.add(app.makeItem(this));
            }
            this.setNumber(number);
            this.setPrice(BigDecimal.valueOf(this.getNumber()).multiply(BigDecimal.valueOf(this.getSinglePrice())).doubleValue());
        }
    }

    void setApp(ShoppingCartDemo2 app){
        this.app = app;
    }
}
