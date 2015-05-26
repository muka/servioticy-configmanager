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
public class Couchbase extends BaseBean
{


    public String public_uris;
    public String private_uris;
    public String so_bucket;
    public String updates_bucket;
    public String subscriptions_bucket;
    public String actuations_bucket;
    public String private_bucket;

    public Couchbase() {
    }

    public String getPublic_uris() {
        return public_uris;
    }

    public void setPublic_uris(String public_uris) {
        this.public_uris = public_uris;
    }

    public String getPrivate_uris() {
        return private_uris;
    }

    public void setPrivate_uris(String private_uris) {
        this.private_uris = private_uris;
    }

    public String getSo_bucket() {
        return so_bucket;
    }

    public void setSo_bucket(String so_bucket) {
        this.so_bucket = so_bucket;
    }

    public String getUpdates_bucket() {
        return updates_bucket;
    }

    public void setUpdates_bucket(String updates_bucket) {
        this.updates_bucket = updates_bucket;
    }

    public String getSubscriptions_bucket() {
        return subscriptions_bucket;
    }

    public void setSubscriptions_bucket(String subscriptions_bucket) {
        this.subscriptions_bucket = subscriptions_bucket;
    }

    public String getActuations_bucket() {
        return actuations_bucket;
    }

    public void setActuations_bucket(String actuations_bucket) {
        this.actuations_bucket = actuations_bucket;
    }

    public String getPrivate_bucket() {
        return private_bucket;
    }

    public void setPrivate_bucket(String private_bucket) {
        this.private_bucket = private_bucket;
    }

}
