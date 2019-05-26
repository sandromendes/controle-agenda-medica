package main.java.br.com.eutimia.model;

import java.io.Serializable;
import java.util.Collection;

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

@Entity
@Table(name="SE_TAB_TIPORELATORIO")
public class TipoRelatorioDB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String ID_OBJETO = "tipoRelatorioDB";
	
	public static final String TPREL_ID = "TPREL_ID";
	public static final String TPREL_DS_DESCRICAO = "TPREL_DS_NOME";
	
	@Id
	@Column(name=TipoRelatorioDB.TPREL_ID)
	@SequenceGenerator(name="TPREL_SEQ", sequenceName="TPREL_SEQ", allocationSize=1)
	@GeneratedValue(generator="TPREL_SEQ")
	private Integer aTipoRelatorioId;
	
	@Column(name=TipoRelatorioDB.TPREL_DS_DESCRICAO)
	private String aTipoRelatorioDescricao;
	
	@OneToMany(mappedBy = "tipoRelatorio", fetch = FetchType.LAZY)
	@Cascade(CascadeType.ALL)
	private Collection<RelatorioDB> aColecaoRelatorio;
	
	public TipoRelatorioDB() {
		super();
	}

	public TipoRelatorioDB(Integer aTipoRelatorioId,
			String aTipoRelatorioDescricao) {
		super();
		this.aTipoRelatorioId = aTipoRelatorioId;
		this.aTipoRelatorioDescricao = aTipoRelatorioDescricao;
	}
	
	public TipoRelatorioDB(Integer aTipoRelatorioId,
			String aTipoRelatorioDescricao,
			Collection<RelatorioDB> aColecaoRelatorio) {
		super();
		this.aTipoRelatorioId = aTipoRelatorioId;
		this.aTipoRelatorioDescricao = aTipoRelatorioDescricao;
		this.aColecaoRelatorio = aColecaoRelatorio;
	}

	public Integer getaTipoRelatorioId() {
		return aTipoRelatorioId;
	}

	public void setaTipoRelatorioId(Integer aTipoRelatorioId) {
		this.aTipoRelatorioId = aTipoRelatorioId;
	}

	public String getaTipoRelatorioDescricao() {
		return aTipoRelatorioDescricao;
	}

	public void setaTipoRelatorioDescricao(String aTipoRelatorioDescricao) {
		this.aTipoRelatorioDescricao = aTipoRelatorioDescricao;
	}
}
