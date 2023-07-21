package com.group.Kotlin.infra.openai

import com.group.Kotlin.infra.openai.dto.ChatCompletionRequest
import com.group.Kotlin.infra.openai.dto.ChatCompletionResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(name = "openai", url = "https://api.openai.com/v1/")
interface ChatGptService {

    @PostMapping("chat/completions")
    fun creatChatCompletion(
            @RequestHeader(HttpHeaders.AUTHORIZATION) authorization: String,
            @RequestBody request: ChatCompletionRequest
    ) : ChatCompletionResponse
}