package sbi.risks.kontur.konturnew.component

import org.springframework.batch.item.ItemReader
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import sbi.risks.kontur.konturnew.domain.InnDataPage
import sbi.risks.kontur.konturnew.service.InnCollection

/**
 * Created by masahiro on 2016/08/07.
 */
@Component
class InnDataReader(
    private var innCollection: InnCollection
) : ItemReader<String> {

    private var count = 1

    override fun read(): String? {

        count++
        return innCollection.items()[count]
        //return null
    }
}