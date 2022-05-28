package blackbox;

import org.junit.runners.Suite;
import org.junit.runner.RunWith;


@RunWith(Suite.class)
@Suite.SuiteClasses({ApostaTestes.class, UsuarioTestes.class, PartidaTestes.class})
public class AllTestsAposta {
}