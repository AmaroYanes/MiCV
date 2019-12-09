package dad.javafx.miCV.clases;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Titulo {
	
	private ObjectProperty<LocalDate> desde;
	private ObjectProperty<LocalDate> hasta;
	private StringProperty denominacion;
	private StringProperty organizador;
	
	public Titulo() {
		desde = new SimpleObjectProperty<LocalDate>();
		hasta = new SimpleObjectProperty<LocalDate>();
		denominacion = new SimpleStringProperty();
		organizador = new SimpleStringProperty();
	}

	public final ObjectProperty<LocalDate> desdeProperty() {
		return this.desde;
	}
	

	public final LocalDate getDesde() {
		return this.desdeProperty().get();
	}
	

	public final void setDesde(final LocalDate desde) {
		this.desdeProperty().set(desde);
	}
	

	public final ObjectProperty<LocalDate> hastaProperty() {
		return this.hasta;
	}
	

	public final LocalDate getHasta() {
		return this.hastaProperty().get();
	}
	

	public final void setHasta(final LocalDate hasta) {
		this.hastaProperty().set(hasta);
	}
	

	public final StringProperty denominacionProperty() {
		return this.denominacion;
	}
	

	public final String getDenominacion() {
		return this.denominacionProperty().get();
	}
	

	public final void setDenominacion(final String denominacion) {
		this.denominacionProperty().set(denominacion);
	}
	

	public final StringProperty organizadorProperty() {
		return this.organizador;
	}
	

	public final String getOrganizador() {
		return this.organizadorProperty().get();
	}
	

	public final void setOrganizador(final String organizador) {
		this.organizadorProperty().set(organizador);
	}
	
}
