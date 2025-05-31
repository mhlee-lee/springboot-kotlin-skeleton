package org.test.kotlin_base.presentation

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.buildAndAwait
import org.test.kotlin_base.common.TransactionExecutor
import org.test.kotlin_base.common.extensions.toJson
import org.test.kotlin_base.domain.sample.SampleRepository

@Component
class SampleHandler(private val sampleRepository: SampleRepository, private val transactionExecutor: TransactionExecutor) {
    private val log = LoggerFactory.getLogger(this::class.java)

    suspend fun getSample(request: ServerRequest): ServerResponse {
        val value1 = transactionExecutor.execute {
            sampleRepository.findAll()
        }
        val value2 = transactionExecutor.executeReadonly {
            sampleRepository.findAll()
        }

        log.info("value1: ${value1.toJson()}")
        log.info("value2: ${value2.toJson()}")

        return ServerResponse.ok().buildAndAwait()
    }

    suspend fun putSample(request: ServerRequest): ServerResponse {
        return ServerResponse.ok().buildAndAwait()
    }
}
