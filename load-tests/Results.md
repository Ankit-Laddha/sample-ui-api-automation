## Load test Details

#### Configuration

```text
Website under test: https://developer.yahoo.com
Tool Used: JMeter (https://jmeter.apache.org/)
Endpoint under test: / (root page)
Http verb: GET
No. of users/threads simulated: 1000
Ramp-Up Interval : 15 seconds 
```
    
#### Summary: 
 
 a) Explain the test in details
    
   See `load_test_report.png` file
    
   ```text
    Minimal response time (ms): 664
    Maximum response time (ms): 29108
    Error rate: 
        percentage of failed tests: 2.6 
        All failing request returned 502 - Bad Gateway
        Response message:Server Hangup
    Throughput - how many requests per second does the server handle : 26.7
    
```
  

b) Did the load test have an impact on web application response time?

   ```text
    Yes. Due to large no of users requests within certain time period, Server failed for 2.6% requests. 
    Also, there was spike in servers avg response time.
    Fast: 426ms
    Avg: 6365ms
    Slow: 19234ms
```    
    
c) What is the optimal application response time for modern day web applications
  
  ```text
   Ideally most web application should respond within few seconds. Maximum is 3 seconds. 
   Anything greater than 3 seconds will drive your user's attention away.
```

d) Analyze few HTTP/S responses
  ```text
   As mentioned for failing requests, server started returning 502 with Server hangup response message.
   Due to large load, website started throwing the error for random requests
```
