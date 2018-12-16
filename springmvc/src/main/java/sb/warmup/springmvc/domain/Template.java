package sb.warmup.springmvc.domain;

import lombok.Data;

/**
 * Template
 */
@Data
public class Template {

  private String keyword;
	private String dataSource;
	private String[] params;
	private String query;
}