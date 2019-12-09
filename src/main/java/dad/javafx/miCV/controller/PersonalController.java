package dad.javafx.miCV.controller;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.javafx.miCV.clases.CV;
import dad.javafx.miCV.clases.Nacionalidad;
import dad.javafx.miCV.clases.Titulo;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PersonalController implements Initializable{
	
	private CV curriculum = MainController.getCurriculum();
	
    @FXML
    private GridPane view;

    @FXML
    private TextField nombreTextField;

    @FXML
    private TextField apellidosTextField;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextArea direccionArea;

    @FXML
    private ListView<Nacionalidad> nacionalidadListView;

    @FXML
    private TextField dniTextField;

    @FXML
    private TextField codigoPostalTextField;

    @FXML
    private TextField localidadTextField;

    @FXML
   
    private ComboBox<String> paisTextField;
    
    public PersonalController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PersonalView.fxml"));
		loader.setController(this);
		loader.load();
	}
    public void initialize(URL location, ResourceBundle resources) {
    	
    	nombreTextField.textProperty().bindBidirectional(curriculum.getPersonal().nombreProperty());
    	apellidosTextField.textProperty().bindBidirectional(curriculum.getPersonal().apellidosProperty());
    	datePicker.valueProperty().bindBidirectional(curriculum.getPersonal().fechaNacimientoProperty());
    	direccionArea.textProperty().bindBidirectional(curriculum.getPersonal().direccionProperty());
    	nacionalidadListView.itemsProperty().bindBidirectional(curriculum.getPersonal().nacionalidadProperty());
    	dniTextField.textProperty().bindBidirectional(curriculum.getPersonal().identificacionProperty());
    	codigoPostalTextField.textProperty().bindBidirectional(curriculum.getPersonal().codigoPostalProperty());
    	localidadTextField.textProperty().bindBidirectional(curriculum.getPersonal().localidadProperty());
    	// falta setearlo
    	leerPaises();
    	curriculum.getPersonal().paisProperty().bind(paisTextField.getSelectionModel().selectedItemProperty()); 
	}
    
	public GridPane getView() {
		return view;
	}

	private void leerPaises() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(getClass().getResource("/recursos/paises.csv").getPath()));
			ListProperty<String> list = new SimpleListProperty<String>(FXCollections.observableArrayList());
			String line;
			while((line = br.readLine())!= null) {
				list.add(line);
			}
			paisTextField.setItems(list);
		} catch (IOException e) {
			e.printStackTrace();

		}
	}
	public void setPais(String pais) {
		paisTextField.setValue(pais);
		
	}

}
