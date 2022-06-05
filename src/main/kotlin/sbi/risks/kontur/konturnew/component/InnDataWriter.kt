package sbi.risks.kontur.konturnew.component

import org.springframework.batch.item.ItemWriter
import org.springframework.stereotype.Component
import sbi.risks.kontur.konturnew.domain.InnDataPage

/**
 * Created by masahiro on 2016/08/07.
 */
@Component
class InnDataWriter : ItemWriter<InnDataPage> {
    override fun write(items: MutableList<out InnDataPage>) {
        println("[writer]${items}")
    }
}