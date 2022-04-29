package com.rfcq.utilities.controller

import com.rfcq.utilities.dto.CalculoSalarioLiquidoDTO
import com.rfcq.utilities.dto.SalarioLiquidoDTO
import com.rfcq.utilities.service.CalculatorService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/calculator")
class CalculatorController (val service: CalculatorService){

    @PostMapping("/salario-liquido")
    fun calcSalarioLiquido(@RequestBody calculoSalarioLiquidoDTO: CalculoSalarioLiquidoDTO): SalarioLiquidoDTO {

        return SalarioLiquidoDTO(
                faixaSalarialIrrf = service.getFaixaSalarialIrrf(calculoSalarioLiquidoDTO.salarioBruto),
                faixaSalarialInss = service.getFaixaSalarialInss(calculoSalarioLiquidoDTO.salarioBruto),
                aliquotaInss = service.getAliquotaInss(calculoSalarioLiquidoDTO.salarioBruto),
                aliquotaIrrf = service.getAliquotaIrrf(
                        service.calculoInss(calculoSalarioLiquidoDTO.salarioBruto)
                ),
                deducaoIrrf = service.getDeducaoIrrf(calculoSalarioLiquidoDTO.salarioBruto),
                calculoBase = service.calculoInss(calculoSalarioLiquidoDTO.salarioBruto),
                calculoIrrf = service.calculoIrrf(
                        service.calculoInss(calculoSalarioLiquidoDTO.salarioBruto)
                ),
                salarioLiquido = service.calculoSalarioLiquido(calculoSalarioLiquidoDTO.salarioBruto,
                        calculoSalarioLiquidoDTO.valorPlanoDeSaude,
                        calculoSalarioLiquidoDTO.valorPat,
                        calculoSalarioLiquidoDTO.outrosDescontos
                )
        )

    }

}