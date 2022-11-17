package com.rfcq.utilities.dto

import org.springframework.data.annotation.Id
import java.util.UUID


data class UuidDTO(
    @Id
    val uuid: String = UUID.randomUUID().toString()
)

