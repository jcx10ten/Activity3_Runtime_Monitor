package co.edu.udistrital.model;

import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

public class JvmConnector {

    private JMXConnector connector;
    private MBeanServerConnection connection;

    public void conectarConUrl(String jmxUrl) throws Exception {
        connector = JMXConnectorFactory.connect(new JMXServiceURL(jmxUrl));
        connection = connector.getMBeanServerConnection();
    }

    public MBeanServerConnection getConnection() {
        return connection;
    }

    public void desconectar() throws Exception {
        if (connector != null) {
            connector.close();
        }
    }

    public boolean estaConectado() {
        return connection != null;
    }
}
