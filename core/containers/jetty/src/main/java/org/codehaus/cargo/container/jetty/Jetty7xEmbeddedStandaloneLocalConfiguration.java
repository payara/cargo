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
package org.codehaus.cargo.container.jetty;

import org.codehaus.cargo.container.LocalContainer;
import org.codehaus.cargo.container.configuration.ConfigurationCapability;
import org.codehaus.cargo.container.jetty.internal.Jetty7xEmbeddedStandaloneLocalConfigurationCapability;

/**
 * A mostly canned configuration for an embedded Jetty 7.x instance.
 */
public class Jetty7xEmbeddedStandaloneLocalConfiguration extends
    Jetty6xEmbeddedStandaloneLocalConfiguration
{
    /**
     * capabilities supported by this config.
     */
    private static ConfigurationCapability capability =
        new Jetty7xEmbeddedStandaloneLocalConfigurationCapability();

    /**
     * {@inheritDoc}
     * @see Jetty6xEmbeddedStandaloneLocalConfiguration#Jetty6xEmbeddedStandaloneLocalConfiguration(String)
     */
    public Jetty7xEmbeddedStandaloneLocalConfiguration(String dir)
    {
        super(dir);

        addXmlReplacement(
            "etc/webdefault.xml",
            "//servlet/init-param/param-name[text()='useFileMappedBuffer']/../param-value",
            null, JettyPropertySet.USE_FILE_MAPPED_BUFFER);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConfigurationCapability getCapability()
    {
        return capability;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void activateLogging(LocalContainer container)
    {
        getLogger().info("Jetty 7.x log configuration not implemented", this.getClass().getName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString()
    {
        return "Jetty 7.x Embedded Standalone Configuration";
    }
}
