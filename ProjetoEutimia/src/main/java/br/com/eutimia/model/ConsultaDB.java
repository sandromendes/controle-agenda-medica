package main.java.br.com.eutimia.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name="SE_TAB_CONSULTA")
public class ConsultaDB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String ID_OBJETO = "consultaDB";
	
	public static final String CONS_ID = "CONS_ID";
	public static final String MED_ID = "MED_ID";
	public static final String PACPLS_ID = "PACPLS_ID";
	public static final String PAC_ID = "PAC_ID";
	public static final String PLS_ID = "PLS_ID";
	public static final String CONS_DT_REGISTRO = "CONS_DT_REGISTRO";
	public static final String CONS_NU_PROTOCOLO_DIA = "CONS_NU_PROTOCOLO_DIA";
	public static final String PAC_NU_CPF = "PAC_NU_CPF";
	public static final String CONS_DH_AGENDAMENTO = "CONS_DH_AGENDAMENTO";
	public static final String CONS_DH_ATENDIMENTO = "CONS_DH_ATENDIMENTO";
	public static final String CONS_MATRICULA_PLANO = "CONS_MATRICULA_PLANO";
	public static final String CONS_DT_VALIDADE_PLANO = "CONS_DT_VALIDADE_PLANO";
	public static final String CONS_IN_CANCELADA = "CONS_IN_CANCELADA";
	public static final String CONS_VL_PADRAO = "CONS_VL_PADRAO";
	public static final String CONS_VL_DESCONTO = "CONS_VL_DESCONTO";
	public static final String CONS_PC_DESCONTO = "CONS_PC_DESCONTO";
	public static final String CONS_VL_FINAL = "CONS_VL_FINAL";
	public static final String CONS_TX_OBSERVACAO = "CONS_TX_OBSERVACAO";
	public static final String CONS_TX_ANOTACAO_MEDICA = "CONS_TX_ANOTACAO_MEDICA";
	public static final String PAC_UUID = "PAC_UUID";
	public static final String AUD_DH_INCLUSAO = "AUD_DH_INCLUSAO";
	public static final String AUD_DH_ALTERACAO = "AUD_DH_ALTERACAO";
	public static final String AUD_UUID_USUARIO_INCLUSAO = "AUD_UUID_USUARIO_INCLUSAO";
	public static final String AUD_UUID_USUARIO_ALTERACAO = "AUD_UUID_USUARIO_ALTERACAO";
	
	@Id
	@Column(name=ConsultaDB.CONS_ID)
	@SequenceGenerator(name="CONS_SEQ", sequenceName="CONS_SEQ", allocationSize=1)
	@GeneratedValue(generator="CONS_SEQ")
	private Integer aConsultaId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = MedicoDB.MED_ID, insertable = true, updatable = true)
	@Cascade(CascadeType.SAVE_UPDATE)
	private MedicoDB medico;
	
	@MapsId("aPacientePlanoId")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({
		@JoinColumn(name = PacientePlanoDB.PACPLS_ID, referencedColumnName = PacientePlanoDB.PACPLS_ID,
				insertable = true, updatable = true),
		@JoinColumn(name = PacienteDB.PAC_ID, referencedColumnName = PacienteDB.PAC_ID,
				insertable = true, updatable = true),
		@JoinColumn(name = PlanoSaudeDB.PLS_ID, referencedColumnName = PlanoSaudeDB.PLS_ID,
				insertable = true, updatable = true)
	})
	@Cascade(CascadeType.SAVE_UPDATE)
	private PacientePlanoDB pacientePlano;
	
	@Column(name=ConsultaDB.CONS_DT_REGISTRO)
	@JsonSerialize(using = main.java.br.com.eutimia.util.JSONSerializer.class)
	@JsonDeserialize(using = main.java.br.com.eutimia.util.JSONDeserialize.class)
	private Date aConsultaDtRegistro;

	@Column(name=ConsultaDB.CONS_NU_PROTOCOLO_DIA)
	private String aConsultaNuProtocoloDia;
	
	@Column(name=ConsultaDB.CONS_DH_AGENDAMENTO)
	private Date aConsultaDtAgendamento;
	
	@Column(name=ConsultaDB.CONS_DH_ATENDIMENTO)
	private Date aConsultaDtAtendimento;
	
	@Column(name=ConsultaDB.CONS_MATRICULA_PLANO)
	private String aConsultaMatriculaPlano;
	
	@Column(name=ConsultaDB.CONS_DT_VALIDADE_PLANO)
	private Date aConsultaDtValidadePlano;
	
	@Column(name=ConsultaDB.CONS_IN_CANCELADA)
	private boolean aConsultaInCancelada;
	
	@Column(name=ConsultaDB.CONS_VL_PADRAO)
	private BigDecimal aConsultaVlPadrao;
	
	@Column(name=ConsultaDB.CONS_VL_DESCONTO)
	private BigDecimal aConsultaVlDesconto;
	
	@Column(name=ConsultaDB.CONS_PC_DESCONTO)
	private BigDecimal aConsultaPcDesconto;
	
	@Column(name=ConsultaDB.CONS_VL_FINAL)
	private BigDecimal aConsultaVlFinal;
	
	@Column(name=ConsultaDB.CONS_TX_OBSERVACAO)
	private String aConsultaTxObservacao;
	
	@Column(name=ConsultaDB.CONS_TX_ANOTACAO_MEDICA)
	private String aConsultaTxAnotacaoMedica;
	
	@Column(name=ConsultaDB.PAC_UUID)
	private UUID aConsultaUUID;
	
	@Column(name=PacienteDB.AUD_DH_INCLUSAO)
	private Timestamp aAudDhInclusao;
	
	@Column(name=PacienteDB.AUD_DH_ALTERACAO)
	private Timestamp aAudDhAlteraco;
	
	@Column(name=PacienteDB.AUD_UUID_USUARIO_INCLUSAO)
	private UUID aAudUsuarioInclusao;
	
	@Column(name=PacienteDB.AUD_UUID_USUARIO_ALTERACAO)
	private UUID aAudUsuarioAlteracao;
	
	public ConsultaDB() {
		super();
	}

	public ConsultaDB(Integer aConsultaId, MedicoDB medico,
			PacientePlanoDB pacientePlano, Date aConsultaDtRegistro,
			String aConsultaNuProtocoloDia, Date aConsultaDtAgendamento,
			Date aConsultaDtAtendimento, String aConsultaMatriculaPlano,
			Date aConsultaDtValidadePlano, boolean aConsultaInCancelada,
			BigDecimal aConsultaVlPadrao, BigDecimal aConsultaVlDesconto,
			BigDecimal aConsultaPcDesconto, BigDecimal aConsultaVlFinal,
			String aConsultaTxObservacao, String aConsultaTxAnotacaoMedica,
			UUID aConsultaUUID, Timestamp aAudDhInclusao,
			Timestamp aAudDhAlteraco, UUID aAudUsuarioInclusao,
			UUID aAudUsuarioAlteracao) {
		super();
		this.aConsultaId = aConsultaId;
		this.medico = medico;
		this.pacientePlano = pacientePlano;
		this.aConsultaDtRegistro = aConsultaDtRegistro;
		this.aConsultaNuProtocoloDia = aConsultaNuProtocoloDia;
		this.aConsultaDtAgendamento = aConsultaDtAgendamento;
		this.aConsultaDtAtendimento = aConsultaDtAtendimento;
		this.aConsultaMatriculaPlano = aConsultaMatriculaPlano;
		this.aConsultaDtValidadePlano = aConsultaDtValidadePlano;
		this.aConsultaInCancelada = aConsultaInCancelada;
		this.aConsultaVlPadrao = aConsultaVlPadrao;
		this.aConsultaVlDesconto = aConsultaVlDesconto;
		this.aConsultaPcDesconto = aConsultaPcDesconto;
		this.aConsultaVlFinal = aConsultaVlFinal;
		this.aConsultaTxObservacao = aConsultaTxObservacao;
		this.aConsultaTxAnotacaoMedica = aConsultaTxAnotacaoMedica;
		this.aConsultaUUID = aConsultaUUID;
		this.aAudDhInclusao = aAudDhInclusao;
		this.aAudDhAlteraco = aAudDhAlteraco;
		this.aAudUsuarioInclusao = aAudUsuarioInclusao;
		this.aAudUsuarioAlteracao = aAudUsuarioAlteracao;
	}

	public Integer getaConsultaId() {
		return aConsultaId;
	}

	public void setaConsultaId(Integer aConsultaId) {
		this.aConsultaId = aConsultaId;
	}

	public MedicoDB getMedico() {
		return medico;
	}

	public void setMedico(MedicoDB medico) {
		this.medico = medico;
	}

	public PacientePlanoDB getPacientePlano() {
		return pacientePlano;
	}

	public void setPacientePlano(PacientePlanoDB pacientePlano) {
		this.pacientePlano = pacientePlano;
	}

	public Date getaConsultaDtRegistro() {
		return aConsultaDtRegistro;
	}

	public void setaConsultaDtRegistro(Date aConsultaDtRegistro) {
		this.aConsultaDtRegistro = aConsultaDtRegistro;
	}

	public String getaConsultaNuProtocoloDia() {
		return aConsultaNuProtocoloDia;
	}

	public void setaConsultaNuProtocoloDia(String aConsultaNuProtocoloDia) {
		this.aConsultaNuProtocoloDia = aConsultaNuProtocoloDia;
	}

	public Date getaConsultaDtAgendamento() {
		return aConsultaDtAgendamento;
	}

	public void setaConsultaDtAgendamento(Date aConsultaDtAgendamento) {
		this.aConsultaDtAgendamento = aConsultaDtAgendamento;
	}

	public Date getaConsultaDtAtendimento() {
		return aConsultaDtAtendimento;
	}

	public void setaConsultaDtAtendimento(Date aConsultaDtAtendimento) {
		this.aConsultaDtAtendimento = aConsultaDtAtendimento;
	}

	public String getaConsultaMatriculaPlano() {
		return aConsultaMatriculaPlano;
	}

	public void setaConsultaMatriculaPlano(String aConsultaMatriculaPlano) {
		this.aConsultaMatriculaPlano = aConsultaMatriculaPlano;
	}

	public Date getaConsultaDtValidadePlano() {
		return aConsultaDtValidadePlano;
	}

	public void setaConsultaDtValidadePlano(Date aConsultaDtValidadePlano) {
		this.aConsultaDtValidadePlano = aConsultaDtValidadePlano;
	}

	public boolean isaConsultaInCancelada() {
		return aConsultaInCancelada;
	}

	public void setaConsultaInCancelada(boolean aConsultaInCancelada) {
		this.aConsultaInCancelada = aConsultaInCancelada;
	}

	public BigDecimal getaConsultaVlPadrao() {
		return aConsultaVlPadrao;
	}

	public void setaConsultaVlPadrao(BigDecimal aConsultaVlPadrao) {
		this.aConsultaVlPadrao = aConsultaVlPadrao;
	}

	public BigDecimal getaConsultaVlDesconto() {
		return aConsultaVlDesconto;
	}

	public void setaConsultaVlDesconto(BigDecimal aConsultaVlDesconto) {
		this.aConsultaVlDesconto = aConsultaVlDesconto;
	}

	public BigDecimal getaConsultaPcDesconto() {
		return aConsultaPcDesconto;
	}

	public void setaConsultaPcDesconto(BigDecimal aConsultaPcDesconto) {
		this.aConsultaPcDesconto = aConsultaPcDesconto;
	}

	public BigDecimal getaConsultaVlFinal() {
		return aConsultaVlFinal;
	}

	public void setaConsultaVlFinal(BigDecimal aConsultaVlFinal) {
		this.aConsultaVlFinal = aConsultaVlFinal;
	}

	public String getaConsultaTxObservacao() {
		return aConsultaTxObservacao;
	}

	public void setaConsultaTxObservacao(String aConsultaTxObservacao) {
		this.aConsultaTxObservacao = aConsultaTxObservacao;
	}

	public String getaConsultaTxAnotacaoMedica() {
		return aConsultaTxAnotacaoMedica;
	}

	public void setaConsultaTxAnotacaoMedica(String aConsultaTxAnotacaoMedica) {
		this.aConsultaTxAnotacaoMedica = aConsultaTxAnotacaoMedica;
	}

	public UUID getaConsultaUUID() {
		return aConsultaUUID;
	}

	public void setaConsultaUUID(UUID aConsultaUUID) {
		this.aConsultaUUID = aConsultaUUID;
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
		return "ConsultaDB [aConsultaId=" + aConsultaId + ", medico=" + medico
				+ ", pacientePlano=" + pacientePlano + ", aConsultaDtRegistro="
				+ aConsultaDtRegistro + ", aConsultaNuProtocoloDia="
				+ aConsultaNuProtocoloDia + ", aConsultaDtAgendamento="
				+ aConsultaDtAgendamento + ", aConsultaDtAtendimento="
				+ aConsultaDtAtendimento + ", aConsultaMatriculaPlano="
				+ aConsultaMatriculaPlano + ", aConsultaDtValidadePlano="
				+ aConsultaDtValidadePlano + ", aConsultaInCancelada="
				+ aConsultaInCancelada + ", aConsultaVlPadrao="
				+ aConsultaVlPadrao + ", aConsultaVlDesconto="
				+ aConsultaVlDesconto + ", aConsultaPcDesconto="
				+ aConsultaPcDesconto + ", aConsultaVlFinal="
				+ aConsultaVlFinal + ", aConsultaTxObservacao="
				+ aConsultaTxObservacao + ", aConsultaTxAnotacaoMedica="
				+ aConsultaTxAnotacaoMedica + ", aConsultaUUID="
				+ aConsultaUUID + ", aAudDhInclusao=" + aAudDhInclusao
				+ ", aAudDhAlteraco=" + aAudDhAlteraco
				+ ", aAudUsuarioInclusao=" + aAudUsuarioInclusao
				+ ", aAudUsuarioAlteracao=" + aAudUsuarioAlteracao + "]";
	}

 }
