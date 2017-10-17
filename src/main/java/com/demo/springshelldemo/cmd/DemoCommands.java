package com.demo.springshelldemo.cmd;

import java.util.Locale;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class DemoCommands {
	/*
		shell:>add 1 2
		3
	*/
	@ShellMethod("Add two integers together.")
    public int add(int a, int b) {
        return a + b;
    }


    @ShellMethod(value="Translate text from one language to another.",key="tran")
    public String translate(
      @ShellOption() String text,
      @ShellOption(defaultValue = "en_US") Locale from,
      @ShellOption() Locale to  ) {
      System.out.println("aaa");
      return text + from + to;
    }
    
    /*
	    shell:>echo2 -a 1 -b 2 --third 4
	    You said a=1, b=2, c=4
	    shell:>echo 1 2 3      
	    You said a=1, b=2, c=3
	    shell:>echo --a 1 --b 2 --c 3
	    You said a=1, b=2, c=3
	    shell:>echo --b 2 --c 3 --a 1 
	    You said a=1, b=2, c=3
	    shell:>echo --a 1 2 3 
	    You said a=1, b=2, c=3
	    shell:>echo 1 --c 3 2 
	    You said a=1, b=2, c=3
    */
    @ShellMethod("Display stuff.")
    public String echo(int a, int b, int c) {
            return String.format("You said a=%d, b=%d, c=%d", a, b, c);
    }
    /* 
        shell:>echo2 -a 1 -b 2 --third 4
    	You said a=1, b=2, c=4
    */
    @ShellMethod(value = "Display stuff.", prefix="-")
    public String echo2(int a, int b, @ShellOption("--third") String c) {
            return String.format("You said a=%d, b=%d, c=%s", a, b, c);
    }
    /* 
	    shell:>greet
	    Hello World
    */
    @ShellMethod("Say hello.")
    public String greet(@ShellOption(defaultValue="World") String who) {
            return "Hello " + who;
    }
    /*
	    shell:>add2 1 2 3.3
	    6.3
	    shell:>add2 --numbers 1 2 3.3
	    6.3
    */
    @ShellMethod("Add Numbers.")
    public float add2(@ShellOption(arity=3) float[] numbers) {
            return numbers[0] + numbers[1] + numbers[2];
    }
    /*  
	    shell:>shutdown
	    You said false
	    shell:>shutdown --force
	    You said true    
    */
    @ShellMethod("Terminate the system.")
    public String shutdown(boolean force) {
            return "You said " + force;
    }
}