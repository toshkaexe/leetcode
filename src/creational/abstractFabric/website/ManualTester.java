package creational.abstractFabric.website;

import creational.abstractFabric.Tester;

public class ManualTester implements Tester {
    @Override
    public void testCode() {
        System.out.println("Manual tester tests web site");
    }
}
