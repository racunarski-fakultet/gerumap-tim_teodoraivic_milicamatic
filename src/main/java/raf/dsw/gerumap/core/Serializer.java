package raf.dsw.gerumap.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import raf.dsw.gerumap.repository.implementation.Project;

import java.io.File;
import java.io.IOException;

public interface Serializer {

    Project loadProject(File file) throws IOException;
    void saveProject(Project node) throws IOException;
}
