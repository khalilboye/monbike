package com.sid.monbike.dto;

import javax.validation.constraints.NotNull;
import java.util.List;

public class ClientServiceDto {

    @NotNull
    private ClientDto clientView;

    private List<ServiceDto> serviceViews;

    public ClientDto getClientView() {
        return clientView;
    }

    public void setClientView(ClientDto clientView) {
        this.clientView = clientView;
    }

    public List<ServiceDto> getServiceViews() {
        return serviceViews;
    }

    public void setServiceViews(List<ServiceDto> serviceViews) {
        this.serviceViews = serviceViews;
    }
}
