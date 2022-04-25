package com.rfcq.utilities.service

import com.rfcq.utilities.dto.RescisaoCalcDTO
import org.springframework.stereotype.Service

@Service
class CalculatorService {

    fun CalculaRescisao() {

    }

    fun SaldoSalario(): Double {
        val rescisaoCalcDTO = RescisaoCalcDTO(
            salario = 1200.00, diasTrabalhados = 30
        )
        val calcSaldoSalario = rescisaoCalcDTO.salario / 30 * rescisaoCalcDTO.diasTrabalhados

        return calcSaldoSalario
    }

    fun DecimoTerceiroProporcional() {

    }
}