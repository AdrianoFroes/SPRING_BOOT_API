package med.voll.api.medico;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.DadosEndereco;
import med.voll.api.endereco.Endereco;


@Table(name = "medicos")
@Entity(name = "Medicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Medico {
	
	public Medico(DadosCadastroMedicos dados) {
		this.ativo = true;
		this.nome = dados.nome();
		this.email = dados.email();
		this.crm = dados.crm();
		this.especialidade = dados.especialidade();
		this.endereco = new Endereco(dados.endereco());
		
		
	}

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String email;
	private String crm;
	
	@Enumerated(EnumType.STRING)
	private Especialidade especialidade;
	
	@Embedded
	private Endereco endereco;
	
	private Boolean ativo;
	
	private String telefone;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public  void atualizarInformacoes(@Valid DadosAtualizarMedico dados) {
		if(dados.nome()!= null) {
		this.nome = dados.nome();
		
		}
		if(dados.telefone() !=null) {
			this.telefone = dados.telefone();
		}
		if(dados.endereco() !=null) {
			this.endereco.atualizarInformacoes(dados.endereco());
		}
	}

	public void excluir() {
		this.ativo = false;
		
	}



}
