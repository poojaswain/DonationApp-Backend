package com.pooja.donation.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pooja.donation.entities.FileDB;
import com.pooja.donation.payloads.FileResponseDto;
import com.pooja.donation.payloads.ResponseDTO;
import com.pooja.donation.payloads.ResponseMessageDto;
import com.pooja.donation.services.impl.FileStorageService;

@RestController
@RequestMapping("/api")
public class FileController {

	@Autowired
	private FileStorageService storageService;

	@PostMapping("/upload")
	public ResponseEntity<ResponseDTO> uploadFile(@RequestParam("file") MultipartFile file) {
		ResponseDTO response = new ResponseDTO();
		String message = "";
		try {
			FileDB storedFile = storageService.store(file);
			storedFile.setData(null);
			message = "Uploaded the file successfully: " + file.getOriginalFilename();

			response.setResponseObject(storedFile);
			response.setMessage(message);
			response.setHttpStatus(HttpStatus.OK);

		} catch (Exception e) {
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";

			response.setMessage(message);
			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);

		}
		return new ResponseEntity<>(response, response.getHttpStatus());
	}

	@GetMapping("/files")
	public ResponseEntity<List<FileResponseDto>> getListFiles() {
		List<FileResponseDto> files = storageService.getAllFiles().map(dbFile -> {
			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/files/")
					.path(dbFile.getId()).toUriString();

			return new FileResponseDto(dbFile.getName(), fileDownloadUri, dbFile.getType(), dbFile.getData().length);
		}).collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.OK).body(files);
	}

	@GetMapping("/files/{id}")
	public ResponseEntity<byte[]> getFile(@PathVariable String id) {
		FileDB fileDB = storageService.getFile(id);

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
				.body(fileDB.getData());
	}

	@GetMapping("/hi/hello")
	public String hello() {
		return "Hello, World!";
	}
}
