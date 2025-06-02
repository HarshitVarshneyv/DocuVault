package com.DocuVault.service;

import java.util.List;

import com.DocuVault.entity.Document;
import com.DocuVault.entity.User;

public interface DocuVaultService {

	User signup(User user);
	Document uploadDocument(Document document);
	List<Document> getAllDocuments( );
	Document documentdetails(Long documentid);
	void deleteDocument(Long documentid);
	List<Document> userAllDocuments(Long userId);

}
