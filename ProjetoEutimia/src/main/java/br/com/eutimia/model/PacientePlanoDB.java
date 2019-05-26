package main.java.br.com.eutimia.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="SE_TAB_PACIENTE_PLANO")
public class PacientePlanoDB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String ID_OBJETO = "pacientePlanoDB";
	
	public static final String PACPLS_ID = "PACPLS_ID";
	public static final String PAC_ID = "PAC_ID";
	public static final String PLS_ID = "PLS_ID";
	public static final String AUD_DH_INCLUSAO = "AUD_DH_INCLUSAO";
	public static final String AUD_DH_ALTERACAO = "AUD_DH_ALTERACAO";
	public static final String AUD_UUID_USUARIO_INCLUSAO = "AUD_UUID_USUARIO_INCLUSAO";
	public static final String AUD_UUID_USUARIO_ALTERACAO = "AUD_UUID_USUARIO_ALTERACAO";
	
	@EmbeddedId
	private PacientePlanoPK aPacientePlanoPK;
	
	@Column(name=PacienteDB.PAC_UUID)
	private UUID aPacienteUUID;
	
	@Column(name=PacienteDB.AUD_DH_INCLUSAO)
	private Timestamp aAudDhInclusao;
	
	@Column(name=PacienteDB.AUD_DH_ALTERACAO)
	private Timestamp aAudDhAlteraco;
	
	@Column(name=PacienteDB.AUD_UUID_USUARIO_INCLUSAO)
	private UUID aAudUsuarioInclusao;
	
	@Column(name=PacienteDB.AUD_UUID_USUARIO_ALTERACAO)
	private UUID aAudUsuarioAlteracao;
	
	@OneToMany(mappedBy = "pacientePlano", fetch = FetchType.LAZY)
	@Cascade(CascadeType.ALL)
	private Collection<ConsultaDB> aColecaoConsulta;
	
	@MapsId("aPacienteId")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({
		@JoinColumn(name = PacienteDB.PAC_ID, referencedColumnName = PacienteDB.PAC_ID,
				insertable = true, updatable = true)
	})
	@Cascade(CascadeType.SAVE_UPDATE)
	private PacienteDB paciente;

	@MapsId("aPlanoSaudeId")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({
		@JoinColumn(name = PlanoSaudeDB.PLS_ID, referencedColumnName = PlanoSaudeDB.PLS_ID,
				insertable = true, updatable = true)
	})
	@Cascade(CascadeType.SAVE_UPDATE)
	private PlanoSaudeDB planoSaude;
	
	public PacientePlanoDB(PacientePlanoPK aPacientePlanoPK,
			UUID aPacienteUUID, Timestamp aAudDhInclusao,
			Timestamp aAudDhAlteraco, UUID aAudUsuarioInclusao,
			UUID aAudUsuarioAlteracao, Collection<ConsultaDB> aColecaoConsulta,
			PacienteDB paciente) {
		super();
		this.aPacientePlanoPK = aPacientePlanoPK;
		this.aPacienteUUID = aPacienteUUID;
		this.aAudDhInclusao = aAudDhInclusao;
		this.aAudDhAlteraco = aAudDhAlteraco;
		this.aAudUsuarioInclusao = aAudUsuarioInclusao;
		this.aAudUsuarioAlteracao = aAudUsuarioAlteracao;
		this.aColecaoConsulta = aColecaoConsulta;
		this.paciente = paciente;
	}

	public PacientePlanoDB() {
		super();
	}

	public PacientePlanoPK getaPacientePlanoPK() {
		return aPacientePlanoPK;
	}

	public void setaPacientePlanoPK(PacientePlanoPK aPacientePlanoPK) {
		this.aPacientePlanoPK = aPacientePlanoPK;
	}

	public Collection<ConsultaDB> getaColecaoConsulta() {
		return aColecaoConsulta;
	}

	public void setaColecaoConsulta(Collection<ConsultaDB> aColecaoConsulta) {
		this.aColecaoConsulta = aColecaoConsulta;
	}

	public PacienteDB getPaciente() {
		return paciente;
	}

	public void setPaciente(PacienteDB paciente) {
		this.paciente = paciente;
	}

	public UUID getaPacienteUUID() {
		return aPacienteUUID;
	}

	public void setaPacienteUUID(UUID aPacienteUUID) {
		this.aPacienteUUID = aPacienteUUID;
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

	@Override
	public String toString() {
		return "PacientePlanoDB [aPacientePlanoPK=" + aPacientePlanoPK
				+ ", aPacienteUUID=" + aPacienteUUID + ", aAudDhInclusao="
				+ aAudDhInclusao + ", aAudDhAlteraco=" + aAudDhAlteraco
				+ ", aAudUsuarioInclusao=" + aAudUsuarioInclusao
				+ ", aAudUsuarioAlteracao=" + aAudUsuarioAlteracao
				+ ", aColecaoConsulta=" + aColecaoConsulta + ", paciente="
				+ paciente + "]";
	}

}
