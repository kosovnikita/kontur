package sbi.risks.kontur.konturnew.component

import org.springframework.batch.item.ItemProcessor
import org.springframework.lang.NonNull
import org.springframework.stereotype.Component
import sbi.risks.kontur.konturnew.domain.InnData
import sbi.risks.kontur.konturnew.domain.InnDataPage
import sbi.risks.kontur.konturnew.service.KonturFocusWebService

@Component
class InnPageProcessor(
    private val konturFocusWebService: KonturFocusWebService
) : ItemProcessor<String, InnDataPage>{

    override fun process(@NonNull item: String): InnDataPage? {
        println("[processor]$item")
        var inn = konturFocusWebService.getReq(item).block().toString()
        var innData = InnData(inn)
        var innDataPage = InnDataPage(listOf(innData))
        return innDataPage
    }
}