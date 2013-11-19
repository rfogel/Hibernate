package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Ferias")
public class Ferias implements ModelPersistenty, Serializable
{ 
	private static final long serialVersionUID = -5263600745803039462L;
	
	Empregado empregado;
	int ano;
	int mes;
	
	@Id
	@ManyToOne
	@JoinColumn(name="idEmpregado")
	public Empregado getEmpregado() {
		return empregado;
	}
	public void setEmpregado(Empregado empregado) {
		this.empregado = empregado;
	}
	@Id
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	
	
}
