package com.pm.patientservice.grpc;

import billing.BillingRequest;
import billing.BillingResponse;
import billing.BillingServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BillingServiceGrpcClient {
    private static final Logger log = LoggerFactory.getLogger(BillingServiceGrpcClient.class);
    // This BlockingStub will wait for response before code continuation
    @GrpcClient("billingService")
    private BillingServiceGrpc.BillingServiceBlockingStub blockingStub;

    public BillingResponse createBillingAccount(String patientId, String name, String email) {
        BillingRequest request = BillingRequest
                .newBuilder()
                .setEmail(email)
                .setPatientId(patientId)
                .setName(name)
                .build();

        BillingResponse response = blockingStub.createBillingAccount(request);
        log.info("Received response from billing service via grpc : {}", response);
        return response;
    }
}
