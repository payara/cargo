/*
 * ========================================================================
 *
 * Codehaus CARGO, copyright 2004-2011 Vincent Massol, 2012-2020 Ali Tokmen.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ========================================================================
 */
package org.codehaus.cargo.sample.maven2.autoDeployable_test;

import java.net.URL;

import junit.framework.TestCase;

import org.codehaus.cargo.sample.java.PingUtils;
import org.codehaus.cargo.util.log.Logger;
import org.codehaus.cargo.util.log.SimpleLogger;

/**
 * Test the Maven2/Maven3 auto-deloyable.
 */
public class AutoDeployableTest extends TestCase
{

    /**
     * Logger.
     */
    private Logger logger = new SimpleLogger();

    /**
     * Test the Maven2/Maven3 auto-deloyable.
     * @throws Exception If anything fails.
     */
    public void testAutoDeployable() throws Exception
    {
        final URL url = new URL("http://localhost:" + System.getProperty("http.port")
            + "/cargo-sample-maven2-autoDeployable-test/");
        final String expected = "Sample page for testing";

        PingUtils.assertPingTrue(url.getPath() + " not started", expected, url, logger);
    }

}
