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

		// 1� Op��o
		assertThrows(IllegalArgumentException.class,
				() -> bonusService.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000"))));
	}
	// 2� Op��o
	/*
	 * try { bonusService.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(),
	 * new BigDecimal("25000"))); fail("N�o deu a Exception"); } catch (Exception e)
	 * {
	 * assertEquals("Funcion�rio com sal�rio maior do que 10000, n�o pode receber bonus"
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
