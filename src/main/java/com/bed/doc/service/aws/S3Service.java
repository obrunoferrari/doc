package com.bed.doc.service.aws;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Service
public class S3Service {
	
	private final S3Client s3Client;
	
	@Value("${aws.s3.bucket-name}")
	private String bucketName;
	
	@Value("${aws.s3.region}")
	private String region;
	
	public S3Service(S3Client s3Client) {
		this.s3Client = s3Client;
	}
	
	public String uploadFile(MultipartFile file) throws IOException {
		String fileName = generateFileName(file.getOriginalFilename());
		
		PutObjectRequest putObjectRequest = PutObjectRequest.builder()
				.bucket(bucketName)
				.key(fileName)
				.contentType(file.getContentType())
				.build();
		
		s3Client.putObject(putObjectRequest, RequestBody.fromBytes(file.getBytes()));
		
		return generateFileUrl(fileName);
	}
	
	public void deleteFile(String fileUrl) {
		String fileName = extractFileNameFromUrl(fileUrl);
		
		DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest.builder()
				.bucket(bucketName)
				.key(fileName)
				.build();
		
		s3Client.deleteObject(deleteObjectRequest);
	}
	
	private String generateFileName(String originalFileName) {
		String extension = "";
		if (originalFileName != null && originalFileName.contains(".")) {
			extension = originalFileName.substring(originalFileName.lastIndexOf("."));
		}
		return "media/" + UUID.randomUUID().toString() + extension;
	}
	
	private String generateFileUrl(String fileName) {
		return String.format("https://%s.s3.%s.amazonaws.com/%s", bucketName, region, fileName);
	}
	
	private String extractFileNameFromUrl(String fileUrl) {
		return fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
	}
	
}