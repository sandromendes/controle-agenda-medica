package main.java.br.com.eutimia.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;

@Embeddable
public class PacientePlanoPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name=PacientePlanoDB.PACPLS_ID)
	@SequenceGenerator(name="PACPLS_SEQ", sequenceName="PACPLS_SEQ", allocationSize=1)
	@GeneratedValue(generator="PACPLS_SEQ")
	private Integer aPacientePlanoId;
	
	private Integer aPacienteId;
	
	private Integer aPlanoSaudeId;

	public PacientePlanoPK(Integer aPacientePlanoId, Integer aPacienteId,
			Integer aPlanoSaudeId) {
		super();
		this.aPacientePlanoId = aPacientePlanoId;
		this.aPacienteId = aPacienteId;
		this.aPlanoSaudeId = aPlanoSaudeId;
	}

	public Integer getaPacientePlanoId() {
		return aPacientePlanoId;
	}

	public void setaPacientePlanoId(Integer aPacientePlanoId) {
		this.aPacientePlanoId = aPacientePlanoId;
	}

	public Integer getaPacienteId() {
		return aPacienteId;
	}

	public void setaPacienteId(Integer aPacienteId) {
		this.aPacienteId = aPacienteId;
	}

	public Integer getaPlanoSaudeId() {
		return aPlanoSaudeId;
	}

	public void setaPlanoSaudeId(Integer aPlanoSaudeId) {
		this.aPlanoSaudeId = aPlanoSaudeId;
		}
	
}
