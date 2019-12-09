package dad.javafx.miCV.controller;

import java.io.IOException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.ResourceBundle;

import dad.javafx.miCV.clases.CV;
import dad.javafx.miCV.clases.Conocimiento;
import dad.javafx.miCV.clases.Idioma;
import dad.javafx.miCV.clases.Nivel;
import dad.javafx.miCV.clases.Titulo;
import dad.javafx.miCV.controller.dialog.ConocimientoDialogController;
import dad.javafx.miCV.controller.dialog.FormacionDialogController;
import dad.javafx.miCV.controller.dialog.IdiomaDialogController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;

public class ConocimientosController implements Initializable {
	
	//Model
	
	private CV curriculum;
	
	//view
    @FXML
    private HBox view;

    @FXML
    private TableView<Conocimiento> conocimientoView;

    @FXML
    private TableColumn<Conocimiento, String> denominacionColumn;

    @FXML
    private TableColumn<Conocimiento, Nivel> nivelColumn;

    @FXML
    private Button anyadirconocimientoButton;

    @FXML
    private Button anyadirIdiomaButton;

    @FXML
    private Button eliminarButton1;
    
	public ConocimientosController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ConocimientosView.fxml"));
		loader.setController(this);
		loader.load();
	}
	
	public void initialize(URL location, ResourceBundle resources) {
		curriculum = MainController.getCurriculum(); 
		conocimientoView.itemsProperty().bindBidirectional(curriculum.conocimientoProperty());
				
		denominacionColumn.setCellValueFactory(v -> v.getValue().denominacionProperty());
		nivelColumn.setCellValueFactory(v -> v.getValue().nivelProperty());
		
		anyadirconocimientoButton.setOnAction(e -> onActionAnyadirConocimiento());
		anyadirIdiomaButton.setOnAction(e -> onActionAnyadirIdioma());
		eliminarButton1.setOnAction(e -> onActionEliminar());
		
	}

	private void onActionEliminar() {
		try {
			curriculum.conocimientoProperty().remove(conocimientoView.getSelectionModel().getSelectedIndex());
	
		}catch (IndexOutOfBoundsException e) {
			
		}
	}
	private void onActionAnyadirIdioma() {
		try {
			IdiomaDialogController dialogo = new IdiomaDialogController();
			Optional<Idioma> op = dialogo.showAndWait();
			Idioma nuevo = op.get();
			nuevo.setDenominacion(nuevo.getDenominacion()+"("+nuevo.getCertificacion()+")");
			curriculum.conocimientoProperty().add(nuevo);
		} catch (NoSuchElementException e) {
		}
	}

	private void onActionAnyadirConocimiento() {
		try {
			ConocimientoDialogController dialogo = new ConocimientoDialogController();
			Optional<Conocimiento> op = dialogo.showAndWait();
			curriculum.conocimientoProperty().add(op.get());
		} catch (NoSuchElementException e) {
		}
	}

	public TableView<Conocimiento> getConocimientoView() {
		return conocimientoView;
	}
	public HBox getView() {
		return view;
	}
}
