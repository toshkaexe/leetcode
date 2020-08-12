package creational;

public class Program {

    public static void main(String[] args) {

        //JavaDeveloper javaDeveloper = new JavaDeveloper();
        //javaDeveloper.writeJavaCode();

        //    CppDeveloper cppDeveloper = new CppDeveloper();
        //cppDeveloper.writeCppCode()
        //Developer developer =  new JavaDeveloper();
        //  developer.writeCode();

        //    Developer cppdeveloper =  new CppDeveloper();
        //      cppdeveloper.writeCode();


        //
        // DeveloperFactory developerFactory = new JavaDeveloperFactory();
        DeveloperFactory developerFactory = createDeveloperBySpeciality("c++jo");
        Developer developer = developerFactory.createDeveloper();
        developer.writeCode();
    }

    static DeveloperFactory createDeveloperBySpeciality(String spesialty) {
        if (spesialty.equalsIgnoreCase("java")) {
            return new JavaDeveloperFactory();}
        else if (spesialty.equalsIgnoreCase("c++")) {
            return new CppDeveloperFactory();}
        else {
            throw new RuntimeException(spesialty + " is unknown");
        }
    };


}
