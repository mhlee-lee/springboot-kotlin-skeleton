package org.test.kotlin_base.infrastructure.jpa

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import org.springframework.stereotype.Repository
import org.test.kotlin_base.domain.sample.SampleEntity
import org.test.kotlin_base.domain.sample.SampleRepositoryCustom

@Repository
class SampleRepositoryImpl : QuerydslRepositorySupport(SampleEntity::class.java), SampleRepositoryCustom {
}
