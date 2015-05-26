
package org.createnet.servioticy.configmanager.beans;

/**
 *
 * @author Luca Capra <luca.capra@create-net.org>
 */
class Logs extends BaseBean
{

    public String log4j_settings;

    /** generated */

    public Logs(String log4j_settings) {
        this.log4j_settings = log4j_settings;
    }

    public String getLog4j_settings() {
        return log4j_settings;
    }

    public void setLog4j_settings(String log4j_settings) {
        this.log4j_settings = log4j_settings;
    }

}
