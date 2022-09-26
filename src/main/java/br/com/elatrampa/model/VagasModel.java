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
@Table(name="Vagas")

public class VagasModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vagaId;
	
	@Column(name = "empresa", nullable=false, length=180)
	private String empresa;
	
	@Column(name = "tituloVaga", nullable=false, length=250)
	private String tituloVaga;
	
	@Column(name = "descricaoVaga", nullable=false, length=250)
	private String descricaoVaga;
	
	@Column(name = "localizacaoVaga", nullable=false, length=1)	
	private String localizacaoVaga;
	
	@Column(name = "experienciaVaga", nullable=false)
	private Integer experienciaVaga;
	
	public VagasModel() {
		
	}

	public Long getVagaId() {
		return vagaId;
	}

	public void setVagaId(Long vagaId) {
		this.vagaId = vagaId;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getTituloVaga() {
		return tituloVaga;
	}

	public void setTituloVaga(String tituloVaga) {
		this.tituloVaga = tituloVaga;
	}

	public String getDescricaoVaga() {
		return descricaoVaga;
	}

	public void setDescricaoVaga(String descricaoVaga) {
		this.descricaoVaga = descricaoVaga;
	}

	public String getLocalizacaoVaga() {
		return localizacaoVaga;
	}

	public void setLocalizacaoVaga(String localizacaoVaga) {
		this.localizacaoVaga = localizacaoVaga;
	}

	public Integer getExperienciaVaga() {
		return experienciaVaga;
	}

	public void setExperienciaVaga(Integer experienciaVaga) {
		this.experienciaVaga = experienciaVaga;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricaoVaga, empresa, experienciaVaga, localizacaoVaga, tituloVaga, vagaId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VagasModel other = (VagasModel) obj;
		return Objects.equals(descricaoVaga, other.descricaoVaga) && Objects.equals(empresa, other.empresa)
				&& Objects.equals(experienciaVaga, other.experienciaVaga)
				&& Objects.equals(localizacaoVaga, other.localizacaoVaga)
				&& Objects.equals(tituloVaga, other.tituloVaga) && Objects.equals(vagaId, other.vagaId);
	}

	



}
