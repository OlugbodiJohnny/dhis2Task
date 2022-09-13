package com.johnny.dhis2task.web.rest;

import com.johnny.dhis2task.payload.OrgUnitCreationRequest;
import com.johnny.dhis2task.payload.OrgUnitRequest;
import com.johnny.dhis2task.service.Dhis2Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hisp.dhis.model.OrgUnit;
import org.hisp.dhis.model.OrgUnitGroup;
import org.hisp.dhis.response.object.ObjectResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class Dhis2Controller {

    private  final Dhis2Service dhis2Service;

    @GetMapping("/v1/get-all-org-unit-groups")
    public ResponseEntity<List<OrgUnitGroup>> getAllOrgUnitGroups() {
       return ResponseEntity.ok().body(dhis2Service.getAllOrgUnitGroups());
    }

    @GetMapping("/v1/get-all-org-units")
    public ResponseEntity<List<OrgUnit>> getAllOrgUnits() {
        return ResponseEntity.ok().body(dhis2Service.getAllOrgUnits());
    }

    @PostMapping("/v1/get-single-org-unit-by-identifier")
    public ResponseEntity<OrgUnit> getSingleOrgUnitByIdentifier(@RequestBody OrgUnitRequest orgUnitRequest) {
        return ResponseEntity.ok().body(dhis2Service.getSingleOrgUnitByIdentifier(orgUnitRequest));
    }

    @PostMapping("/v1/create-org-unit")
    public ResponseEntity<ObjectResponse> createOrgUnit(@RequestBody OrgUnitCreationRequest orgUnitCreationRequest) throws MalformedURLException {
        return ResponseEntity.ok().body(dhis2Service.createOrgUnit(orgUnitCreationRequest));
    }
}
