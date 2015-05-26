/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.createnet.servioticy.configmanager.beans;

/**
 *
 * @author Luca Capra <luca.capra@create-net.org>
 */
public class Auth extends BaseBean
{

    public String type;
    public String sqlitedb;

    public String token_url;

    public String idm_host;
    public String idm_port;
    public String idm_user;
    public String idm_password;

    public Auth() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSqlitedb() {
        return sqlitedb;
    }

    public void setSqlitedb(String sqlitedb) {
        this.sqlitedb = sqlitedb;
    }

    public String getToken_url() {
        return token_url;
    }

    public void setToken_url(String token_url) {
        this.token_url = token_url;
    }

    public String getIdm_host() {
        return idm_host;
    }

    public void setIdm_host(String idm_host) {
        this.idm_host = idm_host;
    }

    public String getIdm_port() {
        return idm_port;
    }

    public void setIdm_port(String idm_port) {
        this.idm_port = idm_port;
    }

    public String getIdm_user() {
        return idm_user;
    }

    public void setIdm_user(String idm_user) {
        this.idm_user = idm_user;
    }

    public String getIdm_password() {
        return idm_password;
    }

    public void setIdm_password(String idm_password) {
        this.idm_password = idm_password;
    }

}
