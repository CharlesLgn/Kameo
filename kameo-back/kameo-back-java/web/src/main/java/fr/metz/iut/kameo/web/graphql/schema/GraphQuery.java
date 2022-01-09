package fr.metz.iut.kameo.web.graphql.schema;

/** GraphQL query representation. */
public record GraphQuery(String operationName, String query, String variables) { }
