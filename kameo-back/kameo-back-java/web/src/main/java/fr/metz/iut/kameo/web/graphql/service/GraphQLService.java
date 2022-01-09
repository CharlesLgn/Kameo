package fr.metz.iut.kameo.web.graphql.service;

import fr.metz.iut.kameo.web.graphql.schema.GraphQLSchemaBuilder;
import fr.metz.iut.kameo.web.graphql.schema.GraphQuery;
import graphql.ExecutionResult;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class GraphQLService {

  @PostMapping("graphql")
  public ExecutionResult runQuery(@RequestBody GraphQuery query) {
    return GraphQLSchemaBuilder.getInstance().run(query);
  }

  @GetMapping("graphql")
  public ExecutionResult getQuery(@RequestParam("operationName") String operationName, @RequestParam("query") String query, @RequestParam("variables") String variables) {
    return runQuery(new GraphQuery(operationName, query, variables));
  }
}
