package dad.javafx.miCV.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.ResourceBundle;

import dad.javafx.miCV.clases.CV;
import dad.javafx.miCV.clases.Experiencia;
import dad.javafx.miCV.controller.dialog.ExperienciaDialogController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;

public class ExperienciaController implements Initializable {
	
	//model
	private CV curriculum;
	
	//view
    @FXML
    private HBox view;

    @FXML
    private TableView<Experiencia> experienciaView;

    @FXML
    private TableColumn<Experiencia, LocalDate> desdeColumn;

    @FXML
    private TableColumn<Experiencia,LocalDate> hastaColumn;

    @FXML
    private TableColumn<Experiencia,String> denominacionColumn;

    @FXML
    private TableColumn<Experiencia,String> empleadorColumn;

    @FXML
    private Button anyadirButton;

    @FXML
    private Button eliminarButton;
	
	public ExperienciaController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ExperienciaView.fxml"));
		loader.setController(this);
		loader.load();
	}
	
	public void initialize(URL location, ResourceBundle resources) {
		curriculum = MainController.getCurriculum();
		experienciaView.itemsProperty().bindBidirectional(curriculum.experienciaProperty());
		
		desdeColumn.setCellValueFactory(v -> v.getValue().desdeProperty());

		hastaColumn.setCellValueFactory(v -> v.getValue().hastaProperty());
		
		denominacionColumn.setCellValueFactory(v -> v.getValue().denominacionProperty());
		empleadorColumn.setCellValueFactory(v -> v.getValue().empleadorProperty());
		
		anyadirButton.setOnAction(e -> onActionAnyadir());
		eliminarButton.setOnAction(e -> onActionEliminar());
	}

	private void onActionEliminar() {
		try {
			curriculum.experienciaProperty().remove(experienciaView.getSelectionModel().getSelectedIndex());
		} catch (IndexOutOfBoundsException e ) {

		}
	}

	private void onActionAnyadir() {
		try {
			ExperienciaDialogController dialogo = new ExperienciaDialogController();
			Optional<Experiencia> op = dialogo.showAndWait();
			curriculum.experienciaProperty().add(op.get());
		} catch (NoSuchElementException e) {
		}
	}
	public HBox getView() {
		return view;
	}
	
}
