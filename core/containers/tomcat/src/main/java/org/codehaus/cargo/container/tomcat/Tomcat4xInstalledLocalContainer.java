/*
 * ========================================================================
 *
 * Copyright 2003-2004 The Apache Software Foundation. Code from this file 
 * was originally imported from the Jakarta Cactus project.
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
package org.codehaus.cargo.container.tomcat;

import java.io.File;
import java.io.FileNotFoundException;

import org.codehaus.cargo.container.configuration.LocalConfiguration;
import org.codehaus.cargo.container.spi.jvm.JvmLauncher;
import org.codehaus.cargo.container.tomcat.internal.AbstractCatalinaInstalledLocalContainer;

/**
 * Special container support for the Apache Tomcat 4.x servlet container.
 */
public class Tomcat4xInstalledLocalContainer extends AbstractCatalinaInstalledLocalContainer
{
    /**
     * Unique container id.
     */
    public static final String ID = "tomcat4x";

    /**
     * {@inheritDoc}
     * @see AbstractCatalinaInstalledLocalContainer#AbstractCatalinaInstalledLocalContainer(org.codehaus.cargo.container.configuration.LocalConfiguration)
     */
    public Tomcat4xInstalledLocalContainer(LocalConfiguration configuration)
    {
        super(configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getId()
    {
        return ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName()
    {
        return "Tomcat " + getVersion("4.x");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doStart(JvmLauncher java) throws Exception
    {
        File commonLibDirectory = new File(getHome(), "common/lib");
        if (!commonLibDirectory.isDirectory())
        {
            throw new FileNotFoundException("directory " + commonLibDirectory + " does not exist");
        }
        java.addClasspathEntries(commonLibDirectory.listFiles());

        super.doStart(java);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void invokeContainer(String action, JvmLauncher java) throws Exception
    {
        String base = getFileHandler().getAbsolutePath(getConfiguration().getHome());
        java.setSystemProperty("catalina.home", getFileHandler().getAbsolutePath(getHome()));
        java.setSystemProperty("catalina.base", base);
        java.setSystemProperty("java.io.tmpdir",
            getFileHandler().append(base, "temp"));
        java.addClasspathEntries(new File(getHome(), "bin/bootstrap.jar"));
        addToolsJarToClasspath(java);
        java.setMainClass("org.apache.catalina.startup.Bootstrap");
        java.addAppArguments(action);
        java.start();
    }
}
