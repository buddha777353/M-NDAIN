import javafx.application.Application;
import javafx.collections.FXCollections;
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

public class Main extends Application {

    Stage window;
    TableView<Checks> table;
    TextField descriptionInput, amountInput, transfernumInput, dateInput;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("TableTitle - JavaFX");

        //Description column
        TableColumn<Checks, String> descriptionColumn = new TableColumn<>("Description");
        descriptionColumn.setMinWidth(200);
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        //Amount column
        TableColumn<Checks, Double> amountColumn = new TableColumn<>("Amount");
        amountColumn.setMinWidth(100);
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));

        //Transfernum column
        TableColumn<Checks, String> transfernumColumn = new TableColumn<>("Transfernum");
        transfernumColumn.setMinWidth(100);
        transfernumColumn.setCellValueFactory(new PropertyValueFactory<>("transfernum"));
        
        //Date column
        TableColumn<Checks, String> dateColumn = new TableColumn<>("Date");
        dateColumn.setMinWidth(100);
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        //Description input
        descriptionInput = new TextField();
        descriptionInput.setPromptText("Description");
        descriptionInput.setMinWidth(100);

        //Amount input
        amountInput = new TextField();
        amountInput.setPromptText("Amount");

        //Transfernum input
        transfernumInput = new TextField();
        transfernumInput.setPromptText("Transfernum");
        
        //Date input
        dateInput = new TextField();
        dateInput.setPromptText("Date");

        //Buttons
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addButtonClicked());
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteButtonClicked());

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(descriptionInput, amountInput, transfernumInput, dateInput, addButton, deleteButton);

        table = new TableView<>();
        table.setItems(getChecks());
        table.getColumns().addAll(descriptionColumn, amountColumn, transfernumColumn, dateColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table, hBox);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    //Add button clicked
    public void addButtonClicked(){
        Checks checks = new Checks();
        checks.setDescription(descriptionInput.getText());
        checks.setAmount(Double.parseDouble(amountInput.getText()));
        checks.setTransfernum(Integer.parseInt(transfernumInput.getText()));
        checks.setDate(Integer.parseInt(dateInput.getText()));
        table.getItems().add(checks);
        descriptionInput.clear();
        amountInput.clear();
        transfernumInput.clear();
        dateInput.clear();
    }

    //Delete button clicked
    public void deleteButtonClicked(){
        ObservableList<Checks> checksSelected, allCheckss;
        allCheckss = table.getItems();
        checksSelected = table.getSelectionModel().getSelectedItems();

        checksSelected.forEach(allCheckss::remove);
    }

    //Get all of the checkss
    public ObservableList<Checks> getChecks(){
        ObservableList<Checks> checkss = FXCollections.observableArrayList();
        checkss.add(new Checks("First Check", 859.00, 20, 11302016));
        checkss.add(new Checks("Second Check", 2.49, 198, 11302017));
        checkss.add(new Checks("Third Check", 99.00, 74, 11302018));
        checkss.add(new Checks("Fourth Check", 19.99, 12, 11302019));
        checkss.add(new Checks("Fifth Check", 1.49, 856, 11302020));
        return checkss;
    }


}