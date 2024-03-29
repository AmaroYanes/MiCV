package dad.javafx.miCV.clases;

import javax.xml.bind.annotation.XmlAttribute;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Nacionalidad {
	private StringProperty denominacion;
	public Nacionalidad() {
		denominacion = new SimpleStringProperty();
	}
	public final StringProperty denominacionProperty() {
		return this.denominacion;
	}
	@XmlAttribute
	public final String getDenominacion() {
		return this.denominacionProperty().get();
	}
	
	public final void setDenominacion(final String denominacion) {
		this.denominacionProperty().set(denominacion);
	}
	
}
