package net.jakot.appoin.appointmentnotifier.datastore;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@DynamoDbBean
public class DbRecord {

	private String id;
	private String  chatId;
	private String  doctorId;
	private String String;
	private String expiration;

	public DbRecord(final java.lang.String id, final java.lang.String chatId, final java.lang.String doctorId, final java.lang.String string,
			final String expiration) {
		this.id = id;
		this.chatId = chatId;
		this.doctorId = doctorId;
		String = string;
		this.expiration = expiration;
	}

	public DbRecord() {
	}

	@DynamoDbPartitionKey
	public String getId() {
		return id;
	}

	public java.lang.String getChatId() {
		return chatId;
	}

	public java.lang.String getDoctorId() {
		return doctorId;
	}

	public java.lang.String getString() {
		return String;
	}

	public String getExpiration() {
		return expiration;
	}

	public void setId(final java.lang.String id) {
		this.id = id;
	}

	public void setChatId(final java.lang.String chatId) {
		this.chatId = chatId;
	}

	public void setDoctorId(final java.lang.String doctorId) {
		this.doctorId = doctorId;
	}

	public void setString(final java.lang.String string) {
		String = string;
	}

	public void setExpiration(final String expiration) {
		this.expiration = expiration;
	}

}
