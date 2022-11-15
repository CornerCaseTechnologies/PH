/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.35).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.MandateTriplet;
import io.swagger.model.MandatesToAdd;
import io.swagger.model.Problem;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-11-15T06:24:27.699Z[GMT]")
@Validated
public interface RepresenteesApi {

    @Operation(summary = "Add mandates to a delegate under a representee", description = "Kui liidestuv süsteem pakub seda teenust Pääsukesele, siis lubab Pääsuke oma kasutajaliidese kaudu volitusi anda ja selle teenuse abil Pääsuke edastab uued volitused liidestunud süsteemile.  Pääsuke pakub ka ise seda teenust liidestunud klientidele, kes hoiavad oma volitusi Pääsukeses. Teenuse kasutamine on vajalik juhul kui partnerasutus kasutab Pääsukest oma volituste süsteemina, aga keegi isik tuleb partnerasutusse (notariaalse volikirjaga) ja selle alusel tuleb partnerasutusel Pääsukesse sisse kanda volikirjal olevad volitused partnerasutuse nimeruumi. ", tags={ "Kõik teenused", "Pääsukese poolt pakutav", "Pääsukesele pakutav (lisaks)" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "202", description = "Accepted for processing"),
        
        @ApiResponse(responseCode = "400", description = "Incorrect format of the payload.", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Problem.class)))),
        
        @ApiResponse(responseCode = "403", description = "You are not owner of the namespace."),
        
        @ApiResponse(responseCode = "404", description = "Delegate doesn't have anything matching to remove"),
        
        @ApiResponse(responseCode = "422", description = "Unprocessable request. For example system doesn't know about the namespace.", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Problem.class)))) })
    @RequestMapping(value = "/representees/{representee}/delegates/{delegate}/mandates",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> addMandatesToDelegate(@Parameter(in = ParameterIn.PATH, description = "Person code or company code of the representee", required=true, schema=@Schema()) @PathVariable("representee") String representee, @Parameter(in = ParameterIn.PATH, description = "Person code or company code of the delegate", required=true, schema=@Schema()) @PathVariable("delegate") String delegate, @Parameter(in = ParameterIn.DEFAULT, description = "Enter details of the mandate(s)", schema=@Schema()) @Valid @RequestBody MandatesToAdd body);


    @Operation(summary = "List active mandates of the delegate", description = "Usually this endpoint is called after the user selects a legal entity who the delegate want's to represent at the given session. ", tags={ "Kõik teenused", "Pääsukese poolt pakutav" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Matching mandates that are granted to the delegate for this representee", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MandateTriplet.class))),
        
        @ApiResponse(responseCode = "400", description = "bad input parameter"),
        
        @ApiResponse(responseCode = "422", description = "Unprocessable request. For example system doesn't know about the namespace.", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Problem.class)))) })
    @RequestMapping(value = "/representees/{representee}/delegates/{delegate}/mandates",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<MandateTriplet> getRepresenteeDelegateWithMandates(@Parameter(in = ParameterIn.PATH, description = "Person code or company code of the representee", required=true, schema=@Schema()) @PathVariable("representee") String representee, @Parameter(in = ParameterIn.PATH, description = "Person code or company code of the delegate", required=true, schema=@Schema()) @PathVariable("delegate") String delegate, @Parameter(in = ParameterIn.HEADER, description = "Filter by namespace (comma separated)" ,schema=@Schema()) @RequestHeader(value="namespace", required=false) String namespace, @Parameter(in = ParameterIn.HEADER, description = "Filter by role (comma separated)" ,schema=@Schema()) @RequestHeader(value="roles", required=false) String roles);


    @Operation(summary = "List delegates with mandates", description = "Returns list of delegates who have any mandates.  Protos: Ettevõtte esindajad ja volitatud isikud.  Kui Väikefirma (representee) on andnud Raamatupidamisfirmale (subDelegatedBy) mingi rolli koos edasivolitamise (edasidelegeerimise) õigusega, siis saab Raamatupidamisfirma selle parameetri abil küsida, kellele tema omakorda on vastava volituse edasi volitanud (delegeerinud). ", tags={ "Kõik teenused", "Pääsukesele pakutav" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Matching mandates that are granted to delegates for this representee", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = MandateTriplet.class)))),
        
        @ApiResponse(responseCode = "400", description = "bad input parameter"),
        
        @ApiResponse(responseCode = "422", description = "Unprocessable request. For example system doesn't know about the namespace.", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Problem.class)))) })
    @RequestMapping(value = "/representees/{representee}/delegates/mandates",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<MandateTriplet>> getRepresenteeDelegatesWithMandates(@Parameter(in = ParameterIn.PATH, description = "Person code or company code of the representee", required=true, schema=@Schema()) @PathVariable("representee") String representee, @Parameter(in = ParameterIn.HEADER, description = "Filter by namespace (comma separated)" ,schema=@Schema()) @RequestHeader(value="namespace", required=false) String namespace, @Parameter(in = ParameterIn.HEADER, description = "Filter by subdelegator (edasivolitaja) code" ,schema=@Schema()) @RequestHeader(value="subDelegatedBy", required=false) String subDelegatedBy, @Parameter(in = ParameterIn.HEADER, description = "Filter out delegates who don't have any of the roles in the list. This parameter is only used if the service is provided by Pääsuke and must be ignored by others." ,schema=@Schema()) @RequestHeader(value="hasRoleIn", required=false) String hasRoleIn, @Parameter(in = ParameterIn.HEADER, description = "Skip this number of records for pagination" ,schema=@Schema(allowableValues={  }
)) @RequestHeader(value="skip", required=false) Integer skip, @Parameter(in = ParameterIn.HEADER, description = "Maximum number of records to return" ,schema=@Schema(allowableValues={  }, maximum="500"
)) @RequestHeader(value="limit", required=false) Integer limit);


    @Operation(summary = "Remove a specific role from the delegate", description = "Remove all mandates from the delegate ", tags={ "Kõik teenused", "Pääsukesele pakutav" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Removed sucessfully"),
        
        @ApiResponse(responseCode = "202", description = "Request accepted but not yet removed"),
        
        @ApiResponse(responseCode = "400", description = "Invalid parameter"),
        
        @ApiResponse(responseCode = "403", description = "You are not owner of the namespace."),
        
        @ApiResponse(responseCode = "404", description = "Delegate doesn't have anything matching to remove"),
        
        @ApiResponse(responseCode = "422", description = "Unprocessable request. For example system doesn't know about the namespace.", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Problem.class)))) })
    @RequestMapping(value = "/representees/{representee}/delegates/{delegate}/mandates/{role}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> removeMandateFromDelegate(@Parameter(in = ParameterIn.PATH, description = "Person code or company code of the representee", required=true, schema=@Schema()) @PathVariable("representee") String representee, @Parameter(in = ParameterIn.PATH, description = "Person code or company code of the delegate", required=true, schema=@Schema()) @PathVariable("delegate") String delegate, @Parameter(in = ParameterIn.HEADER, description = "Namespace of the role" ,required=true,schema=@Schema()) @RequestHeader(value="namespace", required=true) String namespace, @Parameter(in = ParameterIn.PATH, description = "Role to delete", required=true, schema=@Schema()) @PathVariable("role") String role);

}

