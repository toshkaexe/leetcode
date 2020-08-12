package creational.abstractFabric.website;

import creational.abstractFabric.ProjectManager;

public class WebSitePM implements ProjectManager {
    @Override
    public void manageProject() {
        System.out.println("Website PM managers Website projects...");
    }
}
