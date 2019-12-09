package dad.javafx.miCV.controller.dialog;


import java.io.IOException;

import dad.javafx.miCV.clases.Telefono;
import dad.javafx.miCV.clases.TipoTelefono;
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
import javafx.scene.control.ButtonBar.ButtonData;

public class ContactoTelefonoDialogController extends Dialog<Telefono>{
	
	private ButtonType CREAR_BUTTON_TYPE = new ButtonType("Añadir", ButtonData.OK_DONE);
	
    @FXML
    private DialogPane view;

    @FXML
    private TextField numeroText;

    @FXML
    private ComboBox<TipoTelefono> tipoTelefonoComboBox;
	
    public ContactoTelefonoDialogController() {
		super();
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/DialogConocimientoView.fxml"));
		loader.setController(this);
		try {
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		setTitle("Nuevo Teléfono");
		setHeaderText("Introduce los datos de tu teléfono");
		ListProperty<TipoTelefono> list = new SimpleListProperty<TipoTelefono>(FXCollections.observableArrayList());
		list.addAll(TipoTelefono.values());
		tipoTelefonoComboBox.setItems(list);
		getDialogPane().getButtonTypes().addAll(CREAR_BUTTON_TYPE , ButtonType.CANCEL);
		getDialogPane().setContent(view);
		setResultConverter(dialogButton ->{
			if(dialogButton.getButtonData() == ButtonData.OK_DONE) {
				Telefono telefono = new Telefono();
				telefono.setNumero(numeroText.getText());
				telefono.setTipoTelefono(tipoTelefonoComboBox.getSelectionModel().getSelectedItem());
				return telefono;
			}
			return null;
		});		
	}
}
