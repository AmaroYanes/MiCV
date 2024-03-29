package dad.javafx.miCV.clases;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import dad.javafx.miCV.controller.LocalDateAdapter;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Personal {
	
	private StringProperty identificacion;
	private StringProperty nombre;
	private StringProperty apellidos;
	private ObjectProperty<LocalDate> fechaNacimiento;
	private StringProperty direccion;
	private StringProperty codigoPostal;
	private StringProperty localidad;
	private StringProperty pais;
	private ListProperty<Nacionalidad> nacionalidad;
	
	public Personal() {
		
		identificacion = new SimpleStringProperty();
		nombre = new SimpleStringProperty();
		apellidos = new SimpleStringProperty();
		fechaNacimiento = new SimpleObjectProperty<LocalDate>();
		direccion = new SimpleStringProperty();
		codigoPostal = new SimpleStringProperty();
		localidad = new SimpleStringProperty();
		pais = new SimpleStringProperty();
		nacionalidad = new SimpleListProperty<Nacionalidad>(FXCollections.observableArrayList());
		
	}

	public final StringProperty identificacionProperty() {
		return this.identificacion;
	}
	
	@XmlElement
	public final String getIdentificacion() {
		return this.identificacionProperty().get();
	}
	

	public final void setIdentificacion(final String identificacion) {
		this.identificacionProperty().set(identificacion);
	}
	

	public final StringProperty nombreProperty() {
		return this.nombre;
	}
	
	@XmlElement
	public final String getNombre() {
		return this.nombreProperty().get();
	}
	

	public final void setNombre(final String nombre) {
		this.nombreProperty().set(nombre);
	}
	

	public final StringProperty apellidosProperty() {
		return this.apellidos;
	}
	
	@XmlElement
	public final String getApellidos() {
		return this.apellidosProperty().get();
	}
	

	public final void setApellidos(final String apellidos) {
		this.apellidosProperty().set(apellidos);
	}
	

	public final ObjectProperty<LocalDate> fechaNacimientoProperty() {
		return this.fechaNacimiento;
	}
	
	@XmlElement
	@XmlJavaTypeAdapter(value = LocalDateAdapter.class)
	public final LocalDate getFechaNacimiento() {
		return this.fechaNacimientoProperty().get();
	}
	

	public final void setFechaNacimiento(final LocalDate fechaNacimiento) {
		this.fechaNacimientoProperty().set(fechaNacimiento);
	}
	

	public final StringProperty direccionProperty() {
		return this.direccion;
	}
	
	@XmlElement
	public final String getDireccion() {
		return this.direccionProperty().get();
	}
	

	public final void setDireccion(final String direccion) {
		this.direccionProperty().set(direccion);
	}
	

	public final StringProperty codigoPostalProperty() {
		return this.codigoPostal;
	}
	
	@XmlElement
	public final String getCodigoPostal() {
		return this.codigoPostalProperty().get();
	}
	

	public final void setCodigoPostal(final String codigoPostal) {
		this.codigoPostalProperty().set(codigoPostal);
	}
	

	public final StringProperty localidadProperty() {
		return this.localidad;
	}
	
	@XmlElement
	public final String getLocalidad() {
		return this.localidadProperty().get();
	}
	

	public final void setLocalidad(final String localidad) {
		this.localidadProperty().set(localidad);
	}
	

	public final StringProperty paisProperty() {
		return this.pais;
	}
	
	@XmlElement
	public final String getPais() {
		return this.paisProperty().get();
	}
	

	public final void setPais(final String pais) {
		this.paisProperty().set(pais);
	}

	public final ListProperty<Nacionalidad> nacionalidadProperty() {
		return this.nacionalidad;
	}
	
	@XmlElement
	public final ObservableList<Nacionalidad> getNacionalidad() {
		return this.nacionalidadProperty().get();
	}
	

	public final void setNacionalidad(final ObservableList<Nacionalidad> nacionalidad) {
		this.nacionalidadProperty().set(nacionalidad);
	}
	
	
}
