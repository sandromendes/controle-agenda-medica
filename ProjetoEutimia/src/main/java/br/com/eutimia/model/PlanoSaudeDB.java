package main.java.br.com.eutimia.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name="SE_TAB_PLANOSAUDE")
public class PlanoSaudeDB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String ID_OBJETO = "planoSaudeDB";
	
	public static final String PLS_ID = "PLS_ID";
	public static final String PLS_NM_NOME = "PLS_NM_NOME";
	public static final String PLS_DT_INICIO_VIGENCIA = "PLS_DT_INICIO_VIGENCIA";
	public static final String PLS_DT_FIM_VIGENCIA = "PLS_DT_FIM_VIGENCIA";
	public static final String PLS_UUID = "PLS_UUID";
	public static final String AUD_DH_INCLUSAO = "AUD_DH_INCLUSAO";
	public static final String AUD_DH_ALTERACAO = "AUD_DH_ALTERACAO";
	public static final String AUD_UUID_USUARIO_INCLUSAO = "AUD_UUID_USUARIO_INCLUSAO";
	public static final String AUD_UUID_USUARIO_ALTERACAO = "AUD_UUID_USUARIO_ALTERACAO";
	
	@Id
	@Column(name=PlanoSaudeDB.PLS_ID)
	@SequenceGenerator(name="PLS_SEQ", sequenceName="PLS_SEQ", allocationSize=1)
	@GeneratedValue(generator="PLS_SEQ")
	private Integer aPlanoSaudeId;
	
	@Column(name=PlanoSaudeDB.PLS_NM_NOME)
	private String aPlanoSaudeNome;
	
	@Column(name=PlanoSaudeDB.PLS_DT_INICIO_VIGENCIA)
	@JsonSerialize(using = main.java.br.com.eutimia.util.JSONSerializer.class)
	@JsonDeserialize(using = main.java.br.com.eutimia.util.JSONDeserialize.class)
	private Date aPlanoSaudeDtInicioVigencia;

	@Column(name=PlanoSaudeDB.PLS_DT_FIM_VIGENCIA)
	@JsonSerialize(using = main.java.br.com.eutimia.util.JSONSerializer.class)
	@JsonDeserialize(using = main.java.br.com.eutimia.util.JSONDeserialize.class)
	private Date aPlanoSaudeDtFimVigencia;
	
	@Column(name=PlanoSaudeDB.PLS_UUID)
	private UUID aPlanoSaudeUUID;

	@Column(name=PacienteDB.AUD_DH_INCLUSAO)
	private Timestamp aAudDhInclusao;
	
	@Column(name=PacienteDB.AUD_DH_ALTERACAO)
	private Timestamp aAudDhAlteraco;
	
	@Column(name=PacienteDB.AUD_UUID_USUARIO_INCLUSAO)
	private UUID aAudUsuarioInclusao;
	
	@Column(name=PacienteDB.AUD_UUID_USUARIO_ALTERACAO)
	private UUID aAudUsuarioAlteracao; 

	@OneToMany(mappedBy = "planoSaude", fetch = FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	private Collection<PacientePlanoDB> aColecaoPacientePlano;
	
	public PlanoSaudeDB(Integer aPlanoSaudeId, String aPlanoSaudeNome,
			Date aPlanoSaudeDtInicioVigencia, Date aPlanoSaudeDtFimVigencia,
			UUID aPlanoSaudeUUID, Timestamp aAudDhInclusao,
			Timestamp aAudDhAlteraco, UUID aAudUsuarioInclusao,
			UUID aAudUsuarioAlteracao,
			Collection<PacientePlanoDB> aColecaoPacientePlano) {
		super();
		this.aPlanoSaudeId = aPlanoSaudeId;
		this.aPlanoSaudeNome = aPlanoSaudeNome;
		this.aPlanoSaudeDtInicioVigencia = aPlanoSaudeDtInicioVigencia;
		this.aPlanoSaudeDtFimVigencia = aPlanoSaudeDtFimVigencia;
		this.aPlanoSaudeUUID = aPlanoSaudeUUID;
		this.aAudDhInclusao = aAudDhInclusao;
		this.aAudDhAlteraco = aAudDhAlteraco;
		this.aAudUsuarioInclusao = aAudUsuarioInclusao;
		this.aAudUsuarioAlteracao = aAudUsuarioAlteracao;
		this.aColecaoPacientePlano = aColecaoPacientePlano;
	}

	public PlanoSaudeDB(String aPlanoSaudeNome,
			Date aPlanoSaudeDtInicioVigencia, Date aPlanoSaudeDtFimVigencia) {
		super();
		this.aPlanoSaudeNome = aPlanoSaudeNome;
		this.aPlanoSaudeDtInicioVigencia = aPlanoSaudeDtInicioVigencia;
		this.aPlanoSaudeDtFimVigencia = aPlanoSaudeDtFimVigencia;
	}

	public PlanoSaudeDB() {
		super();
	}

	public Integer getaPlanoSaudeId() {
		return aPlanoSaudeId;
	}

	public void setaPlanoSaudeId(Integer aPlanoSaudeId) {
		this.aPlanoSaudeId = aPlanoSaudeId;
	}

	public String getaPlanoSaudeNome() {
		return aPlanoSaudeNome;
	}

	public void setaPlanoSaudeNome(String aPlanoSaudeNome) {
		this.aPlanoSaudeNome = aPlanoSaudeNome;
	}

	public Date getaPlanoSaudeDtInicioVigencia() {
		return aPlanoSaudeDtInicioVigencia;
	}

	public void setaPlanoSaudeDtInicioVigencia(Date aPlanoSaudeDtInicioVigencia) {
		this.aPlanoSaudeDtInicioVigencia = aPlanoSaudeDtInicioVigencia;
	}

	public Date getaPlanoSaudeDtFimVigencia() {
		return aPlanoSaudeDtFimVigencia;
	}

	public void setaPlanoSaudeDtFimVigencia(Date aPlanoSaudeDtFimVigencia) {
		this.aPlanoSaudeDtFimVigencia = aPlanoSaudeDtFimVigencia;
	}

	public UUID getaPlanoSaudeUUID() {
		return aPlanoSaudeUUID;
	}

	public void setaPlanoSaudeUUID(UUID aPlanoSaudeUUID) {
		this.aPlanoSaudeUUID = aPlanoSaudeUUID;
	}

	public Timestamp getaAudDhInclusao() {
		return aAudDhInclusao;
	}

	public void setaAudDhInclusao(Timestamp aAudDhInclusao) {
		this.aAudDhInclusao = aAudDhInclusao;
	}

	public Timestamp getaAudDhAlteraco() {
		return aAudDhAlteraco;
	}

	public void setaAudDhAlteraco(Timestamp aAudDhAlteraco) {
		this.aAudDhAlteraco = aAudDhAlteraco;
	}

	public UUID getaAudUsuarioInclusao() {
		return aAudUsuarioInclusao;
	}

	public void setaAudUsuarioInclusao(UUID aAudUsuarioInclusao) {
		this.aAudUsuarioInclusao = aAudUsuarioInclusao;
	}

	public UUID getaAudUsuarioAlteracao() {
		return aAudUsuarioAlteracao;
	}

	public void setaAudUsuarioAlteracao(UUID aAudUsuarioAlteracao) {
		this.aAudUsuarioAlteracao = aAudUsuarioAlteracao;
	}

	public Collection<PacientePlanoDB> getaColecaoPacientePlano() {
		return aColecaoPacientePlano;
	}

	public void setaColecaoPacientePlano(
			Collection<PacientePlanoDB> aColecaoPacientePlano) {
		this.aColecaoPacientePlano = aColecaoPacientePlano;
	}

	@Override
	public String toString() {
		return "PlanoSaudeDB [aPlanoSaudeId=" + aPlanoSaudeId
				+ ", aPlanoSaudeNome=" + aPlanoSaudeNome
				+ ", aPlanoSaudeDtInicioVigencia="
				+ aPlanoSaudeDtInicioVigencia + ", aPlanoSaudeDtFimVigencia="
				+ aPlanoSaudeDtFimVigencia + ", aPlanoSaudeUUID="
				+ aPlanoSaudeUUID + ", aAudDhInclusao=" + aAudDhInclusao
				+ ", aAudDhAlteraco=" + aAudDhAlteraco
				+ ", aAudUsuarioInclusao=" + aAudUsuarioInclusao
				+ ", aAudUsuarioAlteracao=" + aAudUsuarioAlteracao
				+ ", aColecaoPacientePlano=" + aColecaoPacientePlano + "]";
	}
	
}
