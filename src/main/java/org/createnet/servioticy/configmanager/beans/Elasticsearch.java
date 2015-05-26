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
public class Elasticsearch extends BaseBean
{


    public String elastic_cluster;
    public String type;
    public String search_servers;
    public String search_ports;
    public String transport_server;
    public String transport_port;

    public boolean useNodeClient() {
        return this.getType().equals("node");
    }

    /** generated */
    public Elasticsearch() {
    }

    public String getElastic_cluster() {
        return elastic_cluster;
    }

    public void setElastic_cluster(String elastic_cluster) {
        this.elastic_cluster = elastic_cluster;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSearch_servers() {
        return search_servers;
    }

    public void setSearch_servers(String search_servers) {
        this.search_servers = search_servers;
    }

    public String getSearch_ports() {
        return search_ports;
    }

    public void setSearch_ports(String search_ports) {
        this.search_ports = search_ports;
    }

    public String getTransport_server() {
        return transport_server;
    }

    public void setTransport_server(String transport_server) {
        this.transport_server = transport_server;
    }

    public String getTransport_port() {
        return transport_port;
    }

    public void setTransport_port(String transport_ports) {
        this.transport_port = transport_ports;
    }

}
