package com.videogamestore.controller;

import com.videogamestore.model.Client;
import com.videogamestore.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    public ResponseEntity<List<Client>> getClient(){
        List<Client> clients = (List<Client>) clientRepository.findAll();
        return ResponseEntity.ok(clients);
    }

    @RequestMapping(value = "{clientId}")
    public ResponseEntity<Client> getClientById(@PathVariable("clientId") Client client){
        Optional<Client> clients = clientRepository.findById(client.getId());
        if(clients.isPresent()){
            return ResponseEntity.ok(clients.get());
        }else{
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client){
        Client newClient = clientRepository.save(client);
        return ResponseEntity.ok(newClient);
    }

    @DeleteMapping(value = "{clientId}")
    public ResponseEntity<Void> deleteClient(@PathVariable("clientId") Long clientId){
        clientRepository.deleteById(clientId);
        return ResponseEntity.ok(null);
    }

    @PutMapping
    public ResponseEntity<Client> updateCause(@RequestBody Client client){
        Optional<Client> clients = clientRepository.findById(client.getId());
        if(clients.isPresent()){
            Client updateClient = clients.get();
            updateClient.setFirstName(client.getFirstName());
            updateClient.setOtherNames(client.getOtherNames());
            updateClient.setLastName(client.getLastName());
            updateClient.setAge(client.getAge());
            updateClient.setCellphone(client.getCellphone());
            updateClient.setEmail(client.getEmail());
            clientRepository.save(updateClient);
            return ResponseEntity.ok(updateClient);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
