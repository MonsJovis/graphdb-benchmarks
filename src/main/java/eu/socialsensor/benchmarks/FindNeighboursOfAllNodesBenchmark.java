package eu.socialsensor.benchmarks;

import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;

import com.google.common.base.Stopwatch;

import eu.socialsensor.graphdatabases.GraphDatabase;
import eu.socialsensor.main.BenchmarkConfiguration;
import eu.socialsensor.main.BenchmarkType;
import eu.socialsensor.main.GraphDatabaseType;
import eu.socialsensor.utils.Utils;
import org.apache.logging.log4j.Logger;

/**
 * FindNeighboursOfAllNodesBenchmark implementation
 * 
 * @author sotbeis, sotbeis@iti.gr
 * @author Alexander Patrikalakis
 */
public class FindNeighboursOfAllNodesBenchmark extends PermutingBenchmarkBase implements RequiresGraphData
{
    private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger();

    public FindNeighboursOfAllNodesBenchmark(BenchmarkConfiguration config)
    {
        super(config, BenchmarkType.FIND_NEIGHBOURS);
    }

    @Override
    public void benchmarkOne(GraphDatabaseType type, int scenarioNumber)
    {
        GraphDatabase<?,?,?,?> graphDatabase = Utils.createDatabaseInstance(bench, type);
        graphDatabase.open();
        Stopwatch watch = new Stopwatch();
        watch.start();
        graphDatabase.findAllNodeNeighbours();
        graphDatabase.shutdown();
        times.get(type).add((double) watch.elapsed(TimeUnit.MILLISECONDS));
    }
}
