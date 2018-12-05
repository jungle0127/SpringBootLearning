package com.ps.shell.command;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent(value = "Command for demo")
public class CertUtilCommand {
    @ShellMethod(value = "add numbers", key = "sum")
    public int add(int a, int b) {
        return a + b;
    }
    @ShellMethod(value = "Display stuff.", prefix="-")
    public String echo(int a, int b, @ShellOption(value = {"--third","-t"},defaultValue = "9") int c) {
        return String.format("You said a=%d, b=%d, c=%d", a, b, c);
    }
}
