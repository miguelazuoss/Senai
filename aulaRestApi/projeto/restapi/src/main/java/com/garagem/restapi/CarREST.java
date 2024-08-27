package com.garagem.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.garagem.restapi.database.RepositoryCar;
import com.garagem.restapi.entities.Car;

@RestController
@RequestMapping("/car")
public class CarREST {
    @Autowired // Cria o objeto e injeto dentro do repository para cuidar
    private RepositoryCar repository;

    //definir os metodos do CRUD
    @GetMapping
    public List<Car> listar(){
        return repository.findAll();
    }

    @PutMapping
    public void salvar(@RequestBody Car id){
        repository.save(id);
   }

   @PutMapping
   public void alterar(@RequestBody Car id){
    if (id.getId() > 0) {
        repository.save(id);
    }
   }

   @DeleteMapping
   public void excluir(@RequestBody Car id){
    repository.delete(id);
   }

}
