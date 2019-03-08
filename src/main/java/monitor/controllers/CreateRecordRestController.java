package monitor.controllers;

import monitor.models.CreateRecord;
import monitor.services.CreateRecordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/chart")
public class CreateRecordRestController {

    @Autowired
    private CreateRecordService createRecordService;

    @RequestMapping(value = "findall", method = RequestMethod.GET, produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
    public ResponseEntity<Iterable<CreateRecord>> findAll() {
        try {
            return new ResponseEntity<Iterable<CreateRecord>>(createRecordService.findAll(), HttpStatus.OK );
        } catch (Exception e) {
            return new ResponseEntity<Iterable<CreateRecord>>(HttpStatus.BAD_REQUEST);
        }
    }

}