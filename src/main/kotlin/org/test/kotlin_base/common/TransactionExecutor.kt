package org.test.kotlin_base.common

import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class TransactionExecutor {
    @Transactional
    fun <T> execute(block: () -> T): T {
        return block()
    }

    @Transactional(readOnly = true)
    fun <T> executeReadonly(block: () -> T): T {
        return block()
    }
}
