package leetcode.demo.threads;

import java.util.concurrent.Semaphore;

public class SemaphoreTask {
    private Semaphore semaphore;
    private static SemaphoreTask instance;

    private SemaphoreTask(int maxConnections) {
        // Определяем семафор с максимальным количеством соединений
        semaphore = new Semaphore(maxConnections, true);
    }

    public static SemaphoreTask getInstance(int maxConnections) {
        if (instance == null) {
            instance = new SemaphoreTask(maxConnections);
        }
        return instance;
    }
    public void queryDatabase() {
        try {
            // Запрашиваем разрешение на доступ
            semaphore.acquire();
            System.out.println("Thread " + Thread.currentThread().getName() + " geted access to the DB");
            // Здесь выполняется код обращения к базе данных
            Thread.sleep(2000); // Имитация обращения к базе данных
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Thread " + Thread.currentThread().getName() + " finishd acces to the DB");
            // Освобождаем разрешение
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        final int MAX_CONNECTIONS = 7;
        SemaphoreTask database = SemaphoreTask.getInstance(MAX_CONNECTIONS);

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                database.queryDatabase();
            });
            thread.start();
        }
    }
}
