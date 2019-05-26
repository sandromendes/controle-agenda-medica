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
@Table(name="SE_TAB_MEDICO")
public class MedicoDB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String ID_OBJETO = "medicoDB";
	
	public static final String MED_ID = "MED_ID";
	public static final String MED_NM_NOME = "MED_NM_NOME";
	public static final String MED_NM_SOBRENOME = "MED_NM_SOBRENOME";
	public static final String MED_DT_REGISTRO = "MED_DT_REGISTRO";
	public static final String MED_DT_NASCIMENTO = "MED_DT_NASCIMENTO";
	public static final String MED_NU_CRM = "MED_NU_CRM";
	public static final String MED_NU_RG = "MED_NU_RG";
	public static final String MED_NU_CPF = "MED_NU_CPF";
	public static final String MED_NU_TELEFONE = "MED_NU_TELEFONE";
	public static final String MED_NU_CELULAR = "MED_NU_CELULAR";
	public static final String MED_TX_EMAIL = "MED_TX_EMAIL";
	public static final String MED_UUID = "MED_UUID";
	public static final String AUD_DH_INCLUSAO = "AUD_DH_INCLUSAO";
	public static final String AUD_DH_ALTERACAO = "AUD_DH_ALTERACAO";
	public static final String AUD_UUID_USUARIO_INCLUSAO = "AUD_UUID_USUARIO_INCLUSAO";
	public static final String AUD_UUID_USUARIO_ALTERACAO = "AUD_UUID_USUARIO_ALTERACAO";
	
	@Id
	@Column(name=MedicoDB.MED_ID)
	@SequenceGenerator(name="MED_SEQ", sequenceName="MED_SEQ", allocationSize=1)
	@GeneratedValue(generator="MED_SEQ")
	private Integer aMedicoId;
	
	@Column(name=MedicoDB.MED_NM_NOME)
	private String aMedicoNome;
	
	@Column(name=MedicoDB.MED_NM_SOBRENOME)
	private String aMedicoSobrenome;
	
	@Column(name=MedicoDB.MED_DT_REGISTRO)
	@JsonSerialize(using = main.java.br.com.eutimia.util.JSONSerializer.class)
	@JsonDeserialize(using = main.java.br.com.eutimia.util.JSONDeserialize.class)
	private Date aMedicoDtRegistro;
	
	@Column(name=MedicoDB.MED_DT_NASCIMENTO)
	@JsonSerialize(using = main.java.br.com.eutimia.util.JSONSerializer.class)
	@JsonDeserialize(using = main.java.br.com.eutimia.util.JSONDeserialize.class)
	private Date aMedicoDtNascimento;
	
	@Column(name=MedicoDB.MED_NU_CRM)
	private String aMedicoNuCRM;
	
	@Column(name=MedicoDB.MED_NU_RG)
	private String aMedicoNuRG;
	
	@Column(name=MedicoDB.MED_NU_CPF)
	private String aMedicoNuCPF;
	
	@Column(name=MedicoDB.MED_NU_TELEFONE)
	private String aMedicoNuTelefone;
	
	@Column(name=MedicoDB.MED_NU_CELULAR)
	private String aMedicoNuCelular;
	
	@Column(name=MedicoDB.MED_TX_EMAIL)
	private String aMedicoTxEmail;
	
	@Column(name=MedicoDB.MED_UUID)
	private UUID aMedicoUUID;
	
	@Column(name=MedicoDB.AUD_DH_INCLUSAO)
	private Timestamp aAudDhInclusao;
	
	@Column(name=MedicoDB.AUD_DH_ALTERACAO)
	private Timestamp aAudDhAlteraco;
	
	@Column(name=MedicoDB.AUD_UUID_USUARIO_INCLUSAO)
	private UUID aAudUsuarioInclusao;
	
	@Column(name=MedicoDB.AUD_UUID_USUARIO_ALTERACAO)
	private UUID aAudUsuarioAlteracao;
	
	@OneToMany(mappedBy = "medico", fetch = FetchType.LAZY)
	@Cascade(CascadeType.ALL)
	private Collection<ConsultaDB> aColecaoConsulta;
	
	public MedicoDB(String aMedicoNome, String aMedicoSobrenome,
			Date aMedicoDtNascimento, String aMedicoNuCRM, String aMedicoNuRG,
			String aMedicoNuCPF) {
		super();
		this.aMedicoNome = aMedicoNome;
		this.aMedicoSobrenome = aMedicoSobrenome;
		this.aMedicoDtNascimento = aMedicoDtNascimento;
		this.aMedicoNuCRM = aMedicoNuCRM;
		this.aMedicoNuRG = aMedicoNuRG;
		this.aMedicoNuCPF = aMedicoNuCPF;
	}
	
	public MedicoDB(Integer aMedicoId, String aMedicoNome,
			String aMedicoSobrenome, Date aMedicoDtRegistro,
			Date aMedicoDtNascimento, String aMedicoNuCRM, String aMedicoNuRG,
			String aMedicoNuCPF, String aMedicoNuTelefone,
			String aMedicoNuCelular, String aMedicoTxEmail, UUID aMedicoUUID,
			Timestamp aAudDhInclusao, Timestamp aAudDhAlteraco,
			UUID aAudUsuarioInclusao, UUID aAudUsuarioAlteracao) {
		super();
		this.aMedicoId = aMedicoId;
		this.aMedicoNome = aMedicoNome;
		this.aMedicoSobrenome = aMedicoSobrenome;
		this.aMedicoDtRegistro = aMedicoDtRegistro;
		this.aMedicoDtNascimento = aMedicoDtNascimento;
		this.aMedicoNuCRM = aMedicoNuCRM;
		this.aMedicoNuRG = aMedicoNuRG;
		this.aMedicoNuCPF = aMedicoNuCPF;
		this.aMedicoNuTelefone = aMedicoNuTelefone;
		this.aMedicoNuCelular = aMedicoNuCelular;
		this.aMedicoTxEmail = aMedicoTxEmail;
		this.aMedicoUUID = aMedicoUUID;
		this.aAudDhInclusao = aAudDhInclusao;
		this.aAudDhAlteraco = aAudDhAlteraco;
		this.aAudUsuarioInclusao = aAudUsuarioInclusao;
		this.aAudUsuarioAlteracao = aAudUsuarioAlteracao;
	}

	public MedicoDB() {
		super();
	}

	public Integer getaMedicoId() {
		return aMedicoId;
	}

	public void setaMedicoId(Integer aMedicoId) {
		this.aMedicoId = aMedicoId;
	}

	public String getaMedicoNome() {
		return aMedicoNome;
	}

	public void setaMedicoNome(String aMedicoNome) {
		this.aMedicoNome = aMedicoNome;
	}

	public String getaMedicoSobrenome() {
		return aMedicoSobrenome;
	}

	public void setaMedicoSobrenome(String aMedicoSobrenome) {
		this.aMedicoSobrenome = aMedicoSobrenome;
	}

	public Date getaMedicoDtRegistro() {
		return aMedicoDtRegistro;
	}

	public void setaMedicoDtRegistro(Date aMedicoDtRegistro) {
		this.aMedicoDtRegistro = aMedicoDtRegistro;
	}

	public Date getaMedicoDtNascimento() {
		return aMedicoDtNascimento;
	}

	public void setaMedicoDtNascimento(Date aMedicoDtNascimento) {
		this.aMedicoDtNascimento = aMedicoDtNascimento;
	}

	public String getaMedicoNuCRM() {
		return aMedicoNuCRM;
	}

	public void setaMedicoNuCRM(String aMedicoNuCRM) {
		this.aMedicoNuCRM = aMedicoNuCRM;
	}

	public String getaMedicoNuRG() {
		return aMedicoNuRG;
	}

	public void setaMedicoNuRG(String aMedicoNuRG) {
		this.aMedicoNuRG = aMedicoNuRG;
	}

	public String getaMedicoNuCPF() {
		return aMedicoNuCPF;
	}

	public void setaMedicoNuCPF(String aMedicoNuCPF) {
		this.aMedicoNuCPF = aMedicoNuCPF;
	}

	public String getaMedicoNuTelefone() {
		return aMedicoNuTelefone;
	}

	public void setaMedicoNuTelefone(String aMedicoNuTelefone) {
		this.aMedicoNuTelefone = aMedicoNuTelefone;
	}

	public String getaMedicoNuCelular() {
		return aMedicoNuCelular;
	}

	public void setaMedicoNuCelular(String aMedicoNuCelular) {
		this.aMedicoNuCelular = aMedicoNuCelular;
	}

	public String getaMedicoTxEmail() {
		return aMedicoTxEmail;
	}

	public void setaMedicoTxEmail(String aMedicoTxEmail) {
		this.aMedicoTxEmail = aMedicoTxEmail;
	}

	public UUID getaMedicoUUID() {
		return aMedicoUUID;
	}

	public void setaMedicoUUID(UUID aMedicoUUID) {
		this.aMedicoUUID = aMedicoUUID;
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
		return "MedicoDB [aMedicoId=" + aMedicoId + ", aMedicoNome="
				+ aMedicoNome + ", aMedicoSobrenome=" + aMedicoSobrenome
				+ ", aMedicoDtRegistro=" + aMedicoDtRegistro
				+ ", aMedicoDtNascimento=" + aMedicoDtNascimento
				+ ", aMedicoNuCRM=" + aMedicoNuCRM + ", aMedicoNuRG="
				+ aMedicoNuRG + ", aMedicoNuCPF=" + aMedicoNuCPF
				+ ", aMedicoNuTelefone=" + aMedicoNuTelefone
				+ ", aMedicoNuCelular=" + aMedicoNuCelular
				+ ", aMedicoTxEmail=" + aMedicoTxEmail + ", aMedicoUUID="
				+ aMedicoUUID + ", aAudDhInclusao=" + aAudDhInclusao
				+ ", aAudDhAlteraco=" + aAudDhAlteraco
				+ ", aAudUsuarioInclusao=" + aAudUsuarioInclusao
				+ ", aAudUsuarioAlteracao=" + aAudUsuarioAlteracao + "]";
	}

}
