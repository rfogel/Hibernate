package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Empregado")
public class Empregado implements ModelPersistenty
{	
	int idEmpregado;
	String nomeEmpregado;
	int numeroDependentes;
	double salario;
	Departamento departamento;
	List<Projeto> projetos;
	List<Ferias> ferias;
	
	@OneToMany(targetEntity=Ferias.class, mappedBy="empregado", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	public List<Ferias> getFerias() {
		return ferias;
	}
	public void setFerias(List<Ferias> ferias) {
		this.ferias = ferias;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getIdEmpregado() {
		return idEmpregado;
	}
	public void setIdEmpregado(int idEmpregado) {
		this.idEmpregado = idEmpregado;
	}
	public String getNomeEmpregado() {
		return nomeEmpregado;
	}
	public void setNomeEmpregado(String nomeEmpregado) {
		this.nomeEmpregado = nomeEmpregado;
	}
	public int getNumeroDependentes() {
		return numeroDependentes;
	}
	public void setNumeroDependentes(int numeroDependentes) {
		this.numeroDependentes = numeroDependentes;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}	
	
	@ManyToMany
	@JoinTable(name="Empregado_Projeto", inverseJoinColumns={@JoinColumn(name="idProjeto")}, joinColumns={@JoinColumn(name="idEmpregado")})
	public List<Projeto> getProjetos() {
		return projetos;
	}
	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}
	@ManyToOne
	@JoinColumn(name="idDepartamento")
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

}
