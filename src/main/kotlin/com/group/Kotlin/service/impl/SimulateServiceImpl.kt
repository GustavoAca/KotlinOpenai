package com.group.Kotlin.service.impl

import com.group.Kotlin.domain.model.Team
import com.group.Kotlin.infra.openai.ChatGptService
import com.group.Kotlin.infra.openai.dto.ChatCompletionRequest
import com.group.Kotlin.infra.openai.dto.Message
import com.group.Kotlin.service.SimulateService
import com.group.Kotlin.service.TeamService
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class SimulateServiceImpl(
        private val teamService: TeamService,
        private val chatGptService: ChatGptService,
        @Value("\${openai.api-key}")
        private val openAiApiKey: String,
) : SimulateService {

    val WOMEM_WORLD_CUP_2023_TEAMS = teamService.findAll();

    override fun simulate(timeDeCasa: String, timeDeFora: String): Team {
        val team1 = teamService.findById(timeDeCasa)
        val team2 = teamService.findById(timeDeFora)

        val trainingData = WOMEM_WORLD_CUP_2023_TEAMS.joinToString("\n") { "${it.id} (${it.score})" }

        try {
            val authorization = "Bearer $openAiApiKey"
            val request = ChatCompletionRequest("gpt-3.5-turbo", messages = listOf(
                    Message("system",
                            """
                            Atue como um modelo de analise estatistica para simulação de partidas de futebol feminino
                            Considere os seguintes dados de treinamento,no formato {SIGLA_SELECAO} ({PONTOS_RANKING_FIFA}):
                            $trainingData
                        """.trimIndent()),
                    Message("user", "Simule a partida entre ${team1.id} vs ${team2.id}. Me envie como resposta apenas a sigla da seleção vencedora")

            ))

            val response = chatGptService.creatChatCompletion(authorization, request)
            return if (response.choices.first().message.content == team1.id) team1 else team2
        } catch (e: NumberFormatException) {
            println("Possivelmente se chegou aqui é porque acabou a avaliacao da OpenAi")
            return if (team1.score >= team2.score) team1 else team2
        }
    }

}