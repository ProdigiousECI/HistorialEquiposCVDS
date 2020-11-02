package edu.eci.cvds.guice;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import com.google.inject.Guice;
import com.google.inject.Injector;

import edu.eci.cvds.sample.services.ServiceHistorialEquipos;
import edu.eci.cvds.sample.services.impl.ServiceHistorialEquiposImpl;
import edu.eci.cvds.sampleprj.dao.NovedadDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.MyBATISNovedadDAO;



public class GuiceContextListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		ServletContext servletContext = servletContextEvent.getServletContext();
		servletContext.removeAttribute(Injector.class.getName());
	}

	public void contextInitialized(ServletContextEvent servletContextEvent) {
		Injector injector = Guice.createInjector(new XMLMyBatisModule() {
			@Override
			protected void initialize() {

				install(JdbcHelper.MySQL);

				setEnvironmentId("development");

				setClassPathResource("mybatis-config.xml");

		
				bind(ServiceHistorialEquipos.class).to(ServiceHistorialEquiposImpl.class);
                bind(NovedadDAO.class).to(MyBATISNovedadDAO.class);

			}
		}

		);

		ServletContext servletContext = servletContextEvent.getServletContext();
		servletContext.setAttribute(Injector.class.getName(), injector);
	}

}
