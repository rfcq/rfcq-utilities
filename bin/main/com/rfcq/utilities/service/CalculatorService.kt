package com.rfcq.utilities.service

import com.rfcq.utilities.dto.CalculoSalarioLiquidoDTO
import com.rfcq.utilities.dto.RescisaoCalcDTO
import com.rfcq.utilities.dto.SalarioLiquidoDTO
import org.junit.jupiter.api.Test
import org.springframework.stereotype.Service

@Service
class CalculatorService {

    var salarioLiquidoDTO = SalarioLiquidoDTO()
    var calculoSalarioLiquidoDTO = CalculoSalarioLiquidoDTO()

    fun CalculaRescisao() {

    }

    fun caldoSalario(): Double {
        val rescisaoCalcDTO = RescisaoCalcDTO(
            salario = 1200.00, diasTrabalhados = 30
        )
        val calcSaldoSalario = rescisaoCalcDTO.salario / 30 * rescisaoCalcDTO.diasTrabalhados

        return calcSaldoSalario
    }

    fun DecimoTerceiroProporcional() {

    }

    fun getAliquotaInss(salarioBruto: Double): Double {
        if(salarioBruto <= 1212.00) {
            salarioLiquidoDTO.aliquotaInss = 7.5
        } else if(salarioBruto > 1212.00 && salarioBruto <= 2427.35) {
            salarioLiquidoDTO.aliquotaInss = 9.0
        } else if(salarioBruto > 2427.35 && salarioBruto <= 3641.03) {
            salarioLiquidoDTO.aliquotaInss = 12.0
        } else if(salarioBruto > 3641.03 && salarioBruto <= 7087.22) {
            salarioLiquidoDTO.aliquotaInss = 14.0
        } else if(salarioBruto > 7087.22) {
            salarioLiquidoDTO.aliquotaInss = 828.39
        }

        return salarioLiquidoDTO.aliquotaInss
    }

    fun getFaixaSalarialInss(salarioBruto: Double): String {
        if(salarioBruto <= 1212.00) {
            salarioLiquidoDTO.faixaSalarialInss = "Até R$ 1212,00"
        } else if(salarioBruto > 1212.00 && salarioBruto <= 2427.35) {
            salarioLiquidoDTO.faixaSalarialInss = "De R$ 1212,01 até R$ 2427,35"
        } else if(salarioBruto > 2427.35 && salarioBruto <= 3641.03) {
            salarioLiquidoDTO.faixaSalarialInss = "De R$ 2427,36 até R$ 3641,03"
        } else if(salarioBruto > 3641.03 && salarioBruto <= 7087.22) {
            salarioLiquidoDTO.faixaSalarialInss = "De R$ 3641,04 até R$ 7087,22"
        } else if(salarioBruto > 7087.22) {
            salarioLiquidoDTO.faixaSalarialInss = "Acima de R$ 7087,22"
        }

        return salarioLiquidoDTO.faixaSalarialInss
    }

    fun calculoInss(salarioBruto: Double): Double {
        var aliquotaInss = getAliquotaInss(salarioBruto)

        var contribuicaoInss: Double?

        if (aliquotaInss != 828.39)
            contribuicaoInss = (salarioBruto * aliquotaInss)/100
        else
            contribuicaoInss = aliquotaInss

        return salarioBruto - contribuicaoInss!! -
                calculoSalarioLiquidoDTO.valorPensaoAlimenticia -
                calculoSalarioLiquidoDTO.numeroDependentes * 189.59

    }

    fun getAliquotaIrrf(calculoBase: Double?): Double {
        if(calculoBase!= null) {
            if (calculoBase <= 1903.98) {
                salarioLiquidoDTO.aliquotaIrrf = 0.0
            } else if (calculoBase > 1903.98 && calculoBase <= 2826.65) {
                salarioLiquidoDTO.aliquotaIrrf = 7.5
            } else if (calculoBase > 2826.65 && calculoBase <= 3751.05) {
                salarioLiquidoDTO.aliquotaIrrf = 15.0
            } else if (calculoBase > 3751.05 && calculoBase <= 4664.68) {
                salarioLiquidoDTO.aliquotaIrrf = 22.5
            } else if (calculoBase > 4664.68) {
                salarioLiquidoDTO.aliquotaIrrf = 27.5
            }
        }
        return salarioLiquidoDTO.aliquotaIrrf
    }

    fun getFaixaSalarialIrrf(calculoBase: Double?): String {
        if(calculoBase!= null) {
            if (calculoBase <= 1903.98) {
                salarioLiquidoDTO.faixaSalarialIrrf = "Até R$ 1903,98"
            } else if (calculoBase > 1903.98 && calculoBase <= 2826.65) {
                salarioLiquidoDTO.faixaSalarialIrrf = "De R$ 1903,99 até R$ 2826,65"
            } else if (calculoBase > 2826.65 && calculoBase <= 3751.05) {
                salarioLiquidoDTO.faixaSalarialIrrf = "De R$ 2826.66 até R$ 3751.05"
            } else if (calculoBase > 3751.05 && calculoBase <= 4664.68) {
                salarioLiquidoDTO.faixaSalarialIrrf = "De R$ 3751.06 até R$ 4664.68"
            } else if (calculoBase > 4664.68) {
                salarioLiquidoDTO.faixaSalarialIrrf = "Acima de R$ 4664.68"
            }
        }
        return salarioLiquidoDTO.faixaSalarialIrrf
    }

    fun getDeducaoIrrf(calculoBase: Double?): Double {
        if(calculoBase!= null) {
            if (calculoBase <= 1903.98) {
                salarioLiquidoDTO.deducaoIrrf = 0.0
            } else if (calculoBase > 1903.98 && calculoBase <= 2826.65) {
                salarioLiquidoDTO.deducaoIrrf = 142.80
            } else if (calculoBase > 2826.65 && calculoBase <= 3751.05) {
                salarioLiquidoDTO.deducaoIrrf = 354.80
            } else if (calculoBase > 3751.05 && calculoBase <= 4664.68) {
                salarioLiquidoDTO.deducaoIrrf = 636.13
            } else if (calculoBase > 4664.68) {
                salarioLiquidoDTO.deducaoIrrf = 869.36
            }
        }
        return salarioLiquidoDTO.deducaoIrrf
    }

    fun calculoIrrf(calculoBase: Double?): Double {

        return ((calculoBase!! * getAliquotaIrrf(calculoBase)) / 100) - getDeducaoIrrf(calculoBase)
    }

    @Test
    fun calculoSalarioLiquido(salarioBruto: Double, valorPlanoDeSaude: Double, valorPat: Double,
                              outrosDescontos: Double): Double {

        val contribInss = calculoInss(salarioBruto)
        var contribIrrf = calculoIrrf(contribInss)

        salarioLiquidoDTO.salarioLiquido = contribInss!! - contribIrrf -
                valorPlanoDeSaude -
                valorPat -
                outrosDescontos

        return salarioLiquidoDTO.salarioLiquido
    }
}