package com.company.jmixpm.screen.projecttasks;

import com.company.jmixpm.entity.Project;
import com.company.jmixpm.entity.Task;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.screen.DialogMode;
import io.jmix.ui.screen.Screen;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Nullable;

@DialogMode(width = "800", height = "600", resizable = true)
@UiController("ProjectTasksBrowser")
@UiDescriptor("project-tasks-browser.xml")
public class ProjectTasksBrowser extends Screen {

    @Autowired
    private CollectionLoader<Task> tasksDl;

    public ProjectTasksBrowser withProject(@Nullable Project project) {
        if (project != null) {
            tasksDl.setParameter("projectId", project.getId());
        } else {
            tasksDl.removeParameter("projectId");
        }

        tasksDl.load();

        return this;
    }
}