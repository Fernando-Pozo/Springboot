package br.org.generation.minhaLojaGame.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.blogpessoal.service.UsuarioService;
import br.org.generation.minhaLojaGame.model.Usuario;
import br.org.generation.minhaLojaGame.model.UsuarioLogin;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/all")
	public ResponseEntity <List<Usuario>> getall(){
		return ResponseEntity.ok(usuarioService.listarUsuarios());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <Usuario> getById(@PathVariable Long id){
		return usuarioService.buscarUsuarioId(id)
				.map(resp -> ResponseEntity.status(HttpStatus.OK).body(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	@PostMapping("/logar")
	public ResponseEntity<UsuarioLogin> loginUsuario(@RequestBody Optional <UsuarioLogin> usuarioLogin){
		
		return usuarioService.loginUsuario(usuarioLogin)
			.map(resp -> ResponseEntity.ok(resp))
			.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());

	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> postUsuario(@RequestBody Usuario usuario){
		
		return usuarioService.cadastrarUsuario(usuario)
			.map(resp -> ResponseEntity.status(HttpStatus.CREATED).body(resp))
			.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Usuario> putUsuario(@RequestBody Usuario usuario){
		
		return usuarioService.atualizarUsuario(usuario)
			.map(resp -> ResponseEntity.status(HttpStatus.OK).body(resp))
			.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
        
	}
}
