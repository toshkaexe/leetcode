package creational.abstractFabric.banking;

import creational.abstractFabric.Developer;

public class JavaDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("JAVA developer writes JavaCode");
    }
}
