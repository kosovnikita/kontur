package sbi.risks.kontur.konturnew.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import org.springframework.web.reactive.function.client.toEntity
import reactor.core.publisher.Mono


@Service
class KonturFocusWebService {

    @Value("\${kontur.url}")
    private val url: String? = null

    @Value("\${kontur.key}")
    private val key: String? = null


    fun getInn(inn: String): Mono<Any> {

        val url1 = "https://focus-api.kontur.ru/"
        val key1 = "3208d29d15c507395db770d0e65f3711e40374df"
        val webClient = WebClient.create(url1)

        return webClient.get()
            .uri("api3/req?key=$key1&inn=$inn")
            .retrieve().bodyToMono()
    }


}