package pe.com.AutoPago.Purchase.interfaces.rest;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.AutoPago.Purchase.domain.model.queries.GetAllCreditsQuery;
import pe.com.AutoPago.Purchase.domain.model.queries.GetCreditByIdQuery;
import pe.com.AutoPago.Purchase.domain.services.CreditCommandService;
import pe.com.AutoPago.Purchase.domain.services.CreditQueryService;
import pe.com.AutoPago.Purchase.interfaces.rest.resources.CreateCreditResource;
import pe.com.AutoPago.Purchase.interfaces.rest.resources.CreditResource;
import pe.com.AutoPago.Purchase.interfaces.rest.transform.CreateCreditCommandFromResourceAssembler;
import pe.com.AutoPago.Purchase.interfaces.rest.transform.CreditResourceFromEntityAssembler;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/credits", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Credits", description = "credits Management Endpoints")
public class CreditController {
    private final CreditQueryService creditQueryService;
    private final CreditCommandService creditCommandService;

    public CreditController(CreditQueryService creditQueryService, CreditCommandService creditCommandService) {
        this.creditQueryService = creditQueryService;
        this.creditCommandService = creditCommandService;
    }

    @PostMapping
    public ResponseEntity<CreditResource> createCredit(@RequestBody CreateCreditResource resource){
        var createCreditCommand = CreateCreditCommandFromResourceAssembler.toCommandFromResource(resource);

        var creditId = creditCommandService.handle(createCreditCommand);

        if(creditId == 0L) {
            return ResponseEntity.badRequest().build();
        }

        var getCreditIdByQuery = new GetCreditByIdQuery(creditId);
        var credit = creditQueryService.handle(getCreditIdByQuery);

        if(credit.isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        var creditResource = CreditResourceFromEntityAssembler.toResourceFromEntity(credit.get());
        return new ResponseEntity<>(creditResource, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CreditResource>> getAllCredits() {
        var getAllCreditsQuery = new GetAllCreditsQuery();
        var credits = creditQueryService.handle(getAllCreditsQuery);
        var creditsResources= credits.stream().map(CreditResourceFromEntityAssembler::toResourceFromEntity).collect(Collectors.toList());
        return ResponseEntity.ok(creditsResources);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreditResource> getCreditById(@PathVariable Long id) {
        var getCreditByIdQuery = new GetCreditByIdQuery(id);
        var credit = creditQueryService.handle(getCreditByIdQuery);
        if(credit.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var creditResource = CreditResourceFromEntityAssembler.toResourceFromEntity(credit.get());
        return ResponseEntity.ok(creditResource);
    }
}
