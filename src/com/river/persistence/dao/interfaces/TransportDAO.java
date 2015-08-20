package com.river.persistence.dao.interfaces;

import com.river.entity.Transport;

public interface TransportDAO extends DAO<Transport> {

	public Transport readWithInitializedLineslist(Transport transport);

}
