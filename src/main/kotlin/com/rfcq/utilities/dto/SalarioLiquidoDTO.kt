package com.rfcq.utilities.dto

data class SalarioLiquidoDTO(
        var aliquotaInss: Double = 0.00,
        var aliquotaIrrf: Double = 0.00,
        var calculoBase: Double = 0.00,
        var faixaSalarialInss: String = "",
        var faixaSalarialIrrf: String  = "",
        var deducaoIrrf: Double = 0.00,
        var calculoIrrf: Double = 0.00,
        var salarioLiquido: Double = 0.00
)
