package org.javacream;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("app.properties")
@EnableAspectJAutoProxy(proxyTargetClass=true)
@ComponentScan(basePackages="org.javacream")
public class ApplicationConfiguration {

}
