package com.johnny.dhis2task.service;

import com.johnny.dhis2task.payload.OrgUnitCreationRequest;
import com.johnny.dhis2task.payload.OrgUnitRequest;
import org.hisp.dhis.Dhis2;
import org.hisp.dhis.model.OrgUnit;
import org.hisp.dhis.model.OrgUnitGroup;
import org.hisp.dhis.model.Program;
import org.hisp.dhis.model.SystemSettings;
import org.hisp.dhis.response.object.ObjectResponse;

import java.net.MalformedURLException;
import java.util.List;

public interface Dhis2Service {

 List<OrgUnitGroup> getAllOrgUnitGroups();

 List<OrgUnit> getAllOrgUnits();

 List<OrgUnit> getAllOrgUnitGroupsWithFilterAndPaging();

 List<OrgUnit> getAllOrgUnitGroupsDescPropName();

 List<Program> retrieveListOfProgramsWithAssociations();

 OrgUnit getSingleOrgUnitByIdentifier(OrgUnitRequest orgUnitRequest);

 ObjectResponse createOrgUnit(OrgUnitCreationRequest orgUnitCreationRequest) throws MalformedURLException;

 ObjectResponse createMultipleOrgUnit();

 ObjectResponse updateOrgUnit();

 ObjectResponse removeOrgUnit();

 SystemSettings getSystemSetting ();




}
