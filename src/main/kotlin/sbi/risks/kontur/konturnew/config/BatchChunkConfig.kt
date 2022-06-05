package sbi.risks.kontur.konturnew.config

import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import sbi.risks.kontur.konturnew.component.InnDataReader
import sbi.risks.kontur.konturnew.component.InnDataWriter
import sbi.risks.kontur.konturnew.component.InnPageProcessor
import sbi.risks.kontur.konturnew.domain.InnDataPage

@EnableBatchProcessing
@Configuration
class BatchChunkConfig(
    private var stepBuilderFactory: StepBuilderFactory,
    private var jobBuilderFactory: JobBuilderFactory,
    private var innDataReader: InnDataReader,
    private var innDataWriter: InnDataWriter,
    private var InnPageProcessor: InnPageProcessor
) {

    @Bean
    fun jobKontur(): Job? {
        return jobBuilderFactory.get("jobKontur")
            .start(step())
            .build()
    }

    @Bean
    fun step(): Step {
        return stepBuilderFactory.get("step")
            .chunk<String, InnDataPage>(1)
            .reader(innDataReader)
            .processor(InnPageProcessor)
            .writer(innDataWriter)
            .build();
    }
}


