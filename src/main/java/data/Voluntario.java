package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class Voluntario {
	
	@javax.persistence.Id
	@GeneratedValue
	private long Id;
	private String Nombre;
	private String Celular;
	private String Email;
	private String Latitud;
	private String Longitud;
	private Boolean Vehiculo;
	private String TipoVehiculo;
	private String PicoPlaca;
	private String PicoCedula;
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getCelular() {
		return Celular;
	}
	public void setCelular(String celular) {
		Celular = celular;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getLatitud() {
		return Latitud;
	}
	public void setLatitud(String latitud) {
		Latitud = latitud;
	}
	public String getLongitud() {
		return Longitud;
	}
	public void setLongitud(String longitud) {
		Longitud = longitud;
	}
	public Boolean getVehiculo() {
		return Vehiculo;
	}
	public void setVehiculo(Boolean vehiculo) {
		Vehiculo = vehiculo;
	}
	public String getTipoVehiculo() {
		return TipoVehiculo;
	}
	public void setTipoVehiculo(String tipoVehiculo) {
		TipoVehiculo = tipoVehiculo;
	}
	public String getPicoPlaca() {
		return PicoPlaca;
	}
	public void setPicoPlaca(String picoPlaca) {
		PicoPlaca = picoPlaca;
	}
	public String getPicoCedula() {
		return PicoCedula;
	}
	public void setPicoCedula(String picoCedula) {
		PicoCedula = picoCedula;
	}
}
