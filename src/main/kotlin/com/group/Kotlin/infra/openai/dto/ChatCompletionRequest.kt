package com.group.Kotlin.infra.openai.dto

data class ChatCompletionRequest( val model: String,
                                  val messages: List<Message>)
