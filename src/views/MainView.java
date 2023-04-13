package views;

import javax.swing.JFrame;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import models.Car;
//import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.TextFieldTableCell;

public class MainView extends Application {

        MainView(String userID) {
                JFrame frame = new JFrame();

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(420, 420);
                frame.setLayout(null);
                frame.setVisible(true);
        }

        private TableView<Car> table = new TableView<>();
        private TextField nameInput,
                        brandInput,
                        platenumberInput,
                        quantityInput,
                        spaceInput,
                        gearboxInput,
                        priceInput;

        @Override
        public void start(Stage primaryStage) throws Exception {
                TableColumn<Car, String> nameCol = new TableColumn<>("Név");
                nameCol.setMinWidth(100);
                nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

                TableColumn<Car, String> brandCol = new TableColumn<>("Település");
                brandCol.setMinWidth(100);
                brandCol.setCellValueFactory(new PropertyValueFactory<>("brand"));

                TableColumn<Car, String> platenumberCol = new TableColumn<>("Fizetés");
                platenumberCol.setMinWidth(100);
                platenumberCol.setCellValueFactory(new PropertyValueFactory<>("platenumber"));

                TableColumn<Car, Integer> quantityCol = new TableColumn<>("Mennyiség");
                quantityCol.setMinWidth(50);
                quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));

                TableColumn<Car, Integer> spaceCol = new TableColumn<>("Férőhely");
                spaceCol.setMinWidth(50);
                spaceCol.setCellValueFactory(new PropertyValueFactory<>("space"));

                TableColumn<Car, String> gearboxCol = new TableColumn<>("Váltó");
                gearboxCol.setMinWidth(50);
                gearboxCol.setCellValueFactory(new PropertyValueFactory<>("gearbox"));

                TableColumn<Car, Double> priceCol = new TableColumn<>("Ár");
                priceCol.setMinWidth(50);
                priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

                nameCol.setCellFactory(
                                TextFieldTableCell.<Car>forTableColumn());

                brandCol.setCellFactory(
                                TextFieldTableCell.<Car>forTableColumn());

                platenumberCol.setCellFactory(
                                TextFieldTableCell.<Car>forTableColumn());

                quantityCol.setCellFactory(
                                TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

                spaceCol.setCellFactory(
                                TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

                gearboxCol.setCellFactory(
                                TextFieldTableCell.<Car>forTableColumn());

                priceCol.setCellFactory(
                                TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

                nameCol.setOnEditCommit(
                                new EventHandler<CellEditEvent<Car, String>>() {
                                        @Override
                                        public void handle(CellEditEvent<Car, String> t) {
                                                ((Car) t.getTableView().getItems().get(
                                                                t.getTablePosition().getRow()))
                                                                .setName(t.getNewValue());
                                        }
                                });

                brandCol.setOnEditCommit(
                                new EventHandler<CellEditEvent<Car, String>>() {
                                        @Override
                                        public void handle(CellEditEvent<Car, String> t) {
                                                ((Car) t.getTableView().getItems().get(
                                                                t.getTablePosition().getRow()))
                                                                .setBrand(t.getNewValue());
                                        }
                                });

                platenumberCol.setOnEditCommit(
                                new EventHandler<CellEditEvent<Car, String>>() {
                                        @Override
                                        public void handle(CellEditEvent<Car, String> t) {
                                                ((Car) t.getTableView().getItems().get(
                                                                t.getTablePosition().getRow()))
                                                                .setPlatenumber(t.getNewValue());
                                        }
                                });

                quantityCol.setOnEditCommit(
                                new EventHandler<TableColumn.CellEditEvent<Car, Integer>>() {
                                        @Override
                                        public void handle(CellEditEvent<Car, Integer> event) {
                                                ((Car) event.getTableView().getItems().get(
                                                                event.getTablePosition().getRow()))
                                                                .setQuantity(event.getNewValue());
                                        }
                                });

                spaceCol.setOnEditCommit(
                                new EventHandler<TableColumn.CellEditEvent<Car, Integer>>() {
                                        @Override
                                        public void handle(CellEditEvent<Car, Integer> event) {
                                                ((Car) event.getTableView().getItems().get(
                                                                event.getTablePosition().getRow()))
                                                                .setSpace(event.getNewValue());
                                        }
                                });

                gearboxCol.setOnEditCommit(
                                new EventHandler<TableColumn.CellEditEvent<Car, String>>() {
                                        @Override
                                        public void handle(CellEditEvent<Car, String> event) {
                                                ((Car) event.getTableView().getItems().get(
                                                                event.getTablePosition().getRow()))
                                                                .setGearbox(event.getNewValue());
                                        }
                                });

                priceCol.setOnEditCommit(
                                new EventHandler<TableColumn.CellEditEvent<Car, Double>>() {
                                        @Override
                                        public void handle(CellEditEvent<Car, Double> event) {
                                                ((Car) event.getTableView().getItems().get(
                                                                event.getTablePosition().getRow()))
                                                                .setPrice(event.getNewValue());
                                        }
                                });

                table.setEditable(true);

                nameInput = new TextField();
                nameInput.setPromptText("Név");

                brandInput = new TextField();
                brandInput.setPromptText("Márka");

                platenumberInput = new TextField();
                platenumberInput.setPromptText("Rendszám");

                quantityInput = new TextField();
                quantityInput.setPromptText("Mennyiség");

                spaceInput = new TextField();
                spaceInput.setPromptText("Férőhely");

                gearboxInput = new TextField();
                gearboxInput.setPromptText("Váltó");

                priceInput = new TextField();
                priceInput.setPromptText("Ár");

                Button addButton = new Button("Hozzáad");
                addButton.setOnAction(e -> onClickAddButton());
                Button delButton = new Button("Törlés");
                delButton.setOnAction(e -> onClickDelButton());

                HBox inputBox = new HBox(10);
                inputBox.setPadding(new Insets(10, 10, 10, 10));
                inputBox.setSpacing(10);
                inputBox.getChildren().addAll(
                                nameInput, brandInput, platenumberInput);
                HBox buttonBox = new HBox(10);
                buttonBox.setPadding(new Insets(10, 10, 10, 10));
                buttonBox.setSpacing(10);
                buttonBox.getChildren().addAll(
                                addButton, delButton);

                VBox vbox = new VBox();
                vbox.getChildren().addAll(table, inputBox, buttonBox);

                // table.setItems(getCars());

                table.getColumns().add(nameCol);
                table.getColumns().add(brandCol);
                table.getColumns().add(platenumberCol);
                table.getColumns().add(quantityCol);
                table.getColumns().add(spaceCol);
                table.getColumns().add(gearboxCol);
                table.getColumns().add(priceCol);

                Scene scene = new Scene(vbox, 302, 250);
                primaryStage.setScene(scene);
                primaryStage.show();
        }

        private void onClickAddButton() {
                String name = this.nameInput.getText();
                String brand = this.brandInput.getText();
                String platenumber = this.platenumberInput.getText();
                Integer quantity = Integer.parseInt(this.quantityInput.getText());
                Integer space = Integer.parseInt(this.spaceInput.getText());
                String gearbox = this.gearboxInput.getText();
                Double price = Double.parseDouble(this.priceInput.getText());
                Car car = new Car(name, brand, platenumber, quantity, space, gearbox, price);
                table.getItems().add(car);
                this.nameInput.clear();
                this.brandInput.clear();
                this.platenumberInput.clear();
                this.quantityInput.clear();
                this.spaceInput.clear();
                this.gearboxInput.clear();
                this.priceInput.clear();
        }

        private void onClickDelButton() {
                ObservableList<Car> selectedCar, cars;
                cars = table.getItems();
                selectedCar = table.getSelectionModel().getSelectedItems();
                selectedCar.forEach(cars::remove);
        }

        // private ObservableList<Car> getCars() {

        // ObservableList<Car> carsList =
        // FXCollections.observableArrayList(restapi.getCars());
        // return carsList;
        // }
}
