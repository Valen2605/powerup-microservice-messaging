package com.pragma.powerup.messagingmicroservice.adapters.driving.http.controller;


import com.pragma.powerup.messagingmicroservice.adapters.driving.http.handlers.IMessagingHandler;
import com.pragma.powerup.messagingmicroservice.configuration.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/messaging")
@RequiredArgsConstructor
@SecurityRequirement(name = "jwt")
public class MessagingRestController {


    private final IMessagingHandler messagingHandler;

    @Operation(summary = "Send a new message",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Category created",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "Message Error",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error"))),
            })
    @PostMapping("/sendMessage/{number}")
    public ResponseEntity<Map<String, String>> sendMessage(@RequestParam String number, @Valid @RequestBody String message ){
        messagingHandler.sendMessage(message,number);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.MESSAGE_SEND));
    }
}
