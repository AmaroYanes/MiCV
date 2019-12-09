package dad.javafx.miCV.clases;

import javax.xml.bind.annotation.XmlAttribute;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Telefono {
	private StringProperty numero;
	private ObjectProperty<TipoTelefono> tipoTelefono;
	
	public Telefono() {
	numero = new SimpleStringProperty();
	tipoTelefono = new SimpleObjectProperty<TipoTelefono>();
	
	}

	public final StringProperty numeroProperty() {
		return this.numero;
	}
	
	@XmlAttribute
	public final String getNumero() {
		return this.numeroProperty().get();
	}
	

	public final void setNumero(final String numero) {
		this.numeroProperty().set(numero);
	}
	

	public final ObjectProperty<TipoTelefono> tipoTelefonoProperty() {
		return this.tipoTelefono;
	}
	
	@XmlAttribute
	public final TipoTelefono getTipoTelefono() {
		return this.tipoTelefonoProperty().get();
	}
	

	public final void setTipoTelefono(final TipoTelefono tipoTelefono) {
		this.tipoTelefonoProperty().set(tipoTelefono);
	}
	
}
