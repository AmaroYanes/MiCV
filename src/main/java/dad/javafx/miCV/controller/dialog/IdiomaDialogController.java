package dad.javafx.miCV.controller.dialog;


import java.io.IOException;
import dad.javafx.miCV.clases.Idioma;
import dad.javafx.miCV.clases.Nivel;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;

public class IdiomaDialogController extends Dialog<Idioma>{
	
	private ButtonType CREAR_BUTTON_TYPE = new ButtonType("Crear", ButtonData.OK_DONE);
	
    @FXML
    private DialogPane view;

    @FXML
    private TextField denominacionText;

    @FXML
    private ComboBox<Nivel> nivelComboBox;

    @FXML
    private Button resetButton;
    
    @FXML
    private TextField certificacionText;
	
    public IdiomaDialogController() {
		super();
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/DialogIdiomaView.fxml"));
		loader.setController(this);
		try {
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		resetButton.setOnAction(e -> onActionReset());
		setTitle("Nuevo Título");
		setHeaderText("Introduce los datos del nuevo Titulo");
		ListProperty<Nivel> list = new SimpleListProperty<Nivel>(FXCollections.observableArrayList());
		list.addAll(Nivel.values());
		nivelComboBox.setItems(list);
		getDialogPane().getButtonTypes().addAll(CREAR_BUTTON_TYPE , ButtonType.CANCEL);
		getDialogPane().setContent(view);
		setResultConverter(dialogButton ->{
			if(dialogButton.getButtonData() == ButtonData.OK_DONE) {
				Idioma idioma = new Idioma();
				idioma.setDenominacion(denominacionText.getText());
				idioma.setNivel(nivelComboBox.getSelectionModel().getSelectedItem());
				idioma.setCertificacion(certificacionText.getText());
				return idioma;
			}
			return null;
		});		
	}

	private void onActionReset() {
		nivelComboBox.setValue(null);
	}
}
