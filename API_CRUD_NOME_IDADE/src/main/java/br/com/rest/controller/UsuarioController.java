package br.com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.rest.model.Usuario;
import br.com.rest.repository.UsuarioRepository;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	
	@RequestMapping(value = "/mostrar/{name}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	
	public String greetingText(@PathVariable String name) {
		return "Curso Spring Boot API: " + name + "!";
	}
	@RequestMapping(value = "/olamundo/{nome}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String retornaOlaMundo(@PathVariable String nome) {
		
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuarioRepository.save(usuario);
		
		return "Ola mundo "+ nome;
		
	}
	
	@GetMapping(value = "listatodos")
	@ResponseBody
	public ResponseEntity<List<Usuario>> listaUsuario(){
		List<Usuario> usuarios = (List<Usuario>) usuarioRepository.findAll();
		
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
		
	}
	
	@PostMapping(value = "salvar")
	@ResponseBody
	public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario){
		Usuario user = usuarioRepository.save(usuario);
		return new ResponseEntity<Usuario>(user, HttpStatus.CREATED);
	}
	@DeleteMapping(value = "delete")
	@ResponseBody
	public ResponseEntity<String> delete(@RequestParam Long iduser){
		usuarioRepository.deleteById(iduser);
		return new ResponseEntity<String>("registro deletado com sucesso",HttpStatus.OK);
	}
	
	@GetMapping(value = "buscaruserid")
	@ResponseBody
	public ResponseEntity<Usuario> buscaruserid(@RequestParam(name = "iduser")Long iduser){
		Usuario usuario = usuarioRepository.findById(iduser).get();
		
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	@PutMapping(value = "atualizar")
	@ResponseBody
	public ResponseEntity<?> atualizar(@RequestBody Usuario usuario){
		if(usuario.getId()== null) {
			return new ResponseEntity<String>("Id não informado para atualização", HttpStatus.OK);
			
		}
		
		Usuario user = usuarioRepository.save(usuario);
		
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	@GetMapping(value = "buscarPorNome")
	@ResponseBody
	public ResponseEntity<List<Usuario>> buscarPorNome(@RequestParam(name = "name")String name){
		List<Usuario> usuario = usuarioRepository.buscarPorNome(name.trim().toUpperCase());
		
		return new ResponseEntity<List<Usuario>>(usuario,HttpStatus.OK);
	}
	
}
