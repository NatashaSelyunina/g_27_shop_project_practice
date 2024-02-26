package de.aittr.g_27_shop_project_practice.scheduling;

import de.aittr.g_27_shop_project_practice.domain.jpa.JpaProduct;
import de.aittr.g_27_shop_project_practice.domain.jpa.Task;
import de.aittr.g_27_shop_project_practice.repositories.jpa.JpaProductRepository;
import de.aittr.g_27_shop_project_practice.services.jpa.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

@Component
@EnableScheduling
@EnableAsync
public class ScheduleExecutor {
    private static Logger logger = LoggerFactory.getLogger(ScheduleExecutor.class);
    private TaskService taskService;
    private JpaProductRepository repository;

    public ScheduleExecutor(TaskService taskService, JpaProductRepository repository) {
        this.taskService = taskService;
        this.repository = repository;
    }

//    @Scheduled(fixedDelay = 5000)
//    public void fixedDelayTask() {
//        taskService.createTask("Fixed delay task");
//    }

//    @Scheduled(fixedDelay = 5000)
//    public void fixedDelayTask() {
//        taskService.createTask("Fixed delay task 3000 ms");
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }

//    @Scheduled(fixedDelay = 5000)
//    public void fixedDelayTask() {
//        taskService.createTask("Fixed delay task 7000 ms");
//        try {
//            Thread.sleep(7000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }

//    @Scheduled(fixedRate = 5000)
//    public void fixedRateTask() {
//        taskService.createTask("Fixed rate task 3000 ms");
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }

//    @Scheduled(fixedRate = 5000)
//    public void fixedRateTask() {
//        taskService.createTask("Fixed rate task 7000 ms");
//        try {
//            Thread.sleep(7000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }

//    @Scheduled(fixedRate = 5000)
//    @Async
//    public void fixedRateAsyncTask() {
//        taskService.createTask("Fixed rate async task 7000 ms");
//        try {
//            Thread.sleep(7000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }

//    @Scheduled(fixedDelay = 5000, initialDelay = 20000)
//    public void initialDelayTask() {
//        taskService.createTask("Initial delay task");
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    // 2 часа - 7 200 000 миллисекунд
//    // 7200000 -> PT02H (период времени 2 часа)
//    @Scheduled(fixedDelayString = "PT03S")
//    public void anotherDelayFormat() {
//        taskService.createTask("Another delay format task");
//    }

//    @Scheduled(fixedDelayString = "${interval}")
//    public void delayInPropertyTask() {
//        taskService.createTask("Delay in property task");
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }

    // 55 * * * * * - каждую минуту в 55 секунд
    // 0 0 8,10 * * * - каждый день в 8 и в 10 часов
    // 0 15 9-17 * * MON-FRI - 9.15, 10.15, 11.15... 17.15 с понедельника по пятницу

//    @Scheduled(cron = "5-10 * * * * *")
//    public void cronExpressionTask() {
//        taskService.createTask("Cron expression task");
//    }

//    public static void scheduleTaskExecution(Task task) {
//        TaskScheduler scheduler = new DefaultManagedTaskScheduler();
//        scheduler.schedule(
//                () -> logger.info(task.getDescription()),
//                new CronTrigger("0,10,20,30,40,50 * * * * *")
//        );
//    }

//    public static void scheduleTaskExecution(Task task) {
//        TaskScheduler scheduler = new DefaultManagedTaskScheduler();
//        Instant instant = Instant.now().plusSeconds(30);
//        scheduler.schedule(() -> logger.info(task.getDescription()),
//                instant);
//    }

    @Scheduled(fixedRate = 30000)
    @Async
    public void scheduleLastFiveTask() {
        List<Task> tasks = taskService.getLastFiveTask();
        System.out.println("Последние пять задач:");
        for (Task task : tasks) {
            System.out.println(String.format("Задача '%s', время выполнения - %s",
                    task.getDescription(), task.getExecutedAt()));
        }
    }

    @Scheduled(cron = "15,45 * * * * *")
    public void scheduleLastProductBd() {
        String nameProduct = repository.getNameLastProduct();
        taskService.createTask(String.format("Последний добавленный в БД продукт - %s", nameProduct));
    }
}