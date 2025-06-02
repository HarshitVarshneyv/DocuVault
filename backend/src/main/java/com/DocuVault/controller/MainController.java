package com.DocuVault.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DocuVault.entity.Document;
import com.DocuVault.entity.User;
import com.DocuVault.service.DocuVaultService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequestMapping("/api/backend")
@RequiredArgsConstructor
public class MainController {

	private final DocuVaultService docuVaultService;
	
	@PostMapping("/signup")
	public ResponseEntity<String> signup(@RequestBody User user){
		docuVaultService.signup(user);
		return ResponseEntity.status(HttpStatus.CREATED).body("Successfully created new user");
	}
	
	@PostMapping("/documents")
	public ResponseEntity<String> uploadDocument(@RequestBody Document document){
		docuVaultService.uploadDocument(document);
		return ResponseEntity.status(HttpStatus.CREATED).body("Successfully uploaded new document");
	}
	
	
	@GetMapping("/documents}")
	public ResponseEntity<List<Document>> getAllDocuments(){
		return ResponseEntity.ok(docuVaultService.getAllDocuments());
	}
	
	@GetMapping("/documents/{id}")
	public ResponseEntity<Document> documentDetails(@PathVariable Long documentid){
		return ResponseEntity.ok(docuVaultService.documentdetails(documentid));
	}
	
	@DeleteMapping("/documents/{id}")
	public ResponseEntity<String> deleteDocument(@PathVariable Long documentid){
		docuVaultService.deleteDocument(documentid);
		return ResponseEntity.ok("Document deleted successfully");
	}
	
	@GetMapping("/documents/user/{userId}")
	public ResponseEntity<List<Document>> userAllDocuments(@PathVariable Long userId){
		return ResponseEntity.ok(docuVaultService.userAllDocuments(userId));
	}
}





