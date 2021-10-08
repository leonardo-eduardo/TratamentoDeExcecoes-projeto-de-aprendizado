package aplicacao;

public class ContaException extends Exception {

	private static final long serialVersionUID = 8111099400613668482L;

	private String mensagem;

	public ContaException(String mensagem) {
		super(mensagem);
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

}
