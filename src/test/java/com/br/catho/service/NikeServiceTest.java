package com.br.catho.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.catho.model.Classificador;
import br.com.catho.model.Nota;
import br.com.catho.model.customer.Nike;
import br.com.catho.model.customer.abs.Customer;
import br.com.catho.model.produto.Classic;
import br.com.catho.model.produto.Premium;
import br.com.catho.model.produto.Standout;

public class NikeServiceTest {

	private Double resultado = 0.0;
	private Customer customer;
	private Nota nota;
	
	@Before
	public void init() {
		customer = new Nike();
	}
	
	@Test
	public void calculaNikeSemPrivilegioTest() {
		resultado = 987.97;
		customer.add(new Classic());
		customer.add(new Standout());
		customer.add(new Premium());
		nota = customer.criaNota(new Classificador(customer.getProdutos()));
		assertEquals(3,nota.getProdutos().size());
		assertEquals(resultado,nota.getTotal());	
	}
	
	@Test
	public void calculaNikeComPrivilegioTest() {
		resultado = 2112.94;
		customer.add(new Classic());
		customer.add(new Standout());
		customer.add(new Premium());
		customer.add(new Premium());
		customer.add(new Premium());
		customer.add(new Premium());
		nota = customer.criaNota(new Classificador(customer.getProdutos()));
		assertEquals(6,nota.getProdutos().size());
		assertEquals(resultado,nota.getTotal());	
	}
	
	@Test
	public void calculaNikeComMultiplosProdutosTest() {
		resultado = 4601.87;
		customer.add(new Classic());
		customer.add(new Standout());
		customer.add(new Standout());
		customer.add(new Standout());
		customer.add(new Standout());
		customer.add(new Premium());
		customer.add(new Premium());
		customer.add(new Premium());
		customer.add(new Premium());
		customer.add(new Premium());
		customer.add(new Premium());
		customer.add(new Premium());
		customer.add(new Premium());
		nota = customer.criaNota(new Classificador(customer.getProdutos()));
		assertEquals(13,nota.getProdutos().size());
		assertEquals(resultado,nota.getTotal());	
	}
}