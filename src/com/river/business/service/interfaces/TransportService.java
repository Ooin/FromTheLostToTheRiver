package com.river.business.service.interfaces;

import com.river.entity.Transport;

public interface TransportService extends Service<Transport> {

	public Transport readWithInitializedLineslist(Transport transport);

}
