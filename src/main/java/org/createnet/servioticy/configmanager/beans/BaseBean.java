/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.createnet.servioticy.configmanager.beans;

import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.createnet.servioticy.configmanager.exception.ConfigPropertyNotFound;


/**
 *
 * @author Luca Capra <luca.capra@create-net.org>
 */
class BaseBean
{

    public String get(String fieldName) throws ConfigPropertyNotFound
    {

        Field field = null;

        try {
            field = this.getClass().getDeclaredField(fieldName);
        } catch (NoSuchFieldException ex) {
            Logger.getLogger(BaseBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(BaseBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        if(field == null) {
            throw new ConfigPropertyNotFound();
        }

        field.setAccessible(true);

        String value = null;

        try {
            value = (String) field.get(this);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(BaseBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BaseBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        if(value == null) {
            throw new ConfigPropertyNotFound();
        }

        return value;
    }

}
