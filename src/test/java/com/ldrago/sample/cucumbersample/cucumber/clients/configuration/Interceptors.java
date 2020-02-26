package com.ldrago.sample.cucumbersample.cucumber.clients.configuration;

import feign.FeignException;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import feign.codec.ErrorDecoder;

import java.io.IOException;
import java.lang.reflect.Type;

public class Interceptors implements Decoder, ErrorDecoder {

    private Decoder delegate;

    private int httpCode;

    public Interceptors(Decoder delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
        httpCode = response.status();
        return delegate.decode(response, type);
    }


    @Override
    public Exception decode(String s, Response response) {
        httpCode = response.status();
        throw new FeignTestException("Feign client status is : " + httpCode);
    }

    public int getHttpCode() {
        return httpCode;
    }
}
