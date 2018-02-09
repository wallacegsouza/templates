package ${pkg}.util;

/**
 *
 * @author wallace
 */
public class Config {
  public static final String JENV;
  public static final boolean JENV_TEST;
  public static final boolean JENV_DEVELOPMENT;
  public static final boolean JENV_PRODUCTION;

  static {
    JENV = System.getProperty("jenv", "development");
    JENV_TEST = JENV.equals("test");
    JENV_DEVELOPMENT = JENV.equals("development");
    JENV_PRODUCTION = JENV.equals("production");
  }
}
