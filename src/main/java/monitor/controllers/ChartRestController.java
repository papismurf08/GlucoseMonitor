package monitor.controllers;

import monitor.models.Chart;
import monitor.services.ChartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/chart")
public class ChartRestController {

    @Autowired
    private ChartService chartService;

    @RequestMapping(value = "findall", method = RequestMethod.GET, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
    public ResponseEntity<Iterable<Chart>> findAll() {
        try {
            return new ResponseEntity<Iterable<Chart>>(chartService.findAll(), HttpStatus.OK );
        } catch (Exception e) {
            return new ResponseEntity<Iterable<Chart>>(HttpStatus.BAD_REQUEST);
        }
    }

}