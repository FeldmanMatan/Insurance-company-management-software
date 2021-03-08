package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ViewAllController implements Initializable{

	public InsuranceDaoImpl DataBase;
	
	
	
    @FXML
    private TableView<Insurance> table;

    @FXML
    private TableColumn<Insurance, String> colName;

    @FXML
    private TableColumn<Insurance, String> colFamilyName;

    @FXML
    private TableColumn<Insurance, String> colDate;

    @FXML
    private TableColumn<Insurance, String> colRemarks;

    @FXML
    private Button backBtn;

    @FXML
    void backHandler(ActionEvent event) {
    	
    	Stage stage;
    	Parent root;
        try { 
        	stage = (Stage) backBtn.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("resources/MainUI.fxml"));
	        Scene scene = new Scene(root);
	        stage.setScene(scene);
	        stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		this.DataBase=InsuranceDaoImpl.GetInstance();
		colName.setCellValueFactory(new PropertyValueFactory<Insurance, String>("Name"));
		colFamilyName.setCellValueFactory(new PropertyValueFactory<Insurance, String>("LastName"));
		colDate.setCellValueFactory(new PropertyValueFactory<Insurance, String>("date"));
		colRemarks.setCellValueFactory(new PropertyValueFactory<Insurance,String >("Remarks"));
		table.getItems().setAll(DataBase.getAllInsurance());
	}

}
