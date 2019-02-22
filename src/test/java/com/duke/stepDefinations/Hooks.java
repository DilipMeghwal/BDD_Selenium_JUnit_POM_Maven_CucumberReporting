package com.duke.stepDefinations;

import java.io.IOException;
import com.duke.base.BaseClass;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	//@Before("@TestFeature")
	public void before() throws IOException {
		BaseClass.setUp();
	}
	//@After("@TestFeature")
	public void after() {
		BaseClass.tearDown();
	}
}
