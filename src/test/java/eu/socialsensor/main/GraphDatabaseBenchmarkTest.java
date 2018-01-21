package eu.socialsensor.main;

import static org.junit.Assert.fail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class GraphDatabaseBenchmarkTest
{
    private static final Logger logger = LogManager.getLogger();

    @Test
    public void testGraphDatabaseBenchmark()
    {
        logger.debug("debug level enabled.");
        logger.debug("info level enabled.");

        GraphDatabaseBenchmark bench = new GraphDatabaseBenchmark(null /* inputPath */);
        try{
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
