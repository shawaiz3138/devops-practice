package com.practice.demo;
import java.time.Instant;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class StatusController {
 @GetMapping("/")
 public Map<String,Object> home() {
  return Map.of("application","OpenShift Spring Boot Practice","message","Hello from my updated Spring Boot application!","status","UP","timestamp",Instant.now().toString());
 }
 @GetMapping("/health")
 public Map<String,String> health() { return Map.of("status","UP"); }
}
