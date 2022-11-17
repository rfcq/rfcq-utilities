package com.rfcq.utilities.service

import com.rfcq.utilities.dto.UuidDTO
import org.junit.jupiter.api.Test
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class DataGeneratorService {

    val uuidDTO = UuidDTO()

    var d1: Int? = Random.nextInt(0, 9)
    var d2: Int? = Random.nextInt(0, 9)
    var d3: Int? = Random.nextInt(0, 9)
    var d4: Int? = Random.nextInt(0, 9)
    var d5: Int? = Random.nextInt(0, 9)
    var d6: Int? = Random.nextInt(0, 9)
    var d7: Int? = Random.nextInt(0, 9)
    var d8: Int? = Random.nextInt(0, 9)
    var d9: Int? = Random.nextInt(0, 9)
    var d10: Int = 0
    var d11: Int = 0
    var d12: Int = 1

    fun getCpf(): String {

        var d1CalcPrimeiroDigito = d1!! * 10
        var d2CalcPrimeiroDigito = d2!! * 9
        var d3CalcPrimeiroDigito = d3!! * 8
        var d4CalcPrimeiroDigito = d4!! * 7
        var d5CalcPrimeiroDigito = d5!! * 6
        var d6CalcPrimeiroDigito = d6!! * 5
        var d7CalcPrimeiroDigito = d7!! * 4
        var d8CalcPrimeiroDigito = d8!! * 3
        var d9CalcPrimeiroDigito = d9!! * 2
        var primeiroDigitoVerificador: Int?

        var somaPrimeiroDigitoVerificador = d1CalcPrimeiroDigito!! + d2CalcPrimeiroDigito!! +
                d3CalcPrimeiroDigito!! + d4CalcPrimeiroDigito!! + d5CalcPrimeiroDigito!! +
                d6CalcPrimeiroDigito!! + d7CalcPrimeiroDigito!! + d8CalcPrimeiroDigito!! +
                d9CalcPrimeiroDigito!!

        var restoDivisaoPrimeiroDigito = somaPrimeiroDigitoVerificador % 11

        if (restoDivisaoPrimeiroDigito >= 2)
            primeiroDigitoVerificador = 11 - restoDivisaoPrimeiroDigito
        else
            primeiroDigitoVerificador = 0

        var d1CalcSegundoDigito = d1!! * 11
        var d2CalcSegundoDigito = d2!! * 10
        var d3CalcSegundoDigito = d3!! * 9
        var d4CalcSegundoDigito = d4!! * 8
        var d5CalcSegundoDigito = d5!! * 7
        var d6CalcSegundoDigito = d6!! * 6
        var d7CalcSegundoDigito = d7!! * 5
        var d8CalcSegundoDigito = d8!! * 4
        var d9CalcSegundoDigito = d9!! * 3
        var d10CalcSegundoDigito = primeiroDigitoVerificador * 2
        var segundoDigitoVerificador: Int?

        var somaSegundoDigitoVerificador = d1CalcSegundoDigito + d2CalcSegundoDigito +
                d3CalcSegundoDigito + d4CalcSegundoDigito + d5CalcSegundoDigito +
                d6CalcSegundoDigito + d7CalcSegundoDigito + d8CalcSegundoDigito +
                d9CalcSegundoDigito + d10CalcSegundoDigito

        var restoDivisaoSegundoDigito = somaSegundoDigitoVerificador % 11

        if (restoDivisaoSegundoDigito >= 2)
            segundoDigitoVerificador = 11 - restoDivisaoSegundoDigito
        else
            segundoDigitoVerificador = 0

        var cpfGerado = "$d1$d2$d3$d4$d5$d6$d7$d8$d9$primeiroDigitoVerificador$segundoDigitoVerificador"

        return cpfGerado
    }

    fun getUuid(): String {
        return uuidDTO.uuid
    }

    fun getCnpj(): String {

        val d1CalcPrimeiroDigito = d1!! * 5
        val d2CalcPrimeiroDigito = d2!! * 4
        val d3CalcPrimeiroDigito = d3!! * 3
        val d4CalcPrimeiroDigito = d4!! * 2
        val d5CalcPrimeiroDigito = d5!! * 9
        val d6CalcPrimeiroDigito = d6!! * 8
        val d7CalcPrimeiroDigito = d7!! * 7
        val d8CalcPrimeiroDigito = d8!! * 6
        val d9CalcPrimeiroDigito = 0 * 5
        val d10CalcPrimeiroDigito = 0 * 4
        val d11CalcPrimeiroDigito = 0 * 3
        val d12CalcPrimeiroDigito = 1 * 2
        val primeiroDigitoVerificador: Int?

        val somaPrimeiroDigitoVerificador = d1CalcPrimeiroDigito + d2CalcPrimeiroDigito +
                d3CalcPrimeiroDigito + d4CalcPrimeiroDigito + d5CalcPrimeiroDigito +
                d6CalcPrimeiroDigito + d7CalcPrimeiroDigito + d8CalcPrimeiroDigito +
                d9CalcPrimeiroDigito + d10CalcPrimeiroDigito + d11CalcPrimeiroDigito +
                d12CalcPrimeiroDigito

        val restoDivisaoPrimeiroDigito = somaPrimeiroDigitoVerificador % 11

        if(restoDivisaoPrimeiroDigito >= 2)
            primeiroDigitoVerificador = 11 - restoDivisaoPrimeiroDigito
        else
            primeiroDigitoVerificador = 0

        val d1CalcSegundoDigito = d1!! * 6
        val d2CalcSegundoDigito = d2!! * 5
        val d3CalcSegundoDigito = d3!! * 4
        val d4CalcSegundoDigito = d4!! * 3
        val d5CalcSegundoDigito = d5!! * 2
        val d6CalcSegundoDigito = d6!! * 9
        val d7CalcSegundoDigito = d7!! * 8
        val d8CalcSegundoDigito = d8!! * 7
        val d9CalcSegundoDigito = 0 * 6
        val d10CalcSegundoDigito = 0 * 5
        val d11CalcSegundoDigito = 0 * 4
        val d12CalcSegundoDigito = 1 * 3
        val d13CalcSegundoDigito = primeiroDigitoVerificador * 2
        val segundoDigitoVerificador: Int?

        val somaSegundoDigitoVerificador = d1CalcSegundoDigito + d2CalcSegundoDigito +
                d3CalcSegundoDigito + d4CalcSegundoDigito + d5CalcSegundoDigito +
                d6CalcSegundoDigito + d7CalcSegundoDigito + d8CalcSegundoDigito +
                d9CalcSegundoDigito + d10CalcSegundoDigito + d11CalcSegundoDigito +
                d12CalcSegundoDigito + d13CalcSegundoDigito

        val restoDivisaoSegundoDigito = somaSegundoDigitoVerificador % 11

        if(restoDivisaoSegundoDigito >= 2)
            segundoDigitoVerificador = 11 - restoDivisaoSegundoDigito
        else
            segundoDigitoVerificador = 0

        val cnpjGerado = "$d1$d2$d3$d4$d5$d6$d7$d8$d9CalcSegundoDigito$d10$d11$d12" +
                "$primeiroDigitoVerificador$segundoDigitoVerificador"

        return cnpjGerado
    }

}