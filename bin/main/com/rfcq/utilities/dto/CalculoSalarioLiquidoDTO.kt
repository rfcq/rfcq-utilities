package com.rfcq.utilities.dto

data class CalculoSalarioLiquidoDTO (
        var salarioBruto: Double = 0.00,
        var numeroDependentes: Int = 0,
        var valorPensaoAlimenticia: Double = 0.00,
        var valorPat: Double = 0.00,
        var valorPlanoDeSaude: Double = 0.00,
        var outrosDescontos: Double = 0.00
)