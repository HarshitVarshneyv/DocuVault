package com.DocuVault.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Document {

	private Long id;
	private String name;             // "Passport", "Marksheet"
	private String type;             // PDF, DOCX, etc.
	private String category;         // e.g., Education, Finance, Identity
	private String tags;             // comma-separated or list (e.g., ["govt", "official"])
	private LocalDate uploadDate;
	private String downloadUrl;      // (Simulated path or actual AWS S3 link if extended)
	
	@ManyToOne
	@JoinColumn(name = "user_id" , nullable = false )
	private User user;

}
