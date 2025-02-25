package fm.mixer.gateway.test.container;

import org.testcontainers.containers.MongoDBContainer;

public class DatabaseTestContainer extends MongoDBContainer {

    private static volatile DatabaseTestContainer container;

    private DatabaseTestContainer() {
        super("mongo:latest");
    }

    public static DatabaseTestContainer getInstance() {
        if (container == null) {
            synchronized (DatabaseTestContainer.class) {
                if (container == null) {
                    container = new DatabaseTestContainer();
                }
            }
        }

        return container;
    }

    @Override
    public void start() {
        super.start();

        // Sets properties that are referenced in application.yml
        System.setProperty("DATABASE_URL", getReplicaSetUrl());
    }

    @Override
    public void stop() {
        // Do nothing, let JVM handle stop
    }
}
