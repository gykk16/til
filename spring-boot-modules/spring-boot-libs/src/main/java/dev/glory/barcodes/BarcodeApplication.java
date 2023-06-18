package dev.glory.barcodes;

import java.awt.image.BufferedImage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;

/**
 * <a href="https://www.baeldung.com/java-generating-barcodes-qr-codes">Generating Barcodes and QR Codes in Java</a>
 */
@SpringBootApplication
public class BarcodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BarcodeApplication.class, args);
    }

    // manually register a message converter for BufferedImage HTTP Responses because there is no default
    @Bean
    public HttpMessageConverter<BufferedImage> createImageHttpMessageConverter() {
        return new BufferedImageHttpMessageConverter();
    }
}
