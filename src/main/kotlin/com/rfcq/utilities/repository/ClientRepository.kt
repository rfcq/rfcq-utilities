package com.rfcq.utilities.repository

import com.rfcq.utilities.dto.ClientDTO
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClientRepository : JpaRepository<ClientDTO, Long>{

}