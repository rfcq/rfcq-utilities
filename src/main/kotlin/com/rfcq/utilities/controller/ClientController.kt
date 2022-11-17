package com.rfcq.utilities.controller

import com.rfcq.utilities.dto.ClientDTO
import com.rfcq.utilities.repository.ClientRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Optional

@RestController
@RequestMapping("/crud")
class ClientController(val repository: ClientRepository) {

    @PostMapping("/clients")
    fun addNewClient(@RequestBody clientDto : ClientDTO): ResponseEntity<ClientDTO> {
        return ResponseEntity(repository.save(clientDto), HttpStatus.CREATED)
    }

    @GetMapping("/clients/{id}")
    fun getClientById(@PathVariable("id") id: Long): ResponseEntity<Optional<ClientDTO>> {
        val client = repository.findById(id)

        if (client.isEmpty) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }

        return ResponseEntity(client, HttpStatus.OK)
    }

    @DeleteMapping("/clients")
    fun removeAllClients(): ResponseEntity<Void> {
        val clients = repository.findAll()

        if (clients.isEmpty()) {
            return ResponseEntity(HttpStatus.NO_CONTENT)
        }

        repository.deleteAll()

        return ResponseEntity(HttpStatus.OK)

    }

    @GetMapping("/clients")
    fun getAllClients(): ResponseEntity<MutableList<ClientDTO>> {
        val clients = repository.findAll()

        if (clients.isEmpty()) {
            return ResponseEntity(HttpStatus.NO_CONTENT)
        }

        return ResponseEntity(clients, HttpStatus.OK)

    }
}