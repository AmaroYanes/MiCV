package dad.javafx.miCV.controller.dialog;

import java.io.IOException;
import dad.javafx.miCV.clases.Titulo;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;

public class FormacionDialogController extends Dialog<Titulo>{
	
	
	private ButtonType CREAR_BUTTON_TYPE = new ButtonType("Crear", ButtonData.OK_DONE);
	
    @FXML
    private DialogPane view;

    @FXML
    private TextField denominacionText;

    @FXML
    private TextField organizadorText;

    @FXML
    private DatePicker desdeDatePiker;

    @FXML
    private DatePicker hastaDatePiker;
	
	
    public FormacionDialogController() {
		super();
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/DialogFormacionView.fxml"));
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
				Titulo titulo = new Titulo();
				titulo.setDenominacion(denominacionText.getText());
				titulo.setOrganizador(organizadorText.getText());
				titulo.setDesde(desdeDatePiker.getValue());
				titulo.setHasta(hastaDatePiker.getValue());
				return titulo;
			}
			return null;
		});		
	}
}
