package com.demo.springshelldemo.cmd;

import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;

@ShellComponent
public class DynamicCommands {

    private boolean connected;

    @ShellMethod("Connect to the server.")
    public void connect(String user, String password) {
       
        connected = true;
    }

    @ShellMethod("Download the nuclear codes.")
    public void download() {
      
    }

    public Availability downloadAvailability() {
        return connected
            ? Availability.available()
            : Availability.unavailable("you are not connected");
    }
    @ShellMethod("Download the nuclear codes.")
    @ShellMethodAvailability("uploadCheck") 
    public void upload() {


    }

    public Availability uploadCheck() { 
        return connected
            ? Availability.available()
            : Availability.unavailable("you are not connected");
    }
    
    @ShellMethod("Download the nuclear codes.")
    public void download1() {
     
    }

    @ShellMethod("Disconnect from the server.")
    public void disconnect1() {
       
    }

    @ShellMethodAvailability({"download1", "disconnect1"})
    public Availability availabilityCheck() {
        return connected
            ? Availability.available()
            : Availability.unavailable("you are not connected");
    }
}