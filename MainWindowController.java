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
import javafx.stage.Stage;

public class MainWindowController implements Initializable{

	public MyLogger lg;
	public InsuranceDaoImpl DataBase;
	
	
    @FXML
    private Button CarInsBtn;

    @FXML
    private Button ApartmentInsBtn;

    @FXML
    private Button LifeInsBtn;

    @FXML
    private Button HealthInsBtn;

    @FXML
    private Button ViewAllBtn;
    
    @FXML
    private Button LoadJsonBtn;

    @FXML
    void ApartmentInsHandler(ActionEvent event) {
    	Stage stage;
    	Parent root;
    	
        stage = (Stage) ApartmentInsBtn.getScene().getWindow();
        try {
			root = FXMLLoader.load(getClass().getResource("resources/NewApartmentUI.fxml"));
			Scene scene = new Scene(root);
		    stage.setScene(scene);
		    stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void CarInsHandler(ActionEvent event) {
    	Stage stage;
    	Parent root;
    	
        stage = (Stage) CarInsBtn.getScene().getWindow();
        try {
        	root = FXMLLoader.load(getClass().getResource("resources/NewCarUI.fxml"));
			Scene scene = new Scene(root);
		    stage.setScene(scene);
		    stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
    }

    @FXML
    void HealthInsHandler(ActionEvent event) {
    	Stage stage;
    	Parent root;
    	
        stage = (Stage) HealthInsBtn.getScene().getWindow();
        try {
			root = FXMLLoader.load(getClass().getResource("resources/NewHealthUI.fxml"));
			  Scene scene = new Scene(root);
		      stage.setScene(scene);
		      stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void LifeInsHandler(ActionEvent event) {
    	Stage stage;
    	Parent root;
    	
        stage = (Stage) LifeInsBtn.getScene().getWindow();
        try {
			root = FXMLLoader.load(getClass().getResource("resources/NewLifeUI.fxml"));
			  Scene scene = new Scene(root);
		      stage.setScene(scene);
		      stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
    }

    @FXML
    void ViewAllHandler(ActionEvent event) throws IOException {
    	Stage stage;
    	Parent root;
    	
        stage = (Stage) ViewAllBtn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("resources/ViewAllUI.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    void LoadJsonHandler(ActionEvent event) {
    	DataBase.loadJsonFile();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		this.lg = MyLogger.GetInstance();
		this.DataBase=InsuranceDaoImpl.GetInstance();
	}
	

}
