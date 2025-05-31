package org.test.kotlin_base.domain.sample

import org.springframework.data.jpa.repository.JpaRepository
import org.test.kotlin_base.domain.sample.SampleRepositoryCustom

interface SampleRepository : JpaRepository<SampleEntity, Long>, SampleRepositoryCustom {
}
