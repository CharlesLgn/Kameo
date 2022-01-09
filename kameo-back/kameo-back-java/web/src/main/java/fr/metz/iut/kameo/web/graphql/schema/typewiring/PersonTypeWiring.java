package fr.metz.iut.kameo.web.graphql.schema.typewiring;

import fr.metz.iut.film.structure.Actor;
import fr.metz.iut.film.structure.Director;
import fr.metz.iut.film.structure.Person;
import graphql.TypeResolutionEnvironment;
import graphql.schema.GraphQLObjectType;
import graphql.schema.TypeResolver;
import graphql.schema.idl.TypeRuntimeWiring;

import java.util.function.Supplier;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

/**
 * Specification of the data fetchers and possible type resolver for {@link Person} type.
 */
public class PersonTypeWiring implements Supplier<TypeRuntimeWiring> {

  @Override
  public TypeRuntimeWiring get() {
    return newTypeWiring("Person").typeResolver(new PersonTypeResolver())
                                  .build();
  }

  /**
   * Specification of possible type resolver for {@link Person} type.
   * It is used to know if a {@link Person} is an {@link Actor} or a {@link Director}.
   */
  private static class PersonTypeResolver implements TypeResolver {
    @Override
    public GraphQLObjectType getType(TypeResolutionEnvironment env) {
      Person person = env.getObject();
      return env.getSchema().getObjectType(person.getClass().getTypeName());
    }
  }
}
