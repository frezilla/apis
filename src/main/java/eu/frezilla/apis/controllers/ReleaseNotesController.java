package eu.frezilla.apis.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import eu.frezilla.apis.datas.release.ReleaseNotes;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/release-notes")
@RestController
public class ReleaseNotesController {
    
    @Autowired private ResourceLoader resourceLoader;
    
    @GetMapping
    public ReleaseNotes get() throws IOException {
        
        Resource resource = resourceLoader.getResource("classpath:release-notes.yml");
        
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules();
        return mapper.readValue(resource.getFile(), ReleaseNotes.class);
    }
    
}
