package com.river.business.service.interfaces;

import com.river.entity.Rafter;

public interface RafterService extends Service<Rafter> {
	public Rafter readWithInitializedRateslist(Rafter rafter);
	public Rafter readWithInitializedRouteslist(Rafter rafter);
}
