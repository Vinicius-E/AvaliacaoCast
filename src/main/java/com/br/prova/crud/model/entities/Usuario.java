package com.br.prova.crud.model.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@SequenceGenerator(name="seq_usuario", sequenceName="seq_usuario", allocationSize=1, initialValue = 1)
@Data
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
	private Long id;
	
	private String nome;
	
	private int idade;
	

    public Usuario() {
        super();
    }
}
