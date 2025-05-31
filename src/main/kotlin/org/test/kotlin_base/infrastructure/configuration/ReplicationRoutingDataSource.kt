package org.test.kotlin_base.infrastructure.configuration

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource
import org.springframework.transaction.support.TransactionSynchronizationManager

class ReplicationRoutingDataSource : AbstractRoutingDataSource() {
    override fun determineCurrentLookupKey(): Any? {
        return if (TransactionSynchronizationManager.isCurrentTransactionReadOnly()) "read" else "write"
    }
}
