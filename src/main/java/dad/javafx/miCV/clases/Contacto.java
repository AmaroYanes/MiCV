package dad.javafx.miCV.clases;

import javax.xml.bind.annotation.XmlElement;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Contacto {
	
	private ListProperty<Telefono> telefono;
	private ListProperty<Email> email;
	private ListProperty<Web> web;
	

	public Contacto() {
		telefono = new SimpleListProperty<Telefono>(FXCollections.observableArrayList());
		email = new SimpleListProperty<Email>(FXCollections.observableArrayList());
		web = new SimpleListProperty<Web>(FXCollections.observableArrayList());
	}

	public final ListProperty<Telefono> telefonoProperty() {
		return this.telefono;
	}
	
	@XmlElement
	public final ObservableList<Telefono> getTelefono() {
		return this.telefonoProperty().get();
	}
	

	public final void setTelefono(final ObservableList<Telefono> telefono) {
		this.telefonoProperty().set(telefono);
	}
	

	public final ListProperty<Email> emailProperty() {
		return this.email;
	}
	
	@XmlElement
	public final ObservableList<Email> getEmail() {
		return this.emailProperty().get();
	}
	

	public final void setEmail(final ObservableList<Email> email) {
		this.emailProperty().set(email);
	}
	

	public final ListProperty<Web> webProperty() {
		return this.web;
	}
	
	@XmlElement
	public final ObservableList<Web> getWeb() {
		return this.webProperty().get();
	}
	

	public final void setWeb(final ObservableList<Web> web) {
		this.webProperty().set(web);
	}
	

	
	
}
