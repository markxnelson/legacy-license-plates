package com.oracle.rest;

// ------------------------------------------------------------------------
// -- DISCLAIMER:
// --    This code is provided for educational purposes only. It is NOT
// --    supported by Oracle World Wide Technical Support.
// --    The code has been tested and appears to work as intended.
// --    You should always run new scripts on a test instance initially.
// --
// ------------------------------------------------------------------------

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("rest")
public class LicensePlateApplication extends Application {
    public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<Class<?>>();
        s.add(LicensePlateRestService.class);
        return s;
    }
}
