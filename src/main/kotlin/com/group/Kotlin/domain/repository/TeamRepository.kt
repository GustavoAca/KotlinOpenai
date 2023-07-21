package com.group.Kotlin.domain.repository

import com.group.Kotlin.domain.model.Team
import org.springframework.data.jpa.repository.JpaRepository

interface TeamRepository : JpaRepository<Team, String> {
}