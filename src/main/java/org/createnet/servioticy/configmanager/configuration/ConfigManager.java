/**
 *
 * Copyright 2014 CREATE-NET
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.createnet.servioticy.configmanager.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.createnet.servioticy.configmanager.beans.Configuration;
import org.createnet.servioticy.configmanager.exception.ConfigPropertyNotFound;
import org.createnet.servioticy.configmanager.exception.ConfigurationFileNotFound;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

/**
 *
 * @author Luca Capra <luca.capra@create-net.org>
 */
public class ConfigManager implements IConfigurationManager, Serializable
{
        
    String _defaultSource = "/etc/servioticy";
    String _defaultFile = "config.yml";

    String defaultSource;
    String defaultFile;

    String defaultProperties = "/config.properties";
    String defaultConfiguration = "/default.yml";

    Configuration config;
    static HashMap<String, String> resolvedCache = new HashMap<>();
    
    public static void main(String [] args) throws ConfigPropertyNotFound
    {

        ConfigManager m = ConfigManager.getInstance();
        String x = m.get("couchbase.public_uris");

        System.out.println("Loaded config ----------------------------");
        System.out.println(x);

    }

    private static ConfigManager instance;

    public static synchronized ConfigManager getInstance() {

        if(instance == null) {
            instance = new ConfigManager();
        }

        return instance;
    }

    private ConfigManager() {

        Properties props = new Properties();

        try {

            props.load(ConfigManager.class.getResourceAsStream(defaultProperties));

            defaultSource = props.getProperty("source", _defaultSource);
            defaultFile = props.getProperty("file", _defaultFile);

        } catch (Exception ex) {

            Logger.getLogger(ConfigManager.class.getName()).log(Level.WARNING, "Cannot read properties file {0}", defaultProperties);

            defaultSource = _defaultSource;
            defaultFile = _defaultFile;

        }

    }

    protected void load() throws ConfigurationFileNotFound
    {

        InputStream input;

        // try to load config specified configuration
        // eg. public-api.config.yml
        Logger.getLogger(ConfigManager.class.getName()).log(Level.INFO, "Load configuration, checking {0}", getFilePath());
        input = this.tryLoad(getFilePath());

        if(input == null) {
            String defConf = _defaultSource + "/" + _defaultFile;
            Logger.getLogger(ConfigManager.class.getName()).log(Level.INFO, "Trying default configuration {0}", defConf);
            input = this.tryLoad(defConf);
        }

        if(input == null) {
            Logger.getLogger(ConfigManager.class.getName()).log(Level.INFO, "Using jar configuration file {0}", defaultConfiguration);
            input = ConfigManager.class.getResourceAsStream(defaultConfiguration);
        }

        if(input == null) {
            throw new ConfigurationFileNotFound();
        }

        Constructor constructor = new Constructor(Configuration.class);
        Yaml yaml = new Yaml(constructor);

        this.config = (Configuration) yaml.load(input);
    }

    protected FileInputStream tryLoad(String filename) {
        try {
            return new FileInputStream(new File(getFilePath()));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConfigManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    protected String getFilePath() {
        return defaultSource + "/" + defaultFile;
    }

    public String getPath() {
        return defaultSource;
    }

    public int getOpIdExpiration() {
        return 5 * 60;
    }
    
    public Configuration getConfiguration() throws ConfigurationFileNotFound
    {

        if(config == null) {
            load();
        }

        return config;
    }

    public String get(String key)
    {

        String value = null;

        try {
            value = getConfiguration().get(key);
        } catch (ConfigPropertyNotFound ex) {
            Logger.getLogger(ConfigManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ConfigurationFileNotFound ex) {
            Logger.getLogger(ConfigManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return value;
    }
    
    public int getInt(String key)
    {
        String sval = this.get(key);
        return (sval != null) ? Integer.parseInt(sval) : null;
    }

    /**
     * Resolve a path as specified in `paths` in the configuration file
     *
     * @throws ConfigPropertyNotFound
     * @param key The config key to lookup
     * @return the FS path
     */
    public String getPath(String key) throws ConfigPropertyNotFound
    {

        if(resolvedCache.containsKey(key)) {
            return resolvedCache.get(key);
        }

        String configPath = this.getPath();
        String name = config.paths.get(key);

        // check if the values specified is a path and exists
        File file = new File(name);
        if(file.exists()) {

            String filepath = file.getAbsolutePath();
            resolvedCache.put(name, filepath);

            return filepath;
        }
        else {
            // check if the path is relative
            file = new File(configPath + "/" + name);

            if(file.exists()) {

                String filepath = file.getAbsolutePath();
                resolvedCache.put(name, filepath);

                return filepath;
            }
        }

        // defaults to stored name, lookup as jar resource
        resolvedCache.put(name, name);
        return name;
    }    
    
}
