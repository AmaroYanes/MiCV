package dad.javafx.miCV.controller.dialog;

import java.io.IOException;

import dad.javafx.miCV.clases.Experiencia;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;

public class ExperienciaDialogController extends Dialog<Experiencia>{

	private ButtonType CREAR_BUTTON_TYPE = new ButtonType("Crear", ButtonData.OK_DONE);
	
    @FXML
    private DialogPane view;

    @FXML
    private TextField denominacionText;

    @FXML
    private TextField empleadorText;

    @FXML
    private DatePicker desdeDatePiker;

    @FXML
    private DatePicker hastaDatePiker;
    
    public ExperienciaDialogController() {
		super();
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/DialogExperienciaView.fxml"));
		loader.setController(this);
		try {
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		setTitle("Nuevo Título");
		setHeaderText("Introduce los datos del nuevo Titulo");
		getDialogPane().getButtonTypes().addAll(CREAR_BUTTON_TYPE , ButtonType.CANCEL);
		getDialogPane().setContent(view);
		setResultConverter(dialogButton ->{
			if(dialogButton.getButtonData() == ButtonData.OK_DONE) {
				Experiencia experiencia = new Experiencia();
				experiencia.setDenominacion(denominacionText.getText());
				experiencia.setEmpleador(empleadorText.getText());
				experiencia.setDesde(desdeDatePiker.getValue());
				experiencia.setHasta(hastaDatePiker.getValue());
				return experiencia;
			}
			return null;
		});		
	}
}
