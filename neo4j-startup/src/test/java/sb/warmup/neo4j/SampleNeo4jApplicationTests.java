package sb.warmup.neo4j;

import java.net.ConnectException;

import org.junit.Rule;
import org.junit.Test;

import org.springframework.boot.test.rule.OutputCapture;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link SampleNeo4jApplication}.
 *
 * @author Stephane Nicoll
 */
public class SampleNeo4jApplicationTests {

	@Rule
	public OutputCapture outputCapture = new OutputCapture();

	@Test
	public void testDefaultSettings() throws Exception {
		try {
			SampleNeo4jApplication.main(new String[0]);
		}
		catch (Exception ex) {
			if (!neo4jServerRunning(ex)) {
				return;
			}
		}
		String output = this.outputCapture.toString();
		assertThat(output).contains("firstName='Alice', lastName='Smith'");
	}

	private boolean neo4jServerRunning(Throwable ex) {
		System.out.println(ex.getMessage());
		if (ex instanceof ConnectException) {
			return false;
		}
		return (ex.getCause() == null || neo4jServerRunning(ex.getCause()));
	}

}