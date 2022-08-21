package net.codejava.aws;

import java.io.InputStream;

import software.amazon.awssdk.core.exception.AbortedException;
import software.amazon.awssdk.core.exception.SdkClientException;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.core.waiters.WaiterResponse;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.HeadObjectRequest;
import software.amazon.awssdk.services.s3.model.HeadObjectResponse;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;
import software.amazon.awssdk.services.s3.waiters.S3Waiter;


public class S3Util {

	
	    private static final String BUCKET = "ojapp";

	    public static void uploadFile(String fileName, InputStream inputStream)
	        throws S3Exception, AbortedException, SdkClientException, Exception {
	        S3Client client = S3Client.builder().build();

            S3Waiter s3Waiter = client.waiter();

	        PutObjectRequest request = PutObjectRequest.builder()
	                                              .bucket(BUCKET)
	                                              .key(fileName)
	                                              .build();
	        
	        
	        
	        client.putObject(request, RequestBody.fromInputStream(inputStream, inputStream.available()));
	        
	        HeadObjectRequest waitRequest = HeadObjectRequest.builder()
	                                                .bucket(BUCKET)
	                                                .key(fileName)
	                                                .build();
	        WaiterResponse<HeadObjectResponse> waitResponce = s3Waiter.waitUntilObjectExists(waitRequest);
	       
	        waitResponce.matched().response().ifPresent(x -> {
	            System.out.println("The file " + fileName + "is now ready.");
	        });
	    }
	}



