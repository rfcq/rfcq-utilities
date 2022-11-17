package com.rfcq.utilities.controller

import com.rfcq.utilities.dto.CnpjDTO
import com.rfcq.utilities.dto.CpfDTO
import com.rfcq.utilities.dto.UuidDTO
import com.rfcq.utilities.service.DataGeneratorService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/data-generator")
class DataGeneratorController(val service: DataGeneratorService) {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/cpf")
    fun generateCpf(): CpfDTO {
        return CpfDTO(
            cpf = service.getCpf()
        )
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/cnpj")
    fun generateCnpj(): CnpjDTO {
        return CnpjDTO(
            cnpj = service.getCnpj()
        )
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/uuid")
    fun generateUuid(): UuidDTO = UuidDTO()

}