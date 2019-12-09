package dad.javafx.miCV.controller;

import java.io.IOException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.ResourceBundle;

import dad.javafx.miCV.clases.CV;
import dad.javafx.miCV.clases.Email;
import dad.javafx.miCV.clases.Telefono;
import dad.javafx.miCV.clases.TipoTelefono;
import dad.javafx.miCV.clases.Web;
import dad.javafx.miCV.controller.dialog.ContactoTelefonoDialogController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;

public class ContactoController implements Initializable {
	
	//Model
	private CV curriculum;
	
	//view
    @FXML
    private BorderPane view;

    @FXML
    private TableView<Telefono> telefonoTable;

    @FXML
    private TableColumn<Telefono,String> numeroColumn;

    @FXML
    private TableColumn<Telefono,TipoTelefono> tipoColumn;

    @FXML
    private TableView<Email> emailTable;

    @FXML
    private TableColumn<Email, String> emailColumn;

    @FXML
    private TableView<Web> urlTable;

    @FXML
    private TableColumn<Web, String> urlColumn;
    
    @FXML
    private Button anyadirTelefono;

    @FXML
    private Button eliminarTelefono;

   @FXML
    private Button anyadirEmail;

    @FXML
    private Button eliminarEmail;

    @FXML
    private Button anyadirWeb;

    @FXML
    private Button eliminarWeb;
	
	public ContactoController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ContactoView.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		curriculum = MainController.getCurriculum();
		
		//telefono
	
		numeroColumn.setCellValueFactory(v -> v.getValue().numeroProperty());
		tipoColumn.setCellValueFactory(v -> v.getValue().tipoTelefonoProperty());
		
		telefonoTable.itemsProperty().bindBidirectional(curriculum.getContacto().telefonoProperty());
		
		anyadirTelefono.setOnAction(e -> onActionAnyadirTelefono());
		eliminarTelefono.setOnAction(e -> onActionEliminarTelefono());
		//email
		emailColumn.setCellValueFactory(v -> v.getValue().direccionProperty());
		
		emailTable.itemsProperty().bindBidirectional(curriculum.getContacto().emailProperty());
		
		anyadirEmail.setOnAction(e -> onActionAnyadirEmail());
		eliminarEmail.setOnAction(e -> onActionEliminarEmail());
		//Web
		urlColumn.setCellValueFactory(v -> v.getValue().urlProperty());
		
		urlTable.itemsProperty().bindBidirectional(curriculum.getContacto().webProperty());
		
		anyadirWeb.setOnAction(e -> onActionAnyadirWeb());
		eliminarWeb.setOnAction(e -> onActionEliminarWeb());
		
		
	}


	private void onActionEliminarWeb() {
		try {
			curriculum.getContacto().webProperty().remove(urlTable.getSelectionModel().getSelectedIndex());
		} catch (IndexOutOfBoundsException e) {
		}
	}

	private void onActionAnyadirWeb() {
		try {
			TextInputDialog dialog = new TextInputDialog("http://");
			dialog.setTitle("nueva Web");
			dialog.setHeaderText("Web");
			dialog.setContentText("introduce la URL de tu Web");
			Optional<String> result = dialog.showAndWait();
			Web nuevo = new Web();
			nuevo.setUrl(result.get());
			curriculum.getContacto().webProperty().add(nuevo);
		} catch (NoSuchElementException e) {
		}
	}

	private void onActionEliminarEmail() {
		try {
			curriculum.getContacto().emailProperty().remove(emailTable.getSelectionModel().getSelectedIndex());
		} catch (IndexOutOfBoundsException e) {
		}
	}

	private void onActionAnyadirEmail() {
		try {
			TextInputDialog dialog = new TextInputDialog();
			dialog.setTitle("nueva Email");
			dialog.setHeaderText("Email");
			dialog.setContentText("introduce tu direccion de corre electronico");
			Optional<String> result = dialog.showAndWait();
			Email nuevo = new Email();
			nuevo.setDireccion(result.get());
			curriculum.getContacto().emailProperty().add(nuevo);
		} catch (NoSuchElementException e) {
		}
	}

	private void onActionEliminarTelefono() {
		try {
			curriculum.getContacto().telefonoProperty().remove(telefonoTable.getSelectionModel().getSelectedIndex());
		} catch (IndexOutOfBoundsException e) {
		}
	}

	private void onActionAnyadirTelefono() {
		try {
			ContactoTelefonoDialogController dialog = new ContactoTelefonoDialogController();
			Optional<Telefono> result = dialog.showAndWait();
			curriculum.getContacto().telefonoProperty().add(result.get());
		} catch (NoSuchElementException e) {
		}
	}
	public BorderPane getView() {
		return view;
	}
}
