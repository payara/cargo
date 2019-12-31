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
package org.codehaus.cargo.container.weblogic;

import org.codehaus.cargo.container.property.RemotePropertySet;
import org.codehaus.cargo.container.weblogic.internal.AbstractWebLogicWlstRuntimeConfiguration;

/**
 * WebLogic 10.3.x runtime
 * {@link org.codehaus.cargo.container.spi.configuration.ContainerConfiguration} implementation.
 * WebLogic 10.3.x uses WLST for container deployments.
 */
public class WebLogic103xRuntimeConfiguration extends
    AbstractWebLogicWlstRuntimeConfiguration
{

    /**
     * {@inheritDoc}
     * @see AbstractWebLogicWlstRuntimeConfiguration#AbstractWebLogicWlstRuntimeConfiguration()
     */
    public WebLogic103xRuntimeConfiguration()
    {
        super();

        setProperty(RemotePropertySet.PASSWORD, "weblogic");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString()
    {
        return "WebLogic 10.3.x Runtime Configuration";
    }
}
