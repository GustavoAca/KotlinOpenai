package com.group.Kotlin.service.impl

import com.group.Kotlin.domain.model.Team
import com.group.Kotlin.domain.repository.TeamRepository
import com.group.Kotlin.service.TeamService
import org.springframework.stereotype.Service

@Service
class TeamServiceImpl(private val teamRepository: TeamRepository) : TeamService{
    override fun findAll(): List<Team> {
        TODO("Not yet implemented")
    }

    override fun findById(id: String): Team {
        TODO("Not yet implemented")
    }

    override fun create(model: Team): Team {
        TODO("Not yet implemented")
    }

    override fun update(id: String, model: Team): Team {
        TODO("Not yet implemented")
    }

    override fun delete(id: String) {
        TODO("Not yet implemented")
    }
}