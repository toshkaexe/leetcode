package creational.abstractFabric.website;

import creational.abstractFabric.Developer;
import creational.abstractFabric.ProjectManager;
import creational.abstractFabric.ProjectTeamFactory;
import creational.abstractFabric.Tester;

public class WebSiteTeamFactory implements ProjectTeamFactory {
    @Override
    public Developer getDeveloper() {
        return new PhpDeveloper();
    }

    @Override
    public Tester getTester() {
        return new ManualTester();
    }

    @Override
    public ProjectManager getProjectManager() {
        return new WebSitePM();
    }
}
