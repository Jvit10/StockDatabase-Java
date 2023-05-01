import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import java.io.*;

import javafx.collections.transformation.SortedList;
import javafx.stage.FileChooser;



public class DatabaseInterfaceController {


        @FXML
        private Button Clear;

        @FXML
        private TableColumn<Info, String> Company;

        @FXML
        private Button Delete;
        @FXML
        private TextField CompanyTextField;
        @FXML
        private TextField StockPriceTextField;
        @FXML
        private TextField SharesTextField;
        @FXML
        private TextField InvestedTextField;
        @FXML
        private TextField GainLossTextField;
        @FXML
        private TextField TotalGainLossTextField;
        @FXML
        private Button Find;
        @FXML
        private TextField FindSeach;

        @FXML
        private TableColumn<Info, String> GainLoss;

        @FXML
        private TableColumn<Info, String> Invested;

        @FXML
        private Button OpenFile;

        @FXML
        private Button Save;

        @FXML
        private Button SaveAs;

        @FXML
        private TableColumn<Info, String> Shares;

        @FXML
        private TableColumn<Info, String> StockPrice;

        @FXML
        private javafx.scene.control.TableView<Info> TableView;

        @FXML
        private TableColumn<Info, String> TotalGainLoss;

        @FXML
        private Button Update;

        @FXML
        void OpenFileClick(ActionEvent event) throws IOException {
            //creates a new file
            File dataFile = new File("importedData.txt");
            try {
                dataFile.createNewFile();
            }
            catch (IOException e) {
                System.out.println("Error creating file");
            }
            //makes a new fileChooser
            FileChooser file = new FileChooser();
            //sets the title of the file chooser
            file.setTitle("Select File");
            //sets the intial directory and opens a dialog window
            file.setInitialDirectory(new File("."));
            File read1= file.showOpenDialog(OpenFile.getScene().getWindow());
            //contentTable

            //creates new fileReaders and file writers
            FileReader readFile = new FileReader(read1);
            FileWriter writeFile = new FileWriter("importedData.txt", true);
            int counter;
            //writes the information from the choosen file to a file in the importedData.txt file
            while ((counter = readFile.read()) != -1) {
                writeFile.write(counter);
            }
            //closes both files
            readFile.close();
            writeFile.close();
        }


        @FXML
        void SaveClick(ActionEvent event) {

        }


    @FXML
    /* clears data in the textbox fields */
    void clearButtonClick(ActionEvent event) {

        CompanyTextField.clear();
        StockPriceTextField.clear();
        SharesTextField.clear();
        InvestedTextField.clear();
        GainLossTextField.clear();
        TotalGainLossTextField.clear();

    }


                    /* deletes an entry when it is selected */
                    @FXML
                    void deleteButtonClick(ActionEvent event) {
                        TableView.setItems(stocks);
                        Info item = TableView.getSelectionModel().getSelectedItem();
                        TableView.getItems().remove(item);




                    }

                    @FXML
                        //todo find button
                    void findButtonClick(ActionEvent event) {


                           // Observable list stocks is wrapped into the filterList<Info>
                          /* FilteredList<Info> filtered = new FilteredList<>(stocks, c -> true);
                           //adds a listener field to the textproperty field in the lastNametextfield
                           stocks.Company().textProperty().addListener((observable, oldValue, newValue) -> {
                               filtered.setPredicate(stock -> {
                                   // if it is empty, display all the rows

                                   if (newValue == null || newValue.isEmpty()) {
                                       return true;
                                   }
                                   //puts the value to lowercase
                                   String lowercase = newValue.toLowerCase();
                                   if (FindSeach.contains().toLowerCase().indexOf(lowercase) != -1) {
                                       return true;
                                   } else
                                       return false;
                               });
                           });

                           //put the filtered list into a sorted list
                           SortedList<Info> sortedNames = new SortedList<>(filtered);

                           //bind the sortedNames to the content table
                           sortedNames.comparatorProperty().bind(TableView.comparatorProperty());

                           //bind the sortedNames to the cotent table so that it appears on the screen
                           TableView.setItems(sortedNames);
*/






                    }

                    @FXML

                    void updateButtonClick(ActionEvent event) {


                        //modifies entry assuming all boxes are empty
                        String length1 = CompanyTextField.getText();


                        if (length1.length() == 0) {
                            TablePosition selected = TableView.getSelectionModel().getSelectedCells().get(0);

                            int row = selected.getRow();
                            Info item = TableView.getItems().get(row);


                            //configures modify variables
                            String modifyCompany = (String) item.getCompany();
                            String modifyStockPrice = (String) item.getStockPrice();
                            String modifyShares = (String) item.getShares();
                            String modifyInvested = (String) item.getInvested();
                            String modifyGainloss = (String) item.getGainLoss();
                            String modifyTotalGainLoss = (String) item.getTotalGainLoss();


                            //sets the modify variables to the textfields
                            CompanyTextField.setText(modifyCompany);
                            StockPriceTextField.setText(modifyStockPrice);
                            SharesTextField.setText(modifyShares);
                            InvestedTextField.setText(modifyInvested);
                            GainLossTextField.setText(modifyGainloss);
                            TotalGainLossTextField.setText(modifyTotalGainLoss);

                            Info item1 = TableView.getSelectionModel().getSelectedItem();
                            //removes the selected item
                            TableView.getItems().remove(item1);


                        } else {
                            //NOTE: WHITESPACE AFTER ENTRY'S WILL DISPLAY THE ERROR MESSAGE

                            //validation, compares text fields to validation parameters in validateInput.java
                            //if all the text fields have correct validation, then the program proceeds to the else statement
//adds a new entry

                                //associates textfields with variables
                                String UpdateCompany = CompanyTextField.getText();
                                String UpdateStockPrice = StockPriceTextField.getText();
                                String UpdateShares = SharesTextField.getText();
                                String UpdateInvested = InvestedTextField.getText();
                                String UpdateGainLoss = GainLossTextField.getText();
                                String UpdateTotalGainLoss = TotalGainLossTextField.getText();

                                //adds a new info (containing updated variables) to the observableList "stock"
                                stocks.add(new Info(UpdateCompany, UpdateStockPrice, UpdateShares, UpdateInvested, UpdateGainLoss, UpdateTotalGainLoss));
                                //binds the people list to the content table
                                TableView.setItems(stocks);

                            }
                        }


                    private static final ObservableList<Info> stocks =
                            FXCollections.observableArrayList();
                    public static ObservableList<Info> getAllPeople() {
                        return stocks;
                    }

                    // initialize controller
                    public void initialize() {



        /* initalizes each of the columns, sets the cellValue to a new property value of the observableList<Info>Stocks
           and references the variables from info.java

        */

                        Company.setCellValueFactory(new PropertyValueFactory<Info, String>("Company"));
                        StockPrice.setCellValueFactory(new PropertyValueFactory<Info, String>("StockPrice"));
                        Shares.setCellValueFactory(new PropertyValueFactory<Info, String>("Shares"));
                        Invested.setCellValueFactory(new PropertyValueFactory<Info, String>("Invested"));
                        GainLoss.setCellValueFactory(new PropertyValueFactory<Info, String>("GainLoss"));
                        TotalGainLoss.setCellValueFactory(new PropertyValueFactory<Info, String>("TotalGainLoss"));

                    }

                }

