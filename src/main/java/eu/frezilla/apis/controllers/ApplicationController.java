package eu.frezilla.apis.controllers;

import eu.frezilla.apis.datas.AppInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/application")
@RestController
public class ApplicationController {
    
    @Value("${project.description}") private String description;
    @Value("${project.name}")  private String name;
    @Value("${project.version}") private String version;
    
    @GetMapping
    public AppInfo getInfo() {
        return new AppInfo(name, description, version);
    }
    
}
