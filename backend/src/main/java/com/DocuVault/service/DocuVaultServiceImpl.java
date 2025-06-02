package com.DocuVault.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.DocuVault.entity.Document;
import com.DocuVault.entity.User;
import com.DocuVault.exception.DocumentNotFindException;
import com.DocuVault.exception.EmailAlreadyExistsException;
import com.DocuVault.exception.UserNotExistsException;
import com.DocuVault.repository.DocumentRepository;
import com.DocuVault.repository.UserRepository;

@Service
public class DocuVaultServiceImpl implements DocuVaultService{

	private final UserRepository userRepository;
	private final DocumentRepository documentRepository;
	
	public DocuVaultServiceImpl(UserRepository userRepository , DocumentRepository documentRepository) {
		this.userRepository = userRepository;
		this.documentRepository = documentRepository;
	}

	@Override
	public User signup(User user) {
		// TODO Auto-generated method stub
		if(userRepository.existsByEmail(user.getEmail())) {
			throw new EmailAlreadyExistsException("Duplicate Email Please Login");
		}
		return userRepository.save(user);
	}

	@Override
	public Document uploadDocument(Document document) {
		// TODO Auto-generated method stub
		return documentRepository.save(document);
	}

	@Override
	public List<Document> getAllDocuments( ) {
		// TODO Auto-generated method stub
		return documentRepository.findAll();
		
	}

	@Override
	public Document documentdetails(Long documentid) {
		// TODO Auto-generated method stub
		Document document = documentRepository.findById(documentid)
				.orElseThrow(() -> new DocumentNotFindException("This document does not exits"));
		return document;
	}

	@Override
	public void deleteDocument(Long documentid) {
		// TODO Auto-generated method stub 
//		Document document = documentRepository.findById(documentid)
//				.orElseThrow(() -> new DocumentNotFindException("This document does not exits"));
//		documentRepository.delete(document);
		
		documentRepository.findById(documentid)
		.ifPresentOrElse(
				doc -> documentRepository.delete(doc),
				() -> { throw new DocumentNotFindException("This document does not exist"); } );
	}

	@Override
	public List<Document> userAllDocuments(Long userId) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new UserNotExistsException("User not Exist"));
		return user.getDocument();
	}
}








