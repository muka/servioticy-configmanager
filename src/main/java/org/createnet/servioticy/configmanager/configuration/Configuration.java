/*
 * Copyright 2015 CREATE-NET <http://create-net.org>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.createnet.servioticy.configmanager.configuration;

import java.io.File;

/**
 *
 * @author Luca Capra <luca.capra@gmail.com>
 */
abstract public class Configuration implements IConfiguration {
    
    protected File configurationFile;

    
    @Override
    public File getConfigurationFile() {
        return configurationFile;
    }

    @Override
    public void setConfigurationFile(File configurationFile) {
        this.configurationFile = configurationFile;
    }
    
}
