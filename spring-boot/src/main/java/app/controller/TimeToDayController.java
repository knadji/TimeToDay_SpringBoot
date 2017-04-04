package app.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.model.TimeToDay;
import app.service.TimeToDayService;

@RestController
@EnableAutoConfiguration
public class TimeToDayController {

    @Autowired
    private TimeToDayService timeToDayService;

    private static final Logger logger = LoggerFactory.getLogger(TimeToDayController.class);

    @RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> getHome() {

        logger.info("Time to day received");

        Map<String, String> response = new HashMap<String, String>();
        try {
            TimeToDay apiRequest = new TimeToDay(new Date());
            timeToDayService.create(apiRequest);
            response.put("status", "success");
        } catch (Exception e) {
            logger.error("Error occurred while trying to process time to day", e);
            response.put("status", "fail");
        }

        return response;
    }
}
