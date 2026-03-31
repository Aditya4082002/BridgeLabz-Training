package scenario;

import java.util.*;

//Custom Exception
class InvalidBackupPathException extends Exception {
 public InvalidBackupPathException(String message) {
     super(message);
 }
}

//BackupTask
class BackupTask implements Comparable<BackupTask> {

 String folderPath;
 int priority;   // higher number = higher priority
 String scheduleTime;

 public BackupTask(String folderPath, int priority, String scheduleTime)
         throws InvalidBackupPathException {

     if (folderPath == null || folderPath.trim().isEmpty()) {
         throw new InvalidBackupPathException("Invalid backup path!");
     }

     this.folderPath = folderPath;
     this.priority = priority;
     this.scheduleTime = scheduleTime;
 }

 // Higher priority should come first
 @Override
 public int compareTo(BackupTask other) {
     return Integer.compare(other.priority, this.priority);
 }

 @Override
 public String toString() {
     return "BackupTask{" +
             "folder='" + folderPath + '\'' +
             ", priority=" + priority +
             ", time='" + scheduleTime + '\'' +
             '}';
 }
}

//File Backup Scheduler
public class FileBackupScheduler {

 private PriorityQueue<BackupTask> taskQueue = new PriorityQueue<>();

 // Add backup task
 public void scheduleBackup(BackupTask task) {
     taskQueue.add(task);
     System.out.println("Backup scheduled: " + task.folderPath);
 }

 // Execute backups in priority order
 public void executeBackups() {
     System.out.println("\nExecuting Backup Tasks (Priority Order):");

     while (!taskQueue.isEmpty()) {
         BackupTask task = taskQueue.poll();
         System.out.println("Backing up folder: " +
                 task.folderPath +
                 " | Priority: " + task.priority +
                 " | Time: " + task.scheduleTime);
     }
 }

 public static void main(String[] args) {

     FileBackupScheduler scheduler = new FileBackupScheduler();

     try {
         scheduler.scheduleBackup(
                 new BackupTask("/system/config", 5, "01:00 AM")); // critical
         scheduler.scheduleBackup(
                 new BackupTask("/user/documents", 3, "02:00 AM"));
         scheduler.scheduleBackup(
                 new BackupTask("/media/photos", 1, "03:00 AM"));

         // Invalid path
         scheduler.scheduleBackup(
                 new BackupTask("", 4, "01:30 AM"));

     } catch (InvalidBackupPathException e) {
         System.out.println(e.getMessage());
     }

     scheduler.executeBackups();
 }
}
