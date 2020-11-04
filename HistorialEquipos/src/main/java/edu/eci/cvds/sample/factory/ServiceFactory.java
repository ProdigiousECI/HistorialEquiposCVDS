/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sample.factory;

import static com.google.inject.Guice.createInjector;
import com.google.inject.Injector;
import edu.eci.cvds.sample.services.ServiceHistorialEquipos;
import edu.eci.cvds.sample.services.impl.ServiceHistorialEquiposImpl;
import edu.eci.cvds.sampleprj.dao.ElementoDAO;
import edu.eci.cvds.sampleprj.dao.NovedadDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.MyBATISElementoDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.MyBATISNovedadDAO;

import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

/**
 *
 * @author javie
 */
public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    
    private static Injector injector;
    
    public ServiceFactory(){
        injector = createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize(){
                install(JdbcHelper.PostgreSQL);
                setClassPathResource("mybatis-config.xml");
                bind(ServiceHistorialEquipos.class).to(ServiceHistorialEquiposImpl.class);
                bind(ElementoDAO.class).to(MyBATISElementoDAO.class);
                bind(NovedadDAO.class).to(MyBATISNovedadDAO.class);
            }
        }
        );
    }
    public ServiceHistorialEquipos getServiceHistorialEquipos(){
        return injector.getInstance(ServiceHistorialEquipos.class);
    }
    public static ServiceFactory getInstance(){
        return instance;
    }
}
