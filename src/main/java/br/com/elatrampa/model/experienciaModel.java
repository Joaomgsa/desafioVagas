package br.com.elatrampa.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="experiencia")
public class ExperienciaModel implements Serializable{
	
	public static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long experienciaId;

	@Column(name = "descricao", nullable = false, length = 250)
	private String descricao;
	
	@Column(name = "experienciaValor", nullable = false)
	private Integer experienciaValor;
	
	public ExperienciaModel() {
		
	}

	public Long getExperienciaId() {
		return experienciaId;
	}

	public void setExperienciaId(Long experienciaId) {
		this.experienciaId = experienciaId;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getExperienciaValor() {
		return experienciaValor;
	}

	public void setExperienciaValor(Integer experienciaValor) {
		this.experienciaValor = experienciaValor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricao, experienciaId, experienciaValor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExperienciaModel other = (ExperienciaModel) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(experienciaId, other.experienciaId)
				&& Objects.equals(experienciaValor, other.experienciaValor);
	}
	
	

}
