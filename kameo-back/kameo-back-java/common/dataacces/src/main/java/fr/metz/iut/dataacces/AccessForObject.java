package fr.metz.iut.dataacces;

import java.lang.annotation.*;

import fr.metz.iut.common.utils.dataaccess.PersistentStorage;

/**
 * When a classe inherit {@link DAO}, you need to add this annotation to tell
 * which {@link PersistentStorage} is link to the {@link DAO}.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AccessForObject {

  Class<? extends PersistentStorage> type();
}
