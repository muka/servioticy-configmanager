/**
 *
 * Copyright 2014 CREATE-NET
 * 
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

package org.createnet.servioticy.configmanager.beans;

import org.createnet.servioticy.configmanager.exception.ConfigPropertyNotFound;

/**
 *
 * @author Luca Capra <luca.capra@create-net.org>
 */
public class Configuration {

    public Paths paths;
    public Couchbase couchbase;
    public Auth auth;
    public Elasticsearch elasticsearch;
    public Logs logs;

    public Configuration() {}

    public String get(String key) throws ConfigPropertyNotFound
    {

        String[] splitKey = key.split("\\.");

        if(splitKey.length < 2) {
            throw new ConfigPropertyNotFound();
        }

        String baseKey = splitKey[0];
        String inKey = splitKey[1];

        switch(baseKey) {
            case "couchbase":
                return this.couchbase.get(inKey);
            case "auth":
                return this.auth.get(inKey);
            case "elasticsearch":
                return this.elasticsearch.get(inKey);
            case "paths":
                return this.paths.get(inKey);
            case "logs":
                return this.logs.get(inKey);
        }

        throw new ConfigPropertyNotFound();
    }

    /* generated */

    public Paths getPaths() {
        return paths;
    }

    public void setPaths(Paths paths) {
        this.paths = paths;
    }

    public Couchbase getCouchbase() {
        return couchbase;
    }

    public void setCouchbase(Couchbase couchbase) {
        this.couchbase = couchbase;
    }

    public Auth getAuth() {
        return auth;
    }

    public void setAuth(Auth auth) {
        this.auth = auth;
    }

    public Elasticsearch getElasticsearch() {
        return elasticsearch;
    }

    public void setElasticsearch(Elasticsearch elasticsearch) {
        this.elasticsearch = elasticsearch;
    }

    public Logs getLogs() {
        return logs;
    }

    public void setLogs(Logs logs) {
        this.logs = logs;
    }

}
