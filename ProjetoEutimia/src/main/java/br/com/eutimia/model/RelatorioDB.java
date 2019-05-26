package main.java.br.com.eutimia.model;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name="SE_TAB_RELATORIO")
public class RelatorioDB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String ID_OBJETO = "relatorioDB";
	
	public static final String REL_ID = "REL_ID";
	public static final String TPREL_ID = "TPREL_ID";
	public static final String REL_PROTOCOLO = "REL_PROTOCOLO";
	public static final String REL_DT_GERACAO = "REL_DT_GERACAO";
	public static final String REL_IN_REGERADO = "REL_IN_REGERADO";
	public static final String REL_ARQUIVO = "REL_ARQUIVO";
	public static final String REL_UUID = "REL_UUID";
	public static final String AUD_DH_INCLUSAO = "AUD_DH_INCLUSAO";
	public static final String AUD_DH_ALTERACAO = "AUD_DH_ALTERACAO";
	public static final String AUD_UUID_USUARIO_INCLUSAO = "AUD_UUID_USUARIO_INCLUSAO";
	public static final String AUD_UUID_USUARIO_ALTERACAO = "AUD_UUID_USUARIO_ALTERACAO";
	
	@Id
	@Column(name=RelatorioDB.REL_ID)
	@SequenceGenerator(name="REL_SEQ", sequenceName="REL_SEQ", allocationSize=1)
	@GeneratedValue(generator="REL_SEQ")
	private Integer aRelatorioId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = TipoRelatorioDB.TPREL_ID, insertable = true, updatable = true)
	@Cascade(CascadeType.SAVE_UPDATE)
	private TipoRelatorioDB tipoRelatorio;
	
	@Column(name=RelatorioDB.REL_PROTOCOLO)
	private String aRelatorioProtocolo;
	
	@Column(name=RelatorioDB.REL_DT_GERACAO)
	@JsonSerialize(using = main.java.br.com.eutimia.util.JSONSerializer.class)
	@JsonDeserialize(using = main.java.br.com.eutimia.util.JSONDeserialize.class)
	private Date aRelatorioDtGeracao;
	
	@Column(name=RelatorioDB.REL_IN_REGERADO)
	private boolean aRelatorioInRegerado;
	
	@Column(name=RelatorioDB.REL_UUID)
	private UUID aRelatorioUUID;
	
	@Column(name=RelatorioDB.REL_ARQUIVO)
	@Lob
	private Blob aRelatorioArquivo;
	
	@Column(name=RelatorioDB.AUD_DH_INCLUSAO)
	private Timestamp aAudDhInclusao;
	
	@Column(name=RelatorioDB.AUD_DH_ALTERACAO)
	private Timestamp aAudDhAlteraco;
	
	@Column(name=RelatorioDB.AUD_UUID_USUARIO_INCLUSAO)
	private UUID aAudUsuarioInclusao;
	
	@Column(name=RelatorioDB.AUD_UUID_USUARIO_ALTERACAO)
	private UUID aAudUsuarioAlteracao;

	public RelatorioDB() {
		super();
	}

	public RelatorioDB(TipoRelatorioDB tipoRelatorio, Date aRelatorioDtGeracao,
			boolean aRelatorioInRegerado, UUID aRelatorioUUID,
			Blob aRelatorioArquivo) {
		super();
		this.tipoRelatorio = tipoRelatorio;
		this.aRelatorioDtGeracao = aRelatorioDtGeracao;
		this.aRelatorioInRegerado = aRelatorioInRegerado;
		this.aRelatorioUUID = aRelatorioUUID;
		this.aRelatorioArquivo = aRelatorioArquivo;
	}

	public RelatorioDB(Integer aRelatorioId, TipoRelatorioDB tipoRelatorio,
			String aRelatorioProtocolo, Date aRelatorioDtGeracao,
			boolean aRelatorioInRegerado, UUID aRelatorioUUID,
			Blob aRelatorioArquivo, Timestamp aAudDhInclusao,
			Timestamp aAudDhAlteraco, UUID aAudUsuarioInclusao,
			UUID aAudUsuarioAlteracao) {
		super();
		this.aRelatorioId = aRelatorioId;
		this.tipoRelatorio = tipoRelatorio;
		this.aRelatorioProtocolo = aRelatorioProtocolo;
		this.aRelatorioDtGeracao = aRelatorioDtGeracao;
		this.aRelatorioInRegerado = aRelatorioInRegerado;
		this.aRelatorioUUID = aRelatorioUUID;
		this.aRelatorioArquivo = aRelatorioArquivo;
		this.aAudDhInclusao = aAudDhInclusao;
		this.aAudDhAlteraco = aAudDhAlteraco;
		this.aAudUsuarioInclusao = aAudUsuarioInclusao;
		this.aAudUsuarioAlteracao = aAudUsuarioAlteracao;
	}

	public Integer getaRelatorioId() {
		return aRelatorioId;
	}

	public void setaRelatorioId(Integer aRelatorioId) {
		this.aRelatorioId = aRelatorioId;
	}
	
	public String getaRelatorioProtocolo() {
		return aRelatorioProtocolo;
	}

	public void setaRelatorioProtocolo(String aRelatorioProtocolo) {
		this.aRelatorioProtocolo = aRelatorioProtocolo;
	}

	public TipoRelatorioDB getTipoRelatorio() {
		return tipoRelatorio;
	}

	public void setTipoRelatorio(TipoRelatorioDB tipoRelatorio) {
		this.tipoRelatorio = tipoRelatorio;
	}

	public Date getaRelatorioDtGeracao() {
		return aRelatorioDtGeracao;
	}

	public void setaRelatorioDtGeracao(Date aRelatorioDtGeracao) {
		this.aRelatorioDtGeracao = aRelatorioDtGeracao;
	}

	public boolean isaRelatorioInRegerado() {
		return aRelatorioInRegerado;
	}

	public void setaRelatorioInRegerado(boolean aRelatorioInRegerado) {
		this.aRelatorioInRegerado = aRelatorioInRegerado;
	}

	public UUID getaRelatorioUUID() {
		return aRelatorioUUID;
	}

	public void setaRelatorioUUID(UUID aRelatorioUUID) {
		this.aRelatorioUUID = aRelatorioUUID;
	}

	public Blob getaRelatorioArquivo() {
		return aRelatorioArquivo;
	}

	public void setaRelatorioArquivo(Blob aRelatorioArquivo) {
		this.aRelatorioArquivo = aRelatorioArquivo;
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
		return "RelatorioDB [aRelatorioId=" + aRelatorioId + ", tipoRelatorio="
				+ tipoRelatorio + ", aRelatorioDtGeracao="
				+ aRelatorioDtGeracao + ", aRelatorioInRegerado="
				+ aRelatorioInRegerado + ", aRelatorioUUID=" + aRelatorioUUID
				+ ", aRelatorioArquivo=" + aRelatorioArquivo
				+ ", aAudDhInclusao=" + aAudDhInclusao + ", aAudDhAlteraco="
				+ aAudDhAlteraco + ", aAudUsuarioInclusao="
				+ aAudUsuarioInclusao + ", aAudUsuarioAlteracao="
				+ aAudUsuarioAlteracao + "]";
	}
}
