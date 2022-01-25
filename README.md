# spring-prometheus-grafana

For correct operation it is necessary to make the some steps:

1- Run the command docker-compose up -d --build in the terminal: 

![image](https://user-images.githubusercontent.com/31675029/151067997-976ea7b0-a314-48a0-82ee-6fbb86f96d86.png)


2- Run the API: 

![image](https://user-images.githubusercontent.com/31675029/151068240-24896664-57eb-413c-b0ee-edec69b01d96.png)


Now, the containers are up. Prometheus is in localhost:9090 and grafana in localhost:3000.
Can be configured to monitor the metrics.


# Configuring prometheus in the grafana

1- Access localhost:3000 and use user: admin, password: admin

2- Click in Configuration -> Data Sources:
![image](https://user-images.githubusercontent.com/31675029/151069208-d00c14a0-0ca4-47aa-834a-cb849f467da9.png)

3- Select the "Prometheus" data source

4- Now, to configure Promteheus is necessary add URL = http://prometheus:9090 and to click in Save & Test:
![image](https://user-images.githubusercontent.com/31675029/151070835-eb711536-184d-4391-8af0-eb9767ee1f6a.png)

# Configuring metrics

1- First, lets generate some metrics, so access http://localhost:8000/{name-of-tag} how many times you want:
![image](https://user-images.githubusercontent.com/31675029/151071183-4d46c298-d765-4c0b-a56a-95848724c4b8.png)

2- Counter metric.
In Grafana add a new panel, select the type of visualization "Stat" and add the metric "spring_counter_http_request_total" in the fiel metrics browser, 
click in Apply, ready! The counter metric is configured:
![image](https://user-images.githubusercontent.com/31675029/151071632-15e969db-02b3-4f60-8e93-82c0fa73f351.png)

3- Gauge metric.
Add a new panel, select type of visualization "Gauge" and add the metric "spring_gauge_online_users", 
click in Apply, ready! The gauge metric is configured (important, this metric is generate with random value in api):
![image](https://user-images.githubusercontent.com/31675029/151072102-74c00607-f316-409f-9c4b-af80bf9f99d9.png)

4- Histogram metric.
Add a new panel, select type of visualization "Graph" or other of your preference and add the metric "spring_histogram_request_durantion_count", 
click in Apply, ready! The histogram metric is configured:
![image](https://user-images.githubusercontent.com/31675029/151072569-5c181dae-c46c-4a2a-9f32-7284eb262e2e.png)

5- Ready, the metrics are set and we can access localhost:7000/nomeoftag to see the values changes in grafana:
![image](https://user-images.githubusercontent.com/31675029/151072918-e784fc67-ce61-44bd-8110-90e21a4bd3a4.png)





