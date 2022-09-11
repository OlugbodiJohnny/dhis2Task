package com.johnny.dhis2task.serviceImpl;

import com.johnny.dhis2task.payload.OrgUnitCreationRequest;
import com.johnny.dhis2task.payload.OrgUnitRequest;
import com.johnny.dhis2task.service.Dhis2Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hisp.dhis.Dhis2;
import org.hisp.dhis.model.OrgUnit;
import org.hisp.dhis.model.OrgUnitGroup;
import org.hisp.dhis.model.Program;
import org.hisp.dhis.model.SystemSettings;
import org.hisp.dhis.query.Query;
import org.hisp.dhis.response.object.ObjectResponse;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class Dhis2ServiceImpl implements Dhis2Service {

    private final Dhis2 dhis2;

    private final Query query;

    @Override
    public List<OrgUnitGroup> getAllOrgUnitGroups() {
        List<OrgUnitGroup> orgUnitGroupList = dhis2.getOrgUnitGroups(query);
        log.info("{}",orgUnitGroupList);
        return orgUnitGroupList;
    }

    @Override
    public List<OrgUnit> getAllOrgUnits() {
        List<OrgUnit> orgUnitList = dhis2.getOrgUnits(query);
        log.info("{}",orgUnitList);
        return orgUnitList;
    }

    @Override
    public List<OrgUnit> getAllOrgUnitGroupsWithFilterAndPaging() {
        return null;
    }

    @Override
    public List<OrgUnit> getAllOrgUnitGroupsDescPropName() {
        return null;
    }

    @Override
    public List<Program> retrieveListOfProgramsWithAssociations() {
        return null;
    }

    @Override
    public OrgUnit getSingleOrgUnitByIdentifier(OrgUnitRequest orgUnitRequest) {
        OrgUnit orgUnit = dhis2.getOrgUnit(orgUnitRequest.getId());
        log.info("{}",orgUnit);
        return orgUnit;
    }

    @Override
    public ObjectResponse createOrgUnit(OrgUnitCreationRequest orgUnitCreationRequest) throws MalformedURLException {

        OrgUnit orgUnit = new OrgUnit();
        orgUnit.setCode(orgUnitCreationRequest.getCode());
        orgUnit.setName(orgUnitCreationRequest.getName());
        orgUnit.setShortName(orgUnitCreationRequest.getShortName());
        orgUnit.setDescription(orgUnitCreationRequest.getDescription());
        orgUnit.setLevel(orgUnitCreationRequest.getLevel());
        orgUnit.setParent(orgUnitCreationRequest.getParent());
        orgUnit.setOpeningDate(orgUnitCreationRequest.getOpeningDate());
        orgUnit.setClosedDate(orgUnitCreationRequest.getCloseDate());
        orgUnit.setComment(orgUnitCreationRequest.getComment());
        if (!orgUnitCreationRequest.getUrl().equals("")) {
//            URL url = new URL("");
            orgUnit.setUrl(orgUnitCreationRequest.getUrl());
        }
        orgUnit.setContactPerson(orgUnitCreationRequest.getContactPerson());
        orgUnit.setAddress(orgUnitCreationRequest.getAddress());
        orgUnit.setEmail(orgUnitCreationRequest.getEmail());
        orgUnit.setPhoneNumber(orgUnitCreationRequest.getPhoneNumber());

        ObjectResponse objectResponse = dhis2.saveOrgUnit( orgUnit );
        log.info("{}",objectResponse);

        return objectResponse;
    }

    @Override
    public ObjectResponse createMultipleOrgUnit() {
        return null;
    }

    @Override
    public ObjectResponse updateOrgUnit() {
        return null;
    }

    @Override
    public ObjectResponse removeOrgUnit() {
        return null;
    }

    @Override
    public SystemSettings getSystemSetting() {
        return null;
    }
}
