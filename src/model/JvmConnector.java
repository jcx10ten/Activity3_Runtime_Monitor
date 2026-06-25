package model;

import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

public class JvmConnector {
    private JMXConnector connector;
    private MBeanServerConnection connection;

    public void conectar(String host, int port) throws Exception {
        String url = "service:jmx:rmi:///jndi/rmi://" + host + ":" + port + "/jmxrmi";
        connector = JMXConnectorFactory.connect(new JMXServiceURL(url));
        connection = connector.getMBeanServerConnection();
    }

    public MBeanServerConnection getConnection() {
        return connection;
    }

    public void desconectar() throws Exception {
        if (connector != null) connector.close();
    }

    public boolean estaConectado() {
        return connection != null;
    }
}
