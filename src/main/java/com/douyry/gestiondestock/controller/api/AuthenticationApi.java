package com.douyry.gestiondestock.controller.api;

import com.douyry.gestiondestock.dto.auth.AuthenticationRequest;
import com.douyry.gestiondestock.dto.auth.AuthenticationResponse;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.douyry.gestiondestock.utils.Constants.AUTHENTICATION_ENDPOINT;

@Api("authentication")
public interface AuthenticationApi {

  @PostMapping(AUTHENTICATION_ENDPOINT + "/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request);

}
