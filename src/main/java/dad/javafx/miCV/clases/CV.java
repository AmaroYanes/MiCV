package dad.javafx.miCV.clases;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CV {
	
	//private ObjectProperty<Personal> personal = new SimpleObjectProperty<Personal>();
	//private ObjectProperty<Contacto> contacto = new SimpleObjectProperty<Contacto>();
	//Necesariamente deben ser Properties ?
	
	private Personal personal = new Personal();
	private Contacto contacto = new Contacto();
	
	private ListProperty<Titulo> titulo = new SimpleListProperty<Titulo>(FXCollections.observableArrayList());
	private ListProperty<Experiencia> experiencia = new SimpleListProperty<Experiencia>(FXCollections.observableArrayList());
	private ListProperty<Conocimiento> conocimiento = new SimpleListProperty<Conocimiento>(FXCollections.observableArrayList());
	
//	public final ObjectProperty<Personal> personalProperty() {
//		return this.personal;
//	}
//	
//	public final Personal getPersonal() {
//		return this.personalProperty().get();
//		
//	}
//	
//	public final void setPersonal(Personal personal) {
//		this.personalProperty().set(personal);
//	}
//	
//	public final ObjectProperty<Contacto> contactoProperty() {
//		return this.contacto;
//	}
//	
//	public final Contacto getContacto() {
//		return this.contactoProperty().get();
//	}
//	
//	public final void setContacto(Contacto contacto) {
//		this.contactoProperty().set(contacto);
//	}
	
	public final ListProperty<Titulo> tituloProperty() {
		return this.titulo;
	}
	
	public Personal getPersonal() {
		return personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}

	public Contacto getContacto() {
		return contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	public final ObservableList<Titulo> getTitulo() {
		return this.tituloProperty().get();
	}
	
	public final void setTitulo(ObservableList<Titulo> titulo) {
		this.tituloProperty().set(titulo);
	}
	
	public final ListProperty<Experiencia> experienciaProperty() {
		return this.experiencia;
	}
	
	public final ObservableList<Experiencia> getExperiencia() {
		return this.experienciaProperty().get();
	}
	
	public final void setExperiencia(ObservableList<Experiencia> experiencia) {
		this.experienciaProperty().set(experiencia);
	}
	
	public final ListProperty<Conocimiento> conocimientoProperty() {
		return this.conocimiento;
	}
	
	public final ObservableList<Conocimiento> getConocimiento() {
		return this.conocimientoProperty().get();
	}
	
	public final void setConocimiento(ObservableList<Conocimiento> conocimiento) {
		this.conocimientoProperty().set(conocimiento);
	}
	
}
