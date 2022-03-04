package com.bbva.pzic.proposals.v0.processtasks.facade.mapper.impl;

import com.bbva.jee.arq.spring.core.catalog.gabi.ServiceResponse;
import com.bbva.pzic.proposals.v0.processtasks.EntityMock;
import com.bbva.pzic.proposals.v0.processtasks.business.dto.InputListProcessTasksProposals;
import com.bbva.pzic.proposals.v0.processtasks.dao.apx.mapper.IApxIProcessTasksProposalsMapper;
import com.bbva.pzic.proposals.v0.processtasks.dao.apx.mapper.impl.ApxListProcessTasksProposalsMapper;
import com.bbva.pzic.proposals.v0.processtasks.dao.model.ppcutge1_1.RespuestaTransaccionPpcutge1_1;
import com.bbva.pzic.proposals.v0.processtasks.facade.dto.ProcessTasks;
import com.bbva.pzic.proposals.v0.processtasks.facade.mapper.IListProcessTasksProposalsMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ListProcessTasksProposalsMapperTest {

    private IListProcessTasksProposalsMapper mapper;
    private IApxIProcessTasksProposalsMapper apxIProcessTasksProposalsMapper;


    @Before
    public void setUp(){
        mapper = new ListProcessTasksProposalsMapper();
        apxIProcessTasksProposalsMapper=new ApxListProcessTasksProposalsMapper();
    }

    @Test
    public void mapInFullTest() throws IOException {
        InputListProcessTasksProposals input= EntityMock.getInstance().getInputlistProcessTasksProposals();

        InputListProcessTasksProposals result = mapper.mapIn(input.getBusinessProcessId(),input.getTaskId());

        assertNotNull(result);
        assertNotNull(result.getBusinessProcessId());
        assertNotNull(result.getTaskId());

        assertEquals(input.getBusinessProcessId(),result.getBusinessProcessId());
        assertEquals(input.getTaskId(),result.getTaskId());
    }
    @Test
    public void mapInEmptyTest() throws IOException {

        InputListProcessTasksProposals result = mapper.mapIn(null,null);

        assertNotNull(result);
        assertNull(result.getBusinessProcessId());
        assertNull(result.getTaskId());
    }


    @Test
    public void mapOutFullTest() throws IOException {
        RespuestaTransaccionPpcutge1_1 input = EntityMock.getInstance().getRespuestaTraccionPpcutge1_1();
        ProcessTasks ps= apxIProcessTasksProposalsMapper.mapOut(input);

        ServiceResponse<ProcessTasks> result = mapper.mapOut(ps);

        assertNotNull(result);
        assertNotNull(result.getData().getBusinessProcessId());
        assertNotNull(result.getData().getTaskId());
        assertNotNull(result.getData().getStatus().getId());
        assertNotNull(result.getData().getStatus().getDescription());

        assertEquals(ps.getBusinessProcessId(),result.getData().getBusinessProcessId());
        assertEquals(ps.getTaskId(),result.getData().getTaskId());
        assertEquals(ps.getStatus().getId(),result.getData().getStatus().getId());
        assertEquals(ps.getStatus().getDescription(),result.getData().getStatus().getDescription());
    }
    @Test
    public void mapOutEmptyTest() throws IOException {

        ServiceResponse<ProcessTasks> result = mapper.mapOut(new ProcessTasks());

        assertNotNull(result);
        assertNull(result.getData().getBusinessProcessId());
        assertNull(result.getData().getTaskId());
        assertNull(result.getData().getStatus());
    }
    @Test
    public void mapOutNullTest() throws IOException {

        ServiceResponse<ProcessTasks> result = mapper.mapOut(null);

        assertNull(result);
    }
}