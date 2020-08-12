package creational.abstractFabric.banking;

import creational.abstractFabric.Developer;
import creational.abstractFabric.ProjectManager;
import creational.abstractFabric.ProjectTeamFactory;
import creational.abstractFabric.Tester;

public class BankingTeamFactory implements ProjectTeamFactory {
    @Override
    public Developer getDeveloper() {
        return new JavaDeveloper();
    }

    @Override
    public Tester getTester() {
        return new QATester();
    }

    @Override
    public ProjectManager getProjectManager() {
        return new BankingPM();
    }
}
