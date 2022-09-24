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
@Table(name="localidade")
public class LocalidadeModel implements Serializable {
	
	public static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long localidadeId;
	
	@Column(name = "localidade", nullable = false, length = 1)
	private String localidade;
	
	@Column(name = "distancia", nullable = false)
	private Integer distancia;
	
	public LocalidadeModel() {
		
	}

	public Long getLocalidadeId() {
		return localidadeId;
	}

	public void setLocalidadeId(Long localidadeId) {
		this.localidadeId = localidadeId;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public Integer getDistancia() {
		return distancia;
	}

	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(distancia, localidade, localidadeId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LocalidadeModel other = (LocalidadeModel) obj;
		return Objects.equals(distancia, other.distancia) && Objects.equals(localidade, other.localidade)
				&& Objects.equals(localidadeId, other.localidadeId);
	}
	
	
	
}
