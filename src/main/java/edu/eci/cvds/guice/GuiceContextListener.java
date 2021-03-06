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
import edu.eci.cvds.sampleprj.dao.ElementoDAO;
import edu.eci.cvds.sampleprj.dao.LaboratorioDAO;
import edu.eci.cvds.sampleprj.dao.NovedadDAO;

import edu.eci.cvds.sampleprj.dao.UsersDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.MyBATISElementoDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.MyBATISLaboratorioDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.MyBATISNovedadDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.MyBatisUsuarioDao;



public class GuiceContextListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		ServletContext servletContext = servletContextEvent.getServletContext();
		servletContext.removeAttribute(Injector.class.getName());
	}

	public void contextInitialized(ServletContextEvent servletContextEvent) {
		Injector injector = Guice.createInjector(new XMLMyBatisModule() {
			@Override
			protected void initialize() {

				install(JdbcHelper.PostgreSQL);

				setEnvironmentId("development");

				setClassPathResource("mybatis-config.xml");

		
				bind(ServiceHistorialEquipos.class).to(ServiceHistorialEquiposImpl.class);

                                bind(NovedadDAO.class).to(MyBATISNovedadDAO.class);
                                bind(ElementoDAO.class).to(MyBATISElementoDAO.class);
                                bind(UsersDAO.class).to(MyBatisUsuarioDao.class);
                                bind(LaboratorioDAO.class).to(MyBATISLaboratorioDAO.class);
			}
		}

		);

		ServletContext servletContext = servletContextEvent.getServletContext();
		servletContext.setAttribute(Injector.class.getName(), injector);
	}

}
