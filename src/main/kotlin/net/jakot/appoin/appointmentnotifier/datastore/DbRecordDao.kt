package net.jakot.appoin.appointmentnotifier.datastore

import io.awspring.cloud.dynamodb.DynamoDbTemplate
import org.springframework.stereotype.Component
import software.amazon.awssdk.enhanced.dynamodb.model.PageIterable

@Component
class DbRecordDao(val dynamoDbTemplate: DynamoDbTemplate) {

    fun findAll(): PageIterable<DbRecord> {
        return dynamoDbTemplate.scanAll(DbRecord::class.java)
    }

}
