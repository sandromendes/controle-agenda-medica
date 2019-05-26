package main.java.br.com.eutimia.model.autenticacao;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="SE_TAB_USUARIO")
public class UsuarioDB implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String ID_OBJETO = "usuarioDB";
	public static final String _USUARIO_AUTENTICADO = "usuarioAutenticado";
	
	public static final String USR_ID = "USR_ID";
	public static final String USR_NM_LOGIN = "usr_nm_login";
	public static final String USR_TX_SENHA = "USR_TX_SENHA";
	public static final String USR_TX_SALT = "USR_TX_SALT";
	public static final String USR_NM_NOME = "USR_NM_NOME";
	public static final String USR_NM_SOBRENOME = "USR_NM_SOBRENOME";
	public static final String USR_NM_EMAIL = "USR_NM_EMAIL";
	public static final String USR_NM_EMAIL_SECUNDARIO = "USR_NM_EMAIL_SECUNDARIO";
	public static final String USR_NU_TELEFONE = "USR_NU_TELEFONE";
	public static final String USR_IN_CONFIRMADO = "USR_IN_CONFIRMADO";
	public static final String USR_IN_BLOQUEADO = "USR_IN_BLOQUEADO";
	public static final String USR_IN_CANCELADO = "USR_IN_CANCELADO";
	public static final String USR_TX_URL_CONFIRMACAO = "USR_TX_URL_CONFIRMACAO";
	public static final String USR_UUID = "USR_UUID";
	public static final String AUD_DH_INCLUSAO = "AUD_DH_INCLUSAO";
	public static final String AUD_DH_ALTERACAO = "AUD_DH_ALTERACAO";
	public static final String AUD_UUID_USUARIO_INCLUSAO = "AUD_UUID_USUARIO_INCLUSAO";
	public static final String AUD_UUID_USUARIO_ALTERACAO = "AUD_UUID_USUARIO_ALTERACAO";
	
	@Id
	@Column(name=UsuarioDB.USR_ID)
	@SequenceGenerator(name="USR_SEQ", sequenceName="USR_SEQ", allocationSize=1)
	@GeneratedValue(generator="USR_SEQ")
	private Integer aUsuarioId;
	
	@Column(name=UsuarioDB.USR_NM_LOGIN)
	private String aUsuarioLogin;
	
	@Column(name=UsuarioDB.USR_TX_SENHA)
	private String aUsuarioSenha;
	
	@Column(name=UsuarioDB.USR_TX_SALT)
	private String aUsuarioSalt;
	
	@Column(name=UsuarioDB.USR_NM_NOME)
	private String aUsuarioNome;
	
	@Column(name=UsuarioDB.USR_NM_SOBRENOME)
	private String aUsuarioSobrenome;
	
	@Column(name=UsuarioDB.USR_NM_EMAIL)
	private String aUsuarioEmail;
	
	@Column(name=UsuarioDB.USR_NM_EMAIL_SECUNDARIO)
	private String aUsuarioEmailSecundario;
	
	@Column(name=UsuarioDB.USR_NU_TELEFONE)
	private String aUsuarioNuTelefone;
	
	@Column(name=UsuarioDB.USR_IN_CONFIRMADO)
	private boolean aUsuarioInConfirmado;
	
	@Column(name=UsuarioDB.USR_IN_BLOQUEADO)
	private boolean aUsuarioInBloqueado;
	
	@Column(name=UsuarioDB.USR_IN_CANCELADO)
	private boolean aUsuarioInCancelado;
	
	@Column(name=UsuarioDB.USR_TX_URL_CONFIRMACAO)
	private String aTxURLConfirmacao;
	
	@Column(name=UsuarioDB.USR_UUID)
	private UUID aUsuarioUUID;
	
	@Column(name=UsuarioDB.AUD_DH_INCLUSAO)
	private Timestamp aAudDhInclusao;
	
	@Column(name=UsuarioDB.AUD_DH_ALTERACAO)
	private Timestamp aAudDhAlteraco;
	
	@Column(name=UsuarioDB.AUD_UUID_USUARIO_INCLUSAO)
	private UUID aAudUsuarioInclusao;
	
	@Column(name=UsuarioDB.AUD_UUID_USUARIO_ALTERACAO)
	private UUID aAudUsuarioAlteracao;

	public UsuarioDB() {
		super();
	}

	public UsuarioDB(Integer aUsuarioId, String aUsuarioLogin,
			String aUsuarioSenha, String aUsuarioSalt, String aUsuarioNome,
			String aUsuarioSobrenome, String aUsuarioEmail,
			String aUsuarioEmailSecundario, String aUsuarioNuTelefone,
			boolean aUsuarioInConfirmado, boolean aUsuarioInBloqueado,
			boolean aUsuarioInCancelado, String aTxURLConfirmacao,
			UUID aUsuarioUUID, Timestamp aAudDhInclusao,
			Timestamp aAudDhAlteraco, UUID aAudUsuarioInclusao,
			UUID aAudUsuarioAlteracao) {
		super();
		this.aUsuarioId = aUsuarioId;
		this.aUsuarioLogin = aUsuarioLogin;
		this.aUsuarioSenha = aUsuarioSenha;
		this.aUsuarioSalt = aUsuarioSalt;
		this.aUsuarioNome = aUsuarioNome;
		this.aUsuarioSobrenome = aUsuarioSobrenome;
		this.aUsuarioEmail = aUsuarioEmail;
		this.aUsuarioEmailSecundario = aUsuarioEmailSecundario;
		this.aUsuarioNuTelefone = aUsuarioNuTelefone;
		this.aUsuarioInConfirmado = aUsuarioInConfirmado;
		this.aUsuarioInBloqueado = aUsuarioInBloqueado;
		this.aUsuarioInCancelado = aUsuarioInCancelado;
		this.aTxURLConfirmacao = aTxURLConfirmacao;
		this.aUsuarioUUID = aUsuarioUUID;
		this.aAudDhInclusao = aAudDhInclusao;
		this.aAudDhAlteraco = aAudDhAlteraco;
		this.aAudUsuarioInclusao = aAudUsuarioInclusao;
		this.aAudUsuarioAlteracao = aAudUsuarioAlteracao;
	}

	public Integer getaUsuarioId() {
		return aUsuarioId;
	}

	public void setaUsuarioId(Integer aUsuarioId) {
		this.aUsuarioId = aUsuarioId;
	}

	public String getaUsuarioLogin() {
		return aUsuarioLogin;
	}

	public void setaUsuarioLogin(String aUsuarioLogin) {
		this.aUsuarioLogin = aUsuarioLogin;
	}

	public String getaUsuarioSenha() {
		return aUsuarioSenha;
	}

	public void setaUsuarioSenha(String aUsuarioSenha) {
		this.aUsuarioSenha = aUsuarioSenha;
	}

	public String getaUsuarioSalt() {
		return aUsuarioSalt;
	}

	public void setaUsuarioSalt(String aUsuarioSalt) {
		this.aUsuarioSalt = aUsuarioSalt;
	}

	public String getaUsuarioNome() {
		return aUsuarioNome;
	}

	public void setaUsuarioNome(String aUsuarioNome) {
		this.aUsuarioNome = aUsuarioNome;
	}

	public String getaUsuarioSobrenome() {
		return aUsuarioSobrenome;
	}

	public void setaUsuarioSobrenome(String aUsuarioSobrenome) {
		this.aUsuarioSobrenome = aUsuarioSobrenome;
	}

	public String getaUsuarioEmail() {
		return aUsuarioEmail;
	}

	public void setaUsuarioEmail(String aUsuarioEmail) {
		this.aUsuarioEmail = aUsuarioEmail;
	}

	public String getaUsuarioEmailSecundario() {
		return aUsuarioEmailSecundario;
	}

	public void setaUsuarioEmailSecundario(String aUsuarioEmailSecundario) {
		this.aUsuarioEmailSecundario = aUsuarioEmailSecundario;
	}

	public String getaUsuarioNuTelefone() {
		return aUsuarioNuTelefone;
	}

	public void setaUsuarioNuTelefone(String aUsuarioNuTelefone) {
		this.aUsuarioNuTelefone = aUsuarioNuTelefone;
	}

	public boolean isaUsuarioInConfirmado() {
		return aUsuarioInConfirmado;
	}

	public void setaUsuarioInConfirmado(boolean aUsuarioInConfirmado) {
		this.aUsuarioInConfirmado = aUsuarioInConfirmado;
	}

	public boolean isaUsuarioInBloqueado() {
		return aUsuarioInBloqueado;
	}

	public void setaUsuarioInBloqueado(boolean aUsuarioInBloqueado) {
		this.aUsuarioInBloqueado = aUsuarioInBloqueado;
	}

	public boolean isaUsuarioInCancelado() {
		return aUsuarioInCancelado;
	}

	public void setaUsuarioInCancelado(boolean aUsuarioInCancelado) {
		this.aUsuarioInCancelado = aUsuarioInCancelado;
	}

	public String getaTxURLConfirmacao() {
		return aTxURLConfirmacao;
	}

	public void setaTxURLConfirmacao(String aTxURLConfirmacao) {
		this.aTxURLConfirmacao = aTxURLConfirmacao;
	}

	public UUID getaUsuarioUUID() {
		return aUsuarioUUID;
	}

	public void setaUsuarioUUID(UUID aUsuarioUUID) {
		this.aUsuarioUUID = aUsuarioUUID;
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
}
