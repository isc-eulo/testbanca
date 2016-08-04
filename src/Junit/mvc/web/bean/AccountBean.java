package Junit.mvc.web.bean;

public class AccountBean implements java.io.Serializable{
	private Integer Id;
    private String Numero;
    private String Nombre;
    private String Balance;
    private String Estado;
     
 public Integer getId() {
  return Id;
 }
 public void setId(Integer id) {
  this.Id = id;
 }
 public String getNumero() {
  return Numero;
 }
 public void setNumero(String numero) {
  Numero = numero;
 }
 public String getNombre() {
  return Nombre;
 }
 public void setNombre(String nombre) {
  Nombre = nombre;
 }
 public String getBalance() {
  return Balance;
 }
 public void setBalance(String balance) {
  Balance = balance;
 }
 public String getEstado() {
  return Estado;
 }
 public void setEstado(String estado) {
  Estado = estado;
 }

}
