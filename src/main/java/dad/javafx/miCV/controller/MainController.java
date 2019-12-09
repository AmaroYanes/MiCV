package dad.javafx.miCV.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.javafx.miCV.clases.CV;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;

public class MainController implements Initializable{
	
	//model
	private static CV curriculum = new CV();
	
	
	//controladores
	private ConocimientosController conocimientosController = new ConocimientosController();
	private ContactoController contactoController  = new ContactoController();
	private ExperienciaController experienciaController = new ExperienciaController();
	private FormacionController formacionController = new FormacionController();
	private PersonalController personalController = new PersonalController();
	
	
	//view
    @FXML
    private VBox view;

    @FXML
    private Menu archivoTab;

    @FXML
    private MenuItem nuevoMenuItem;

    @FXML
    private MenuItem abrirMenuItem;

    @FXML
    private MenuItem guardarMenuItem;

    @FXML
    private MenuItem guardarComoMenuItem;
    
    @FXML
    private Menu ayudaTab;

    @FXML
    private Tab personalTab;

    @FXML
    private Tab contactoTab;

    @FXML
    private Tab formacionTab;

    @FXML
    private Tab experienciaTab;

    @FXML
    private Tab conocimientoTab;
    
    public MainController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainView.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//vista
		personalTab.setContent(personalController.getView());
		contactoTab.setContent(contactoController.getView());
		formacionTab.setContent(formacionController.getView());
		experienciaTab.setContent(experienciaController.getView());
		conocimientoTab.setContent(conocimientosController.getView());
		nuevoMenuItem.setOnAction(e -> OnActionNuevo());
		
		
	}
	
	private void OnActionNuevo() {
		curriculum.tituloProperty().clear();
		curriculum.experienciaProperty().clear();
		curriculum.conocimientoProperty().clear();
		curriculum.getContacto().emailProperty().clear();
		curriculum.getContacto().webProperty().clear();
		curriculum.getContacto().telefonoProperty().clear();
		curriculum.getPersonal().setNombre(new String());
	}

	public static CV getCurriculum() {
		return curriculum;
	}

	public VBox getView() {
		return view;
	}
}
