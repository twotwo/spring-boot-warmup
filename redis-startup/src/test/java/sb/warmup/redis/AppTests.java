package sb.warmup.redis;

import lombok.extern.slf4j.Slf4j;

import org.junit.Rule;
import org.junit.Test;

import org.springframework.boot.test.rule.OutputCapture;

import org.springframework.data.redis.RedisConnectionFailureException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link App}.
 */
@Slf4j
public class AppTests {

	@Rule
	public OutputCapture outputCapture = new OutputCapture();

	@Test
	public void testDefaultSettings() throws Exception {
		try {
			App.main(new String[0]);
		} catch (Exception ex) {
			if (!redisServerRunning(ex)) {
				return;
			}
		}
		String output = this.outputCapture.toString();
		log.debug(output);
		assertThat(output).contains("Found key warmup:redis.test");
	}

	private boolean redisServerRunning(Throwable ex) {
		System.out.println(ex.getMessage());
		if (ex instanceof RedisConnectionFailureException) {
			return false;
		}
		return (ex.getCause() == null || redisServerRunning(ex.getCause()));
	}

}