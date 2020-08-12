package creational.abstractFabric.banking;

import creational.abstractFabric.ProjectManager;

public class BankingPM implements ProjectManager {
    @Override
    public void manageProject() {
        System.out.println("Banking PM manages Bankings projects");
    }
}
