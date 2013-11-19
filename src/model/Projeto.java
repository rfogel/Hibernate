package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Projeto")
public class Projeto implements ModelPersistenty
{
	int idProjeto; 
	String nomeProjeto;
	List<Empregado> empregados;
	
	@ManyToMany
	@JoinTable(name="Empregado_Projeto", joinColumns={@JoinColumn(name="idProjeto")}, inverseJoinColumns={@JoinColumn(name="idEmpregado")})
	public List<Empregado> getEmpregados() {
		return empregados;
	}
	public void setEmpregados(List<Empregado> empregados) {
		this.empregados = empregados;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getIdProjeto() {
		return idProjeto;
	}
	public void setIdProjeto(int idProjeto) {
		this.idProjeto = idProjeto;
	}
	public String getNomeProjeto() {
		return nomeProjeto;
	}
	public void setNomeProjeto(String nomeProjeto) {
		this.nomeProjeto = nomeProjeto;
	}
	
	
}
