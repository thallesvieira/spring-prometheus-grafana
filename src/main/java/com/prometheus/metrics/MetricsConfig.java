package com.prometheus.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.Tags;
import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.Counter;
import io.prometheus.client.Gauge;
import io.prometheus.client.Histogram;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.lang.Thread.sleep;

@Configuration
public class MetricsConfig {
    private Counter counter;
    private Gauge gauge;
    private Histogram histogram;
    private Histogram.Timer timer;

    @Autowired
    CollectorRegistry collectorRegistry;

//    @Bean
//    public void counterConfig() {
//        counter = Counter.build()
//                .name("spring_counter_http_requests")
//                .help("Number of HTTP request.")
//                .register(collectorRegistry);
//    }

    @Bean
    public void gaugeConfig() {
        gauge = Gauge.build()
                .name("spring_gauge_online_users")
                .help("Number of online users.")
                .register(collectorRegistry);

        gaugeMetric();
    }

    @Bean
    public void histogramConfig() {
        histogram = Histogram.build()
                .name("spring_histogram_request_duration")
                .help("Time for HTTP request.")
                .register(collectorRegistry);
    }

    public void counterMetric(String tag) {
        Metrics.counter("spring_counter_http_requests", Tags.of("Tag", tag)).increment();
        //counter.inc();
    }

    public void gaugeMetric() {
        loadUsers();
    }

    private void loadUsers() {
        new Thread(() -> {
            while (true) {
                int qtd = (int) ((Math.random() * (2000 - 0)) + 0);
                gauge.set(qtd);

                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void histogramMetricStart() {
        timer = histogram.startTimer();
    }

    public void histogramMetricEnd() {
        timer.observeDuration();
    }
}
