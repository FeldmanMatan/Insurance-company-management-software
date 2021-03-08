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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewLifeController implements Initializable {
	
	public InsuranceDaoImpl DataBase;
	MyLogger lg;
	
    @FXML
    private TextField nameTB;

    @FXML
    private TextField FamilyNameTB;

    @FXML
    private TextField DateTB;

    @FXML
    private TextField RemarkTB;

    @FXML
    private Button BackBtn;

    @FXML
    private Button SaveBtn;

    @FXML
    void BackHandler(ActionEvent event) {
    	Stage stage;
    	Parent root;
        try { 
        	stage = (Stage) BackBtn.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("resources/MainUI.fxml"));
	        Scene scene = new Scene(root);
	        stage.setScene(scene);
	        stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void SaveHandler(ActionEvent event) {
    	String name = nameTB.getText();
    	String LastName = FamilyNameTB.getText();
    	String Date = DateTB.getText();
    	String Remark=RemarkTB.getText();
    	DataBase.addNeInsurance(new Insurance(name,LastName,Date,Remark,"Life"));
    	lg.logger.info("new Life Insurance added name: "+name+" Last name: "+LastName+" Date: "+Date+" Remark: "+Remark);
    	nameTB.clear();
    	FamilyNameTB.clear();
    	DateTB.clear();
    	RemarkTB.clear();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.DataBase = InsuranceDaoImpl.GetInstance();
		this.lg= MyLogger.GetInstance();
	}

}
