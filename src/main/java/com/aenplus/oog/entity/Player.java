package com.aenplus.oog.entity;

import com.aenplus.oog.engine.ResponseEngine;

public class Player {

	private String name;
	private ResponseEngine responseEngine;

	public void setName(final String name) {
		this.name = name;
	}

	public void setResponseEngine(final ResponseEngine responseEngine) {
		this.responseEngine = responseEngine;
	}

	public String getName() {
		return this.name;
	}

	public ResponseEngine getResponseEngine() {
		return this.responseEngine;
	}
}
