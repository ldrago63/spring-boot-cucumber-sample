package com.ldrago.sample.cucumbersample.cucumber.clients.configuration;

import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientsConfiguration {

    @Bean
    public Decoder decoder(ObjectFactory<HttpMessageConverters> messageConverters) {
        return new Interceptors(new SpringDecoder(messageConverters));
    }

}
