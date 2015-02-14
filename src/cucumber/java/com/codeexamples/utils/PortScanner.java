package com.codeexamples.utils;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class PortScanner {
  private static int discoveredPort = 0;

  private PortScanner() {
  }

  public static int getPort() {
    if (discoveredPort != 0) {
      return discoveredPort;
    }

    String host = "localhost";
    InetAddress inetAddress = null;
    try {
      inetAddress = InetAddress.getByName(host);
    } catch (UnknownHostException e) {
      throw new RuntimeException(e);
    }

    String hostName = inetAddress.getHostName();
    Socket socket = null;

    for (int port = 8000; port <= 9000; port++) {
      try {
        socket = new Socket(hostName, port);
        socket.close();
      } catch (IOException e) {
        discoveredPort = port;
        return discoveredPort;
      }
    }

    if (discoveredPort == 0) {
      throw new IllegalStateException("No ports available in the range 8000 - 9000 for tomcat to start");
    }

    return discoveredPort;
  }
}
