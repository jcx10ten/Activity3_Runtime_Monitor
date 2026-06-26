package co.edu.udistrital.model;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

public class MemoMonitor {
    private JvmConnector jvmConnector;

    public MemoMonitor(JvmConnector jvmConnector) {
        this.jvmConnector = jvmConnector;
    }

    public MemoData leerMemoria() throws Exception {
        MBeanServerConnection conn = jvmConnector.getConnection();

        MemoryMXBean memBean = ManagementFactory.newPlatformMXBeanProxy(
            conn,
            ManagementFactory.MEMORY_MXBEAN_NAME,
            MemoryMXBean.class
        );

        MemoryUsage heap = memBean.getHeapMemoryUsage();
        MemoryUsage nonHeap = memBean.getNonHeapMemoryUsage();

        String hora = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        return new MemoData(
            heap.getUsed() / (1024 * 1024),
            heap.getMax() / (1024 * 1024),
            nonHeap.getUsed() / (1024 * 1024),
            hora
        );
    }
}
