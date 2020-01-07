package forkJoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

public class Main {
  public static void main(String[] args) throws InterruptedException {
    ForkJoinPool pool = new ForkJoinPool();
    IntSum task = new IntSum(3);
    long sum = pool.invoke(task);
    System.out.println("Sum is " + sum);
    pool.awaitTermination(10, TimeUnit.SECONDS);
    pool.shutdown();
  }
}

class IntSum extends RecursiveTask<Long> {
  private int count;
  public IntSum(int count) {
    this.count = count;
  }

  @Override
  protected Long compute() {
    long result = 0L;

    if (this.count <= 0) {
      return 0L;
    }else if (this.count == 1) {
      return (long) this.getRandomInteger();
    }
    List<RecursiveTask<Long>> forks = new ArrayList<>();
    for (int i = 0; i < this.count; i++) {
      IntSum subTask = new IntSum(1);
      subTask.fork(); // Launch the subtask
      forks.add(subTask);
    }
    // all subtasks finish and combine the result
    for (RecursiveTask<Long> subTask : forks) {
      result += subTask.join();
    }
    return result;
  }

  public int getRandomInteger() {
    return 2;
  }
}