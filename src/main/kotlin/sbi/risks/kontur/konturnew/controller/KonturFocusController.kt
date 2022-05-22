package sbi.risks.kontur.konturnew.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import sbi.risks.kontur.konturnew.service.KonturFocusWebService


@RestController
@RequestMapping("update")
class KonturFocusController {

    @GetMapping
    fun update() : ResponseEntity<Any> {

        val kontur =  KonturFocusWebService()
        val result  = kontur.getInn("7708503727")
        println(result.block())
        return ResponseEntity.ok("ok")
    }
}