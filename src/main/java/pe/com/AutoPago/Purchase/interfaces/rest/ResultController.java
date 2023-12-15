package pe.com.AutoPago.Purchase.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.AutoPago.Purchase.domain.model.queries.GetAllResultsQuery;
import pe.com.AutoPago.Purchase.domain.model.queries.GetResultByIdQuery;
import pe.com.AutoPago.Purchase.domain.services.ResultCommandService;
import pe.com.AutoPago.Purchase.domain.services.ResultQueryService;
import pe.com.AutoPago.Purchase.interfaces.rest.resources.CreateResultResource;
import pe.com.AutoPago.Purchase.interfaces.rest.resources.ResultResource;
import pe.com.AutoPago.Purchase.interfaces.rest.transform.CreateResultCommandFromResourceAssembler;
import pe.com.AutoPago.Purchase.interfaces.rest.transform.ResultResourceFromEntityAssembler;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/results", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Results", description = "Results Management Endpoints")
public class ResultController {
    private final ResultQueryService resultQueryService;
    private final ResultCommandService resultCommandService;

    public ResultController(ResultQueryService resultQueryService, ResultCommandService resultCommandService) {
        this.resultQueryService = resultQueryService;
        this.resultCommandService = resultCommandService;
    }

    @PostMapping
    public ResponseEntity<ResultResource> createResult(@RequestBody CreateResultResource resource){
        var createResultCommand = CreateResultCommandFromResourceAssembler.toCommandFromResource(resource);

        var resultId = resultCommandService.handle(createResultCommand);

        if(resultId == 0L){
            return ResponseEntity.badRequest().build();
        }

        var getResultIdByQuery = new GetResultByIdQuery(resultId);
        var result = resultQueryService.handle(getResultIdByQuery);

        if(result.isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        var resultResource = ResultResourceFromEntityAssembler.toResourceFromEntity(result.get());
        return new ResponseEntity<>(resultResource, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ResultResource>> getAllResults(){
        var getAllResultsQuery = new GetAllResultsQuery();
        var results = resultQueryService.handle(getAllResultsQuery);
        var resultsResources = results.stream().map(ResultResourceFromEntityAssembler::toResourceFromEntity).collect(Collectors.toList());
        return ResponseEntity.ok(resultsResources);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResultResource> getResultById(@PathVariable Long id){
        var getResultByIdQuery = new GetResultByIdQuery(id);
        var result = resultQueryService.handle(getResultByIdQuery);
        if(result.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var resultResource = ResultResourceFromEntityAssembler.toResourceFromEntity(result.get());
        return ResponseEntity.ok(resultResource);
    }
}
