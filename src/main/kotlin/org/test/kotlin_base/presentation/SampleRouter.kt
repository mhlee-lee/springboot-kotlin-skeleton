package org.test.kotlin_base.presentation

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class SampleRouter(private val sampleHandler: SampleHandler) {
    @Bean
    fun coRouteBrands(): RouterFunction<ServerResponse> {
        return coRouter {
            (accept(MediaType.APPLICATION_JSON) and "/sample/v1.0").nest {
                GET("sample", sampleHandler::getSample)
                PUT("sample", sampleHandler::putSample)
            }
        }
    }
}
