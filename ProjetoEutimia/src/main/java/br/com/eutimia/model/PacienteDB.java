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
@Table(name="SE_TAB_PACIENTE")
public class PacienteDB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String ID_OBJETO = "pacienteDB";
	
	public static final String PAC_ID = "PAC_ID";
	public static final String PAC_ID_RESPONSAVEL = "PAC_ID_RESPONSAVEL";
	public static final String PAC_NM_NOME = "PAC_NM_NOME";
	public static final String PAC_NM_SOBRENOME = "PAC_NM_SOBRENOME";
	public static final String PAC_DT_REGISTRO = "PAC_DT_REGISTRO";
	public static final String PAC_DT_NASCIMENTO = "PAC_DT_NASCIMENTO";
	public static final String PAC_NU_RG = "PAC_NU_RG";
	public static final String PAC_NU_CPF = "PAC_NU_CPF";
	public static final String PAC_NU_TELEFONE = "PAC_NU_TELEFONE";
	public static final String PAC_NU_CELULAR = "PAC_NU_CELULAR";
	public static final String PAC_TX_EMAIL = "PAC_TX_EMAIL";
	public static final String PAC_UUID = "PAC_UUID";
	public static final String AUD_DH_INCLUSAO = "AUD_DH_INCLUSAO";
	public static final String AUD_DH_ALTERACAO = "AUD_DH_ALTERACAO";
	public static final String AUD_UUID_USUARIO_INCLUSAO = "AUD_UUID_USUARIO_INCLUSAO";
	public static final String AUD_UUID_USUARIO_ALTERACAO = "AUD_UUID_USUARIO_ALTERACAO";
	
	@Id
	@Column(name=PacienteDB.PAC_ID)
	@SequenceGenerator(name="PAC_SEQ", sequenceName="PAC_SEQ", allocationSize=1)
	@GeneratedValue(generator="PAC_SEQ")
	private Integer aPacienteId;
	
	@Column(name=PacienteDB.PAC_ID_RESPONSAVEL)
	private Integer aPacienteResponsavelId;
	
	@Column(name=PacienteDB.PAC_NM_NOME)
	private String aPacienteNome;
	
	@Column(name=PacienteDB.PAC_NM_SOBRENOME)
	private String aPacienteSobrenome;
	
	@Column(name=PacienteDB.PAC_DT_REGISTRO)
	@JsonSerialize(using = main.java.br.com.eutimia.util.JSONSerializer.class)
	@JsonDeserialize(using = main.java.br.com.eutimia.util.JSONDeserialize.class)
	private Date aPacienteDtRegistro;
	
	@Column(name=PacienteDB.PAC_DT_NASCIMENTO)
	@JsonSerialize(using = main.java.br.com.eutimia.util.JSONSerializer.class)
	@JsonDeserialize(using = main.java.br.com.eutimia.util.JSONDeserialize.class)
	private Date aPacienteDtNascimento;
	
	@Column(name=PacienteDB.PAC_NU_RG)
	private String aPacienteNuRG;
	
	@Column(name=PacienteDB.PAC_NU_CPF)
	private String aPacienteNuCPF;
	
	@Column(name=PacienteDB.PAC_NU_TELEFONE)
	private String aPacienteNuTelefone;
	
	@Column(name=PacienteDB.PAC_NU_CELULAR)
	private String aPacienteNuCelular;
	
	@Column(name=PacienteDB.PAC_TX_EMAIL)
	private String aPacienteTxEmail;
	
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
	
	@OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)
	@Cascade(CascadeType.ALL)
	private Collection<PacientePlanoDB> aColecaoPacientePlano;

	public PacienteDB(String aPacienteNome, String aPacienteSobrenome,
			Date aPacienteDtRegistro) {
		super();
		this.aPacienteNome = aPacienteNome;
		this.aPacienteSobrenome = aPacienteSobrenome;
		this.aPacienteDtRegistro = aPacienteDtRegistro;
	}
	
	public PacienteDB(Integer aPacienteId, Integer aPacienteResponsavelId,
			String aPacienteNome, String aPacienteSobrenome,
			Date aPacienteDtRegistro, Date aPacienteDtNascimento,
			String aPacienteNuRG, String aPacienteNuCPF,
			String aPacienteNuTelefone, String aPacienteNuCelular,
			String aPacienteTxEmail, UUID aPacienteUUID,
			Timestamp aAudDhInclusao, Timestamp aAudDhAlteraco,
			UUID aAudUsuarioInclusao, UUID aAudUsuarioAlteracao,
			Collection<PacientePlanoDB> aColecaoPacientePlano) {
		super();
		this.aPacienteId = aPacienteId;
		this.aPacienteResponsavelId = aPacienteResponsavelId;
		this.aPacienteNome = aPacienteNome;
		this.aPacienteSobrenome = aPacienteSobrenome;
		this.aPacienteDtRegistro = aPacienteDtRegistro;
		this.aPacienteDtNascimento = aPacienteDtNascimento;
		this.aPacienteNuRG = aPacienteNuRG;
		this.aPacienteNuCPF = aPacienteNuCPF;
		this.aPacienteNuTelefone = aPacienteNuTelefone;
		this.aPacienteNuCelular = aPacienteNuCelular;
		this.aPacienteTxEmail = aPacienteTxEmail;
		this.aPacienteUUID = aPacienteUUID;
		this.aAudDhInclusao = aAudDhInclusao;
		this.aAudDhAlteraco = aAudDhAlteraco;
		this.aAudUsuarioInclusao = aAudUsuarioInclusao;
		this.aAudUsuarioAlteracao = aAudUsuarioAlteracao;
		this.aColecaoPacientePlano = aColecaoPacientePlano;
	}



	public PacienteDB(){
		
	}

	public Integer getaPacienteId() {
		return aPacienteId;
	}

	public void setaPacienteId(Integer aPacienteId) {
		this.aPacienteId = aPacienteId;
	}

	public Integer getaPacienteResponsavelId() {
		return aPacienteResponsavelId;
	}

	public void setaPacienteResponsavelId(Integer aPacienteResponsavelId) {
		this.aPacienteResponsavelId = aPacienteResponsavelId;
	}

	public String getaPacienteNome() {
		return aPacienteNome;
	}

	public void setaPacienteNome(String aPacienteNome) {
		this.aPacienteNome = aPacienteNome;
	}

	public String getaPacienteSobrenome() {
		return aPacienteSobrenome;
	}

	public void setaPacienteSobrenome(String aPacienteSobrenome) {
		this.aPacienteSobrenome = aPacienteSobrenome;
	}

	public Date getaPacienteDtRegistro() {
		return aPacienteDtRegistro;
	}

	public void setaPacienteDtRegistro(Date aPacienteDtRegistro) {
		this.aPacienteDtRegistro = aPacienteDtRegistro;
	}

	public Date getaPacienteDtNascimento() {
		return aPacienteDtNascimento;
	}

	public void setaPacienteDtNascimento(Date aPacienteDtNascimento) {
		this.aPacienteDtNascimento = aPacienteDtNascimento;
	}

	public String getaPacienteNuRG() {
		return aPacienteNuRG;
	}

	public void setaPacienteNuRG(String aPacienteNuRG) {
		this.aPacienteNuRG = aPacienteNuRG;
	}

	public String getaPacienteNuCPF() {
		return aPacienteNuCPF;
	}

	public void setaPacienteNuCPF(String aPacienteNuCPF) {
		this.aPacienteNuCPF = aPacienteNuCPF;
	}

	public String getaPacienteNuTelefone() {
		return aPacienteNuTelefone;
	}

	public void setaPacienteNuTelefone(String aPacienteNuTelefone) {
		this.aPacienteNuTelefone = aPacienteNuTelefone;
	}

	public String getaPacienteNuCelular() {
		return aPacienteNuCelular;
	}

	public void setaPacienteNuCelular(String aPacienteNuCelular) {
		this.aPacienteNuCelular = aPacienteNuCelular;
	}

	public String getaPacienteTxEmail() {
		return aPacienteTxEmail;
	}

	public void setaPacienteTxEmail(String aPacienteTxEmail) {
		this.aPacienteTxEmail = aPacienteTxEmail;
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

	public Collection<PacientePlanoDB> getaColecaoPacientePlano() {
		return aColecaoPacientePlano;
	}

	public void setaColecaoPacientePlano(
			Collection<PacientePlanoDB> aColecaoPacientePlano) {
		this.aColecaoPacientePlano = aColecaoPacientePlano;
	}

	@Override
	public String toString() {
		return "PacienteDB [aPacienteId=" + aPacienteId
				+ ", aPacienteResponsavelId=" + aPacienteResponsavelId
				+ ", aPacienteNome=" + aPacienteNome + ", aPacienteSobrenome="
				+ aPacienteSobrenome + ", aPacienteDtRegistro="
				+ aPacienteDtRegistro + ", aPacienteDtNascimento="
				+ aPacienteDtNascimento + ", aPacienteNuRG=" + aPacienteNuRG
				+ ", aPacienteNuCPF=" + aPacienteNuCPF
				+ ", aPacienteNuTelefone=" + aPacienteNuTelefone
				+ ", aPacienteNuCelular=" + aPacienteNuCelular
				+ ", aPacienteTxEmail=" + aPacienteTxEmail + ", aPacienteUUID="
				+ aPacienteUUID + ", aAudDhInclusao=" + aAudDhInclusao
				+ ", aAudDhAlteraco=" + aAudDhAlteraco
				+ ", aAudUsuarioInclusao=" + aAudUsuarioInclusao
				+ ", aAudUsuarioAlteracao=" + aAudUsuarioAlteracao + "]";
	}
}
