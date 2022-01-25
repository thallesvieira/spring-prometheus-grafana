package com.prometheus;

import com.prometheus.metrics.MetricsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({MetricsConfig.class})
public class main {
	public static void main(String[] args) {
		SpringApplication.run(main.class, args);
	}
}
