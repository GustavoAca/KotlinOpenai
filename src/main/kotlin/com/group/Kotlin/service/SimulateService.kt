package com.group.Kotlin.service

import com.group.Kotlin.domain.model.Team

interface SimulateService {
    fun simulate(timeDeCasa: String, timeDeFora: String): Team
}