/**
 *
 * Copyright 2015 CREATE-NET
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

import java.util.HashMap;

/**
 *
 * @author Luca Capra <luca.capra@create-net.org>
 */
public class Broker extends BaseBean
{
    
    public String internal_protocol;
    public String internal_host;
    public String internal_port;
    public String internal_username;
    public String internal_password;
        
    public Broker() {
    }

    public HashMap<String, String> asList() {
        HashMap<String, String> map = new HashMap<>();
        
        map.put("host", internal_host);
        map.put("protocol", internal_protocol);
        map.put("port", internal_port);
        map.put("username", internal_username);
        map.put("password", internal_password);

        return map;
    }
    
    public String getInternal_protocol() {
        return internal_protocol;
    }

    public void setInternal_protocol(String internal_protocol) {
        this.internal_protocol = internal_protocol;
    }

    public String getInternal_host() {
        return internal_host;
    }

    public void setInternal_host(String internal_host) {
        this.internal_host = internal_host;
    }

    public String getInternal_port() {
        return internal_port;
    }

    public void setInternal_port(String internal_port) {
        this.internal_port = internal_port;
    }

    public String getInternal_username() {
        return internal_username;
    }

    public void setInternal_username(String internal_username) {
        this.internal_username = internal_username;
    }

    public String getInternal_password() {
        return internal_password;
    }

    public void setInternal_password(String internal_password) {
        this.internal_password = internal_password;
    }
    
}
