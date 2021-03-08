package application;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class InsuranceDaoImpl implements InsuranceDao {

	private static InsuranceDaoImpl instance;
	List<Insurance> insurances;
	MyLogger lg;
	
	private InsuranceDaoImpl() {
		// TODO Auto-generated constructor stub
		this.lg=MyLogger.GetInstance();
		this.insurances=new ArrayList<>();
	}
	
	@Override
	public List<Insurance> getAllInsurance() {
		return insurances;
	}

	@Override
	public Insurance getInsuranceByIndex(int number) {
		// TODO Auto-generated method stub
		return insurances.get(number);
	}

	@Override
	public void addNeInsurance(Insurance insurance) {
		// TODO Auto-generated method stub
		insurances.add(insurance);
		
	}

	@Override
	public void deleteInsurance(Insurance insurance) {
		// TODO Auto-generated method stub
		insurances.remove(insurance);
	}
	
	public static InsuranceDaoImpl GetInstance() {
		if(instance == null )
			instance = new InsuranceDaoImpl();
		return instance;
	}
	
	public void loadJsonFile() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fileChooser.showOpenDialog(fileChooser);
		if (result == JFileChooser.APPROVE_OPTION) {
		    File selectedFile = fileChooser.getSelectedFile();
			JSONParser parser = new JSONParser();
			try {
		    JSONArray a = (JSONArray) parser.parse(new FileReader(selectedFile.getAbsolutePath()));
			for (Object o : a)
				  {
				    JSONObject person = (JSONObject) o;
				    addNeInsurance(new Insurance((String) person.get("name"), (String) person.get("LastName"), (String)person.get("Date"), (String) person.get("Remarks"), (String) person.get("Type")));
				 } 	  
			}
			catch ( IOException e) {
				e.printStackTrace(); 
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
