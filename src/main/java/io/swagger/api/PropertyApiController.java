package io.swagger.api;

import io.swagger.model.DataBaseObjects;
import io.swagger.model.PropertyBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-10-01T20:14:45.365242941Z[GMT]")
@RestController
public class PropertyApiController implements PropertyApi {
    @Autowired
    DataBaseObjects ObjBase;

    private static final Logger log = LoggerFactory.getLogger(PropertyApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public PropertyApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<ArrayList<DataBaseObjects.RentalProperty>> propertyGet() {
        String accept = request.getHeader("Accept");
        ArrayList<DataBaseObjects.RentalProperty> objects = new ArrayList<>();
        for (Map.Entry<String, DataBaseObjects.RentalProperty> obj : ObjBase.getObjects()){
            objects.add(obj.getValue());
        }
        return ResponseEntity.ok(objects);
    }

    public ResponseEntity<DataBaseObjects.RentalProperty> propertyPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody PropertyBody body) {
        String accept = request.getHeader("Accept");
        String street = body.getStreet();
        BigDecimal price = body.getPrice();
        Integer montlyrent = body.getmonthlyRent();
        if (ObjBase.getObj(street) == null){
            ObjBase.addProperty(street, montlyrent, price);
            return new ResponseEntity<DataBaseObjects.RentalProperty>(ObjBase.getObj(street), HttpStatus.CREATED);
        }
        return new ResponseEntity<DataBaseObjects.RentalProperty>(HttpStatus.CONFLICT);
    }

    public ResponseEntity<Void> propertyDelete(@RequestBody PropertyBody body) {
        String accept = request.getHeader("Accept");
        String street = body.getStreet();
        if (ObjBase.getObj(street) != null){
            ObjBase.remove(street);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<DataBaseObjects.RentalProperty> propertyStreetGet(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("street") String street) {
        String accept = request.getHeader("Accept");
        System.out.println(street);
        if (ObjBase.getObj(street) != null){
            return ResponseEntity.ok(ObjBase.getObj(street));
        }
        return new ResponseEntity<DataBaseObjects.RentalProperty>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<DataBaseObjects.RentalProperty> propertyStreetPut(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody PropertyBody body) {
        String accept = request.getHeader("Accept");
        String street = body.getStreet();
        System.out.println(body);
        BigDecimal price = body.getPrice();
        Integer montlyrent = body.getmonthlyRent();
        if (ObjBase.getObj(street) != null){
            ObjBase.put_obj(street, price, montlyrent);
            return new ResponseEntity<DataBaseObjects.RentalProperty>(ObjBase.getObj(street), HttpStatus.OK);
        }
        return new ResponseEntity<DataBaseObjects.RentalProperty>(HttpStatus.NOT_FOUND);
    }

}
