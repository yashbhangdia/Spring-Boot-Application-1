package com.javabycode.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;

@SpringBootApplication
public class MyWebApplication extends SpringBootServletInitializer{
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MyWebApplication.class);
    }

    public static void main(String[] args) throws Exception {
//         System.out.println(InetAddress.getLocalHost().getHostAddress());
        ArrayList<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
        for (NetworkInterface iface : interfaces)
        {
            for (InterfaceAddress addr : iface.getInterfaceAddresses()) 
            {
                System.out.println("\t\t" + addr.getAddress().toString());
            } 
        }
        
        
        SpringApplication.run(MyWebApplication.class, args);
    }
}

