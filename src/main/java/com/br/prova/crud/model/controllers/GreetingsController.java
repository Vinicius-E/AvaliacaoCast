package com.br.prova.crud.model.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.br.prova.crud.model.entities.Usuario;
import com.br.prova.crud.model.repositories.UsuarioRepository;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class GreetingsController {

	@Autowired
	private UsuarioRepository userR;

	private Usuario user;

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String greetingText(@PathVariable String name) {
		return "Hello " + name + "!";
	}

	@RequestMapping(value = "/usuario/{nome}/idade/{idade}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String salvarUsuario(@PathVariable String nome, @PathVariable int idade) {
		user.setNome(nome);
		user.setIdade(idade);
		userR.save(user);

		return "Usuário Salvo. Nome: " + nome + " | Idade: " + idade;
	}

	@RequestMapping(value = "/usuario-buscarTodos", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Usuario> buscarTodos() {
		return userR.findAll();
	}

	@DeleteMapping(value = "/usuario-deletarPorId")
	   @ResponseBody
	   public ResponseEntity<Usuario> delete(@RequestParam Long id){
	   	
	   	userR.deleteById(id);
	   	
	   	return new ResponseEntity<Usuario>(HttpStatus.OK);

	   }

}
