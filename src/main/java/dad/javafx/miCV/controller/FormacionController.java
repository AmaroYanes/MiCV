package dad.javafx.miCV.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.ResourceBundle;

import dad.javafx.miCV.clases.CV;
import dad.javafx.miCV.clases.Titulo;
import dad.javafx.miCV.controller.dialog.FormacionDialogController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;

public class FormacionController implements Initializable {
   
	//
	
	//Model
	private CV curriculum;
	
	//View
	@FXML
    private HBox view;

    @FXML
    private TableView<Titulo> formacionView;

    @FXML
    private TableColumn<Titulo, LocalDate> desdeColumn;

    @FXML
    private TableColumn<Titulo,LocalDate> hastaColumn;

    @FXML
    private TableColumn<Titulo,String> denominacionColumn;

    @FXML
    private TableColumn<Titulo, String> organizadorColumn;

    @FXML
    private Button anyadirButton;

    @FXML
    private Button eliminarButton;
    
    public FormacionController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FormacionView.fxml"));
		loader.setController(this);
		loader.load();

	}

	public void initialize(URL location, ResourceBundle resources) {
		curriculum = MainController.getCurriculum();
		formacionView.itemsProperty().bindBidirectional(curriculum.tituloProperty());
		
		//columns
		desdeColumn.setCellValueFactory(v -> v.getValue().desdeProperty());
		hastaColumn.setCellValueFactory(v -> v.getValue().hastaProperty());
		denominacionColumn.setCellValueFactory(v -> v.getValue().denominacionProperty());
		organizadorColumn.setCellValueFactory(v -> v.getValue().organizadorProperty());
		
		
		
		//eventos
		
		anyadirButton.setOnAction(e -> onActionAnyadir());
		eliminarButton.setOnAction(e -> onActionEliminar());
	}
	private void onActionEliminar() {
		try {
			curriculum.tituloProperty().remove(formacionView.getSelectionModel().getSelectedIndex());
		} catch (IndexOutOfBoundsException  e) {
		}
	}

	private void onActionAnyadir() {
		try {
			FormacionDialogController dialogo = new FormacionDialogController();
			Optional<Titulo> op = dialogo.showAndWait();
			curriculum.tituloProperty().add(op.get());
		} catch (NoSuchElementException e) {
		}
	}
	public HBox getView() {
		return view;
	}
}
