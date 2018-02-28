package ${pkg}.util;

/**
 *
 * @author wallace
 */
public class Config {
  public static final String JENV = System.getProperty("jenv", "development");
  public static final boolean JENV_TEST = JENV.equals("test");
  public static final boolean JENV_DEVELOPMENT = JENV.equals("development");
  public static final boolean JENV_PRODUCTION = JENV.equals("production");
}
