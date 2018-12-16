package sb.warmup.springmvc.domain;

import lombok.Data;

/**
 * Template
 */
@Data
public class Template {

  private String keyword;
	private String ds;
	private String[] params;
	private String query;

	public DataSource getDataSource() {
		return DataSource.toDataSource(ds);
	}
}