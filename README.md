# Women's World Cup 2023: A Koltin RESTful API

Este é um projeto que visa fornecer informações sobre a Copa do Mundo de Futebol Feminino de 2023. O projeto inclui uma API em Kotlin que permite o acesso aos dados das seleções participantes e integração com o ChatGPT-4 para simular as partidas da Copa e prever os resultados dos jogos.

<p align="center">
     <a alt="Java">
        <img src="https://img.shields.io/badge/Java-v17-blue.svg" />
    </a>
     <a alt="Kotlin">
        <img src="https://img.shields.io/badge/Kotlin-v1.8.22-purple.svg" />
    </a>
    <a alt="Spring Boot">
        <img src="https://img.shields.io/badge/Spring%20Boot-v3.1.1-brightgreen.svg" />
    </a>
    <a alt="Spring Cloud">
        <img src="https://img.shields.io/badge/Spring%20Cloud-v4.0.3-brightgreen.svg" />
    </a>
    <a alt="Gradle">
        <img src="https://img.shields.io/badge/Gradle-v7.6-lightgreen.svg" />
    </a>
    <a alt="H2">
        <img src="https://img.shields.io/badge/H2-v2.1.214-darkblue.svg" />
    </a>
</p>


Seguem alguns links úteis:

1. [Endpoint de Chat Completion](https://platform.openai.com/docs/api-reference/chat/create) (que vamos consumir)
2. [Collection Postman da OpenAI](https://www.postman.com/devrel/workspace/openai/documentation/13183464-90abb798-cb85-43cb-ba3a-ae7941e968da) (útil pra entender todas as APIs da OpenAI)

> Request

```
curl https://api.openai.com/v1/chat/completions \
 -H "Authorization: Bearer $OPENAI_API_KEY" \
 -H "Content-Type: application/json" \
 -d '{
 "model": "gpt-3.5-turbo",
 "messages": [
    {"role": "user", "content": "What is the OpenAI mission?"}] 
 }'
```

> Response

```json
{
  "id": "chatcmpl-6p5FEv1JHictSSnDZsGU4KvbuBsbu",
  "object": "messages",
  "created": 1677693600,
  "model": "gpt-3.5-turbo",
  "choices": [
    {
      "index": 0,
      "finish_reason": "stop",
      "message": {
        "role": "assistant",
        "content": "OpenAI's mission is to ensure that AI benefits all of humanity."
      }
    }
  ],
  "usage": {
    "prompt_tokens": 20,
    "completion_tokens": 18,
    "total_tokens": 38
  }
}
```
---

## Uso da API

> Request

### Simular partida entre dois times:

- Método: `GET`
- Endpoint: `/simulate/{timeDeCasa}/{timeDeFora}`

Parâmetros de caminho:
- `{timeDeCasa}`: ID da primeira equipe.
- `{timeDeFora}`: ID da segunda equipe.

- Exemplo de solicitação:

```http
GET /simulate/ARG/BRA
```

> Response

- Código de resposta: `200 OK`
- Corpo da resposta: `TeamDto` contendo os dados da equipe vencedora.

Exemplo de resposta:

```json
{
  "id": "ARG",
  "name": "Argentina",
  "score": 1682.45
}
```

#### Códigos de resposta possíveis:

- `200 OK`: A simulação foi concluída com sucesso e a equipe vencedora é retornada.
- `422 Unprocessable Entity`: Uma ou ambas as equipes não foram encontradas na Copa do Mundo Feminina.

## Documentação do Swagger

A documentação da API pode ser encontrada no Swagger. Para visualizá-la,
acesse: [Documentação do Swagger](http://localhost:8080/swagger-ui/index.html#/).

