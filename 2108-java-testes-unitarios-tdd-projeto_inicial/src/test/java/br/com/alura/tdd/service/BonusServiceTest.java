package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void bonusDeveriaSerZeroParaFuncionarComSalarioAlto() {
		BonusService bonusService = new BonusService();

		// 1º Opção
		assertThrows(IllegalArgumentException.class,
				() -> bonusService.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000"))));
	}
	// 2º Opção
	/*
	 * try { bonusService.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(),
	 * new BigDecimal("25000"))); fail("Não deu a Exception"); } catch (Exception e)
	 * {
	 * assertEquals("Funcionário com salário maior do que 10000, não pode receber bonus"
	 * , e.getMessage()); } }
	 */

	@Test
	void bonusDeveriaSer10PorCentoDoSalario() {
		BonusService bonusService = new BonusService();

		BigDecimal bonus = bonusService
				.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("2500")));

		assertEquals(new BigDecimal("250.00"), bonus);
	}

	@Test
	void bonusDeveriaSer10PorCentoParaSalarioDeExatamente10000() {
		BonusService bonusService = new BonusService();

		BigDecimal bonus = bonusService
				.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("10000")));

		assertEquals(new BigDecimal("1000.00"), bonus);
	}

}
