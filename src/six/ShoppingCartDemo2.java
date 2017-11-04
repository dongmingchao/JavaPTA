package six;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.math.BigDecimal;

public class ShoppingCartDemo2 extends Application{

    private Controller controller;
    ObservableList<cartItem> cartItems = FXCollections.observableArrayList();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("cart.fxml"));
        VBox root = loader.load();
        controller = loader.getController();
        controller.setApp(this);
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("购物车--By董明超-简卓林");
        primaryStage.show();

        cartItems.add(new Item("苹果",2,1.2));
        controller.showList.setItems(cartItems);
        controller.showList.getColumns().forEach(each -> each.setStyle("-fx-alignment: center"));
        controller.showList.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("name"));
        controller.showList.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("numberTF"));
        controller.showList.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("price"));
    }
    Item makeItem(Controller.goods goods){
        return new Item(goods.getName(),goods.getNumber()+1,goods.getSinglePrice());
    }

    class Item extends cartItem{

        public Item(String name, Integer number, double singlePrice) {
            super(name, number, singlePrice);
        }

        @Override
        void calcButton(int number) {
            if (number==0) {
                cartItems.remove(this);
                return;
            }
            this.setNumber(number);
//            this.getTheNumber().setText(String.valueOf(this.getNumber()));
            this.setPrice(BigDecimal.valueOf(this.getNumber()).multiply(BigDecimal.valueOf(this.getSinglePrice())).doubleValue());
        }
    }
}
