package com.bbva.pzic.proposals.v0.processtasks.business.dto;

import com.bbva.pzic.proposals.v0.processtasks.util.ValidationGroup;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class InputListProcessTasksProposals {

    @NotNull(groups = ValidationGroup.ListProcessTasksProposals.class)
    private String businessProcessId;
    private String taskId;

    @Valid
    @NotNull(groups = ValidationGroup.ListProcessTasksProposals.class)
    private DTOIntStatus status;
    public String getBusinessProcessId() {
        return businessProcessId;
    }

    public void setBusinessProcessId(String businessProcessId) {
        this.businessProcessId = businessProcessId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
}
