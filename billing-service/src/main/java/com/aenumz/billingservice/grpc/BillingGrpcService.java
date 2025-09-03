package com.aenumz.billingservice.grpc;

import billing.BillingRequest;
import billing.BillingResponse;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import billing.BillingServiceGrpc.BillingServiceImplBase;
@Slf4j
@GrpcService
public class BillingGrpcService extends BillingServiceImplBase {
    @Override
    public void createBillingAccount(BillingRequest billingRequest, StreamObserver<BillingResponse> responseObserver) {
        /*
        * StreamObserver is used to send the response back to the client
        * also helps us to send multiple responses back to the client at the same time
        * */

        log.info("CreateBillingAccount request received: {}", billingRequest.toString());

        // Business Logic -> e.g. save to database, perform calculations, etc.
        BillingResponse billingResponse = BillingResponse.newBuilder()
                .setAccountId("12345")
                .setStatus("ACTIVE")
                .build();

        responseObserver.onNext(billingResponse);
        responseObserver.onCompleted();
    }
}
