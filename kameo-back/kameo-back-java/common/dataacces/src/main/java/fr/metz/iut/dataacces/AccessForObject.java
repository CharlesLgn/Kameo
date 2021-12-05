package fr.metz.iut.dataacces;

import java.lang.annotation.*;

/**
 * When a classe inherit {@link DAO}, you need to add this annotation to tell
 * which {@link PersistentStorage} is link to the {@link DAO}.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AccessForObject {

  Class<? extends PersistentStorage> type();
}
