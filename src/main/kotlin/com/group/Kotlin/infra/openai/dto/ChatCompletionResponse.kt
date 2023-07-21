package com.group.Kotlin.infra.openai.dto

data class ChatCompletionResponse(val model: String,
        val choices: List<Choice>
)
