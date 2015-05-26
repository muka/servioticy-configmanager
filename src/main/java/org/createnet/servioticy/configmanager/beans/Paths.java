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
public class Paths extends BaseBean
{

    public String defaultQueue;
    public String defaultActions;
    public String reputationq;
    public String dispatcher;

    /** generated */

    public Paths() {
    }

    public String getDefaultQueue() {
        return defaultQueue;
    }

    public void setDefaultQueue(String defaultQueue) {
        this.defaultQueue = defaultQueue;
    }

    public String getDefaultActions() {
        return defaultActions;
    }

    public void setDefaultActions(String defaultActions) {
        this.defaultActions = defaultActions;
    }

    public String getReputationq() {
        return reputationq;
    }

    public void setReputationq(String reputationq) {
        this.reputationq = reputationq;
    }

    public String getDispatcher() {
        return dispatcher;
    }

    public void setDispatcher(String dispatcher) {
        this.dispatcher = dispatcher;
    }

    

}
