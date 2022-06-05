package sbi.risks.kontur.konturnew

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableBatchProcessing
class KonturNewApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<KonturNewApplication>(*args)
        }
    }
}

