import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Conta {
	
	//  variável usada para o saldo
	int saldo;
	
	//  variável usada para o saque
	int saque;
	
	//  variável para mostrar se cliente é comum, definido como falso de início
	boolean clienteComum = false;
	
	//  variável para mostrar se cliente é especial, definido como falso de início
	boolean clienteEspecial = false;
	
	/* começo do primeiro cenário - cliente especial
	 * 
	 * @param int1 é o primeiro parâmetro, ele se refere ao saldo atual do cliente especial
	 * O objetivo é que o valor recebido para saldo seja -200 e o cliente seja especial
	 */
	
	@Given("Cliente especial com saldo atual de {int} reais")
	public void um_cliente_especial_com_saldo_atual_de_reais(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		this.saldo = int1;
		this.clienteEspecial = true;
		if(this.saldo != -200 && !this.clienteEspecial)
			throw new io.cucumber.java.PendingException();
	}

	/*
	 * @param int2 é o segundo parâmetro, ele se refere ao valor de saque feito pelo cliente especial
	 * O objetivo é que o valor recebido para saque seja 100 e que o cliente seja especial
	 */
	
	@When("for solicitado um saque no valor de {int} reais")
	public void for_solicitado_um_saque_no_valor_de_reais(Integer int2) {
	    // Write code here that turns the phrase above into concrete actions
		this.saque = int2;
		if(this.saque != 100 && !this.clienteEspecial)
			throw new io.cucumber.java.PendingException();
	}

	/*
	 * @param int3 é o terceiro parâmetro, ele se refere ao valor que restará de saldo
	 * do cliente especial depois de subtrair o saldo recebido anteriormente pelo valor de saque
	 * O objetivo é que o valor do saldo seja de -300 e que o cliente seja especial
	 */
	
	@Then("deve efetuar o saque e atualizar o saldo da conta para {int} reais")
	public void deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reais(Integer int3) {
	    // Write code here that turns the phrase above into concrete actions
		if(this.saldo - this.saque != int3 && !this.clienteEspecial)
			throw new io.cucumber.java.PendingException();
	}

	/* Inicio do segundo cenário: Cliente comum
	 * 
	 * @param int4 é o quarto parâmetro, ele se refere ao saldo atual do cliente comum
	 * O objetivo, é que o valor recebido no saldo seja ao todo -300 e que o cliente seja comum
	 */
	
	@Given("Um cliente comum com saldo atual de {int} reais")
	public void um_cliente_comum_com_saldo_atual_de_reais(Integer int4) {
	    // Write code here that turns the phrase above into concrete actions
		this.saldo = int4;
		this.clienteComum = true;
		if(this.saldo != -300 && !this.clienteComum)
			throw new io.cucumber.java.PendingException();
	}

	/*
	 * @param int5 é o quinto parâmetro, ele se refere ao valor de saque feito pelo cliente comum
	 * O objetivo é que o valor recebido no saque seja ao todo 100 e que o cliente seja comum
	 */
	
	@When("solicitar um saque de {int} reais")
	public void solicitar_um_saque_de_reais(Integer int5) {
	    // Write code here that turns the phrase above into concrete actions
		this.saque = int5;
		if(this.saque != 200 && !this.clienteComum)
			throw new io.cucumber.java.PendingException();
	}

	/*
	 * O objetivo é que o cliente seja normal, e por ele ter saldo negativo, não conseguirá fazer o saque,
	 * com isso a mensagem "Saldo Insuficiente" será retornada 
	 */
	
	@Then("Não deve efetuar o saque e deve retornar a mensagem Saldo Insuficiente")
	public void não_deve_efetuar_o_saque_e_deve_retornar_a_mensagem_saldo_insuficiente() {
	    // Write code here that turns the phrase above into concrete actions
		if(!this.clienteComum) {
			throw new io.cucumber.java.PendingException();			
		} else {
			System.out.println("Saldo Insuficiente");
		}
	}
}
