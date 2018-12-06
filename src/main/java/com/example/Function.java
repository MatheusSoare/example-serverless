package com.example;

import java.util.*;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;
import java.util.stream.Stream;


public class Function {
    
    class Cidade{
        
        private Long id;
        private String nome;
        private Estado estado;

        public Cidade(Long id, String nome, Estado estado) {
            
            this.id = id;
            this.nome = nome;
            this.estado = estado;
            
        }
        
        public Cidade() {}

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public Estado getEstado() {
            return estado;
        }

        public void setEstado(Estado estado) {
            this.estado = estado;
        }

        @Override
        public String toString() {
            return "Cidade{" + "id=" + id + ", nome=" + nome + ", estado=" + estado + '}';
        }
        
    }
    
    class Estado{
        
        private Long id;
        private String nome;

        public Estado(Long id, String nome) {
            
            this.id = id;
            this.nome = nome;
            
        }

        public Estado() {}

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        @Override
        public String toString() {
            return "Estado{" + "id=" + id + ", nome=" + nome + '}';
        }
        
    }
    
    @FunctionName("funcaocriarcidade")
    public Cidade criar(@HttpTrigger(name = "restcriarcidade", methods = {HttpMethod.POST}, route = "cidade") Cidade cidade){
        
        cidade.setId(new Long(1));
        
        return cidade;
        
    }
    
    @FunctionName("funcalercidade")
    public List<Cidade> ler(@HttpTrigger(name = "restlercidade", methods = {HttpMethod.GET}, route = "cidade")String aux){
        
        return Stream.of.(
                
                new Cidade(1, "Cornélio Procópio", new Estado(1,"PR")),
                new Cidade(2, "São Paulo", new Estado(2,"SP")),
                
        ).collect(Collectors.toList());
        
    }
    
    @FunctionName("funcaoalterarcidade")
    public Cidade alterar(@HttpTrigger(name = "restalterarcidade", methods = {HttpMethod.PUT}, route = "cidade") Cidade cidade){
        
        cidade.setNome(cidade.getNome() + "-- Alterado --");
        
        return cidade;
        
    }
    
    @FunctionName("funcaoapagarcidade")
    public int apagar(@HttpTrigger(name = "restapagarcidade", methods = {HttpMethod.DELETE}, route = "cidade/{id}") @BindingName ("id") Long id){
        
        return 200;
        
    }
}
