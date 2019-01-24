# WSO2 API Microgateway Performance Test Results

During each release, we execute various automated performance test scenarios and publish the results.

| Test Scenarios | Description |
| --- | --- |
| Microgateway-Passthrough-OAuth2 | A secured API, which directly invokes the backend through Microgateway using OAuth2 tokens |
| Microgateway-Passthrough-JWT | A secured API, which directly invokes the backend through Microgateway using JWT tokens |

Our test client is [Apache JMeter](https://jmeter.apache.org/index.html). We test each scenario for a fixed duration of
time. We split the test results into warmup and measurement parts and use the measurement part to compute the
performance metrics.

Test scenarios use a [Netty](https://netty.io/) based back-end service which echoes back any request
posted to it after a specified period of time.

We run the performance tests under different numbers of concurrent users, message sizes (payloads) and back-end service
delays.

The main performance metrics:

1. **Throughput**: The number of requests that the WSO2 API Microgateway processes during a specific time interval (e.g. per second).
2. **Response Time**: The end-to-end latency for an operation of invoking an API. The complete distribution of response times was recorded.

In addition to the above metrics, we measure the load average and several memory-related metrics.

The following are the test parameters.

| Test Parameter | Description | Values |
| --- | --- | --- |
| Scenario Name | The name of the test scenario. | Refer to the above table. |
| Heap Size | The amount of memory allocated to the application | 1G |
| Concurrent Users | The number of users accessing the application at the same time. | 100, 200 |
| Message Size (Bytes) | The request payload size in Bytes. | 50, 1024 |
| Back-end Delay (ms) | The delay added by the back-end service. | 0 |

The duration of each test is **240 seconds**. The warm-up period is **60 seconds**.
The measurement results are collected after the warm-up period.

A [**c5.large** Amazon EC2 instance](https://aws.amazon.com/ec2/instance-types/) was used to install WSO2 API Microgateway.

The following are the measurements collected from each performance test conducted for a given combination of
test parameters.

| Measurement | Description |
| --- | --- |
| Error % | Percentage of requests with errors |
| Average Response Time (ms) | The average response time of a set of results |
| Standard Deviation of Response Time (ms) | The “Standard Deviation” of the response time. |
| 99th Percentile of Response Time (ms) | 99% of the requests took no more than this time. The remaining samples took at least as long as this |
| Throughput (Requests/sec) | The throughput measured in requests per second. |
| Average Memory Footprint After Full GC (M) | The average memory consumed by the application after a full garbage collection event. |

The following is the summary of performance test results collected for the measurement period.

|  Scenario Name | Heap Size | Concurrent Users | Message Size (Bytes) | Back-end Service Delay (ms) | Error % | Throughput (Requests/sec) | Average Response Time (ms) | Standard Deviation of Response Time (ms) | 99th Percentile of Response Time (ms) | WSO2 API Microgateway GC Throughput (%) | Average WSO2 API Microgateway Memory Footprint After Full GC (M) |
|---|---:|---:|---:|---:|---:|---:|---:|---:|---:|---:|---:|
|  Microgateway-Passthrough-JWT | 1G | 100 | 50 | 0 | 0 | 1309.82 | 76.26 | 45.99 | 228 | 95.26 | 65.475 |
|  Microgateway-Passthrough-JWT | 1G | 100 | 1024 | 0 | 0 | 1274.53 | 78.38 | 44.46 | 231 | 95.66 | 35.833 |
|  Microgateway-Passthrough-JWT | 1G | 200 | 50 | 0 | 0 | 1320.2 | 151.34 | 72.89 | 383 | 92.81 | 76.272 |
|  Microgateway-Passthrough-JWT | 1G | 200 | 1024 | 0 | 0 | 1229.61 | 162.45 | 72.21 | 393 | 93.4 | 53.199 |
|  Microgateway-Passthrough-OAuth2 | 1G | 100 | 50 | 0 | 0 | 366.42 | 272.71 | 130.39 | 731 | 94.6 | 19.418 |
|  Microgateway-Passthrough-OAuth2 | 1G | 100 | 1024 | 0 | 3.93 | 33.84 | 2949.93 | 12431.81 | 62207 | 98.84 | 19.468 |
|  Microgateway-Passthrough-OAuth2 | 1G | 200 | 50 | 0 | 2.2 | 92.85 | 1698.96 | 8182.41 | 61951 | 96.59 | 46.69 |
|  Microgateway-Passthrough-OAuth2 | 1G | 200 | 1024 | 0 | 1.24 | 151.94 | 1312.75 | 6778.56 | 60159 | 96.28 | 51.127 |
