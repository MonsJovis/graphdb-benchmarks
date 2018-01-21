package eu.socialsensor.main;

import static org.junit.Assert.fail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class GraphDatabaseBenchmarkTest
{
    Log log = LogFactory.getLog(GraphDatabaseBenchmarkTest.class);
    @Test
    public void testGraphDatabaseBenchmark()
    {

        GraphDatabaseBenchmark bench = new GraphDatabaseBenchmark(null /* inputPath */);
        try{
            log.debug("debug level enabled.");
            bench.run();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            fail("Got unexpected exception: " + e.getMessage());
        }

        //bench.cleanup();
    }
}
