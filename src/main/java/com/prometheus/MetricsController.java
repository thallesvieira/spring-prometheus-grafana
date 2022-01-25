package com.prometheus;

import com.prometheus.metrics.MetricsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MetricsController {

    @Autowired
    MetricsConfig metricsConfig;

    @GetMapping("/{tag}")
    public String generateMetrics(@PathVariable String tag) {
        metricsConfig.histogramMetricStart();
        metricsConfig.counterMetric(tag);
        metricsConfig.histogramMetricEnd();
        return "Ok";
    }
}
