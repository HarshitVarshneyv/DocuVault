package com.DocuVault.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DocuVault.entity.Document;

public interface DocumentRepository extends JpaRepository<Document ,Long> {

}
