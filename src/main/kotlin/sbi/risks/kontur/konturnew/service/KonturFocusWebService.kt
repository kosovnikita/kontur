package sbi.risks.kontur.konturnew.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import reactor.core.publisher.Mono


@Service
class KonturFocusWebService(
    @param:Value("\${kontur.key}")
    private val key: String,
    @param:Value("\${kontur.url}")
    private val url: String,
    @param:Value("\${kontur.methods.req}")
    private val req: String,
    @param:Value("\${kontur.methods.petitionersOfArbitration}")
    private val petitionersOfArbitration: String,
    @param:Value("\${kontur.methods.excerpt}")
    private val excerpt: String,
    @param:Value("\${kontur.methods.finan}")
    private val finan: String,
    @param:Value("\${kontur.methods.govPurchasesOfCustomer}")
    private val govPurchasesOfCustomer: String
) {
    //(Базовые реквизиты)
    fun getReq(inn: String): Mono<Any> {
        val webClient = WebClient.create(url)
        return webClient.get()
            .uri("api3/$req?key=$key&inn=$inn")
            .retrieve().bodyToMono()
    }
    //(Статистика по истцам в арбитраже)
    fun getPetitionersOfArbitration(inn: String): Mono<Any> {
        val webClient = WebClient.create(url)
        return webClient.get()
            .uri("api3/$petitionersOfArbitration?key=$key&inn=$inn")
            .retrieve().bodyToMono()
    }
    //(Выписка из ЕГРЮЛ/ЕГРИП)
    fun getExcerpt(inn: String): Mono<Any> {
        val webClient = WebClient.create(url)
        return webClient.get()
            .uri("api3/$excerpt?key=$key&inn=$inn")
            .retrieve().bodyToMono()
    }
    //(Финансовый анализ)
    fun getFinan(inn: String): Mono<Any> {
        val webClient = WebClient.create(url)
        return webClient.get()
            .uri("api3/$finan?key=$key&inn=$inn")
            .retrieve().bodyToMono()
    }
    //(Госзакупки заказчика)
    fun getGovPurchasesOfCustomer(inn: String): Mono<Any> {
        val webClient = WebClient.create(url)
        return webClient.get()
            .uri("api3/$govPurchasesOfCustomer?key=$key&inn=$inn")
            .retrieve().bodyToMono()
    }
}