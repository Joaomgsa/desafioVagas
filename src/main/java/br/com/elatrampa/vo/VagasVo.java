package br.com.elatrampa.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Objects;

import org.dozer.Mapping;


@JsonPropertyOrder({ "vagaId", "empresa", "tituloVaga", "descricaoVaga", "localizacaoVaga", "experienciaVaga" })
public class VagasVo extends RepresentationModel<VagasVo> implements Serializable{
	
		private static final long serialVersionUID = 1L;
		
		
		@Mapping("vagaId")
		@JsonProperty("vagaId")
		private Long vagaKey;
		private String empresa;
		private String tituloVaga;
		private String descricaoVaga;
		private String localizacaoVaga;
		private Integer experienciaVaga;
		
		
		public VagasVo() {
		}


		public Long getVagaKey() {
			return vagaKey;
		}


		public void setVagaKey(Long vagaKey) {
			this.vagaKey = vagaKey;
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
			final int prime = 31;
			int result = super.hashCode();
			result = prime * result
					+ Objects.hash(descricaoVaga, empresa, experienciaVaga, localizacaoVaga, tituloVaga, vagaKey);
			return result;
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!super.equals(obj))
				return false;
			if (getClass() != obj.getClass())
				return false;
			VagasVo other = (VagasVo) obj;
			return Objects.equals(descricaoVaga, other.descricaoVaga) && Objects.equals(empresa, other.empresa)
					&& Objects.equals(experienciaVaga, other.experienciaVaga)
					&& Objects.equals(localizacaoVaga, other.localizacaoVaga)
					&& Objects.equals(tituloVaga, other.tituloVaga) && Objects.equals(vagaKey, other.vagaKey);
		}
		
		
		
		
		

}
